package com.example.springlesson3.repository;

import com.example.springlesson3.domain.Product;
import com.example.springlesson3.interfaces.CategoryDAO;
import com.example.springlesson3.interfaces.ProductDAO;
import com.example.springlesson3.util.SessionFactoryBean;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImp implements ProductDAO {
      private final SessionFactoryBean sessionFactory;

    @Override
    public Product get(int id) {

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

        try (Session session = sessionFactory.getFactoryBean().getCurrentSession()) {
            session.beginTransaction();
            session.persist(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteProduct(int id) {
        Product product = get(id);

        try (Session session = sessionFactory.getFactoryBean().getCurrentSession()) {
            session.beginTransaction();
            session.remove(product);
            session.getTransaction().commit();
        }


    }

    @Override

//todo добавить обработку презагрузки новой картинки.
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


        return product;
    }


}