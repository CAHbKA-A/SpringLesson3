package com.example.springlesson3.repository.specification;
/*обьект создается при запросе/ предикаты- условия*/

import com.example.springlesson3.domain.Product;
import com.example.springlesson3.domain.ProductSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ProductSearchSpecification implements Specification<Product> {

    private final ProductSearch condition;

    @Override
    //условние
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//проверяем запрос
        List<Predicate> predicateList = new ArrayList<>(); //сваливаем все передикаты сюда (все что после select ..where


        if (condition.getMaxCost() != null || condition.getMinCost() != null) {

            Predicate predicate = null;
            if (condition.getMaxCost() != null) {
                //что с чем сравниваем
                predicateList.add(criteriaBuilder.lessThanOrEqualTo(root.get("cost"), condition.getMaxCost()));
            }
            if (condition.getMinCost() != null) {
                predicateList.add(criteriaBuilder.lessThanOrEqualTo(root.get("cost"), condition.getMinCost()));

            }
        }
        if (condition.getIdProductList() != null) {
            predicateList.add(root.get("id").in(condition.getIdProductList()));
        }

        if (condition.getTitle() != null) {

            predicateList.add(criteriaBuilder.equal(root.get("title"), condition.getTitle()));
        }


        //передаем все предикеты

        return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
    }


}

