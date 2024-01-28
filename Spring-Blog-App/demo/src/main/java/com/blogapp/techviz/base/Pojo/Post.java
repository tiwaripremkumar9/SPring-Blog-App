package com.blogapp.techviz.base.Pojo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "post")
@NoArgsConstructor
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private String imageName;

    /*
    In the Post entity, use the @ManyToOne annotation to define the relationship with the Category entity.
    The fetch attribute specifies whether the related Category entity should be fetched eagerly or lazily.
    The JoinColumn annotation specifies the foreign key column in the Post table that maps to the primary key column in the Category table.

    The FetchType.LAZY attribute is used to specify that the related entity should be loaded lazily. This means that the related entity will not be loaded from the database until it is actually accessed by the application.

In the context of the Post and Category entities, if we use FetchType.LAZY for the Category entity in the Post entity, then the Category entity will not be loaded from the database until it is actually accessed by the application. This can help improve performance by reducing the amount of data that needs to be loaded from the database.

On the other hand, if we use FetchType.EAGER for the Category entity in the Post entity, then the Category entity will be loaded eagerly along with the Post entity. This can be useful when we know that we will need the related entity for most of the use cases.
     */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


}
