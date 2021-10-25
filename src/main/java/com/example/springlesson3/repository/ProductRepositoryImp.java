package com.example.springlesson3.repository;

import com.example.springlesson3.domain.Product;
import com.example.springlesson3.interfaces.CategoryRepository;
import com.example.springlesson3.interfaces.ProductRepository;
import com.example.springlesson3.util.SessionFactoryBean;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImp implements ProductRepository {
    private final CategoryRepository categoryRepository;
    private final SessionFactoryBean sessionFactory;

    @Override
    public Product get(int id) {
        //    return ProductDao.findById(id);
        Product product;
        try (Session session = sessionFactory.getFactoryBean().getCurrentSession()) {
            session.beginTransaction();
            product = session.get(Product.class, id);
            session.getTransaction().commit();
        }
        return product;
    }

    @Override
    public List<Product> getAll() {
        //  return ProductDao.findAll();
        List<Product> products;
        try (Session session = sessionFactory.getFactoryBean().getCurrentSession()) {
            session.beginTransaction();
            products = session.createQuery("select p from Product p", Product.class).getResultList();
            session.getTransaction().commit();
        }

        return products;
    }

    @Override
    public void addNew(Product product) {

        //ProductDao.addProduct(product);
        try (Session session = sessionFactory.getFactoryBean().getCurrentSession()) {
            session.beginTransaction();
            session.persist(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteProduct(int id) {
        Product product = get(id);
        //   ProductDao.deleteById(id);
        try (Session session = sessionFactory.getFactoryBean().getCurrentSession()) {
            session.beginTransaction();
            session.remove(product);
            session.getTransaction().commit();
        }


    }

    @Override

//todo добавить обработку презагрузки новвой картинки.
    public Product saveOrUpdate(Product product) {
        System.out.println(product);

        Product productFromDB = get(product.getId());

        // System.out.println(product.equals(productFromDB));
        if (product.equals(productFromDB)) return product;
        try (Session session = sessionFactory.getFactoryBean().getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }


        return null;
    }

    //       em.persist(product);
//       em.getTransaction().commit();
//  Product productFromDB = ProductDao.findById(id);
//        em.getTransaction().begin();
//        Product productFromDB  = em.find(Product.class, id);
//        em.getTransaction().commit();
//        em.getTransaction().begin();
//        em.merge(productFromDB);
//        em.merge(product);

}