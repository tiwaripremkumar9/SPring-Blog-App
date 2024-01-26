package com.blogapp.techviz.base.Pojo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "entities")
@NoArgsConstructor
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "catg_id")
    private Integer categoryId;
    @Column(name = "catg_type", length = 20, nullable = false)
    private String categoryType;
    @Column(name = "catg_desc", length = 200)
    private String categoryDescription;
}
