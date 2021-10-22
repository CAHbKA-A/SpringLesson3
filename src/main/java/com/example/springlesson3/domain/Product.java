package com.example.springlesson3.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*класс хранит только состояние и ни какой бизнеслогики*/
@Data // генератор всего для (гетеры сеттеры, хэш, эквал, тустринг
@Builder //???создавалк обьекта через билдер  Product.builder.id(3L).description ("dfdfd" ).build()
@AllArgsConstructor  //генератор конструтора (все аргументы)
@NoArgsConstructor//генератор конструтора (дефолтный)
public class Product {
    private int id;
    private String title;
    private int cost;
    private String description;
    private Category categoryId;
    private String imgLink;



}
