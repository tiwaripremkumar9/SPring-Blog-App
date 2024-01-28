package com.blogapp.techviz.base.Pojo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "category")
@NoArgsConstructor
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catg_id")
    private Integer categoryId;
    @Column(name = "catg_type", length = 20, nullable = false)
    private String categoryType;
    @Column(name = "catg_desc", length = 200)
    private String categoryDescription;

    /*
    In the Category entity, use the @OneToMany annotation to define the relationship with the Post entity.
    The mappedBy attribute specifies the field in the Post entity that maps to the Category entity.

    The cascade = CascadeType.ALL attribute is used to specify that all operations (including Hibernate-specific ones) should be cascaded from a parent entity to a child entity.
    In the context of the Category and Post entities, if we use CascadeType.ALL for the posts field in the Category entity,
    then all operations performed on the Category entity (such as persist, merge, remove, refresh, and detach) will be automatically propagated to all associated Post entities.
    For example, if we delete a Category entity that has associated Post entities,
    then all the associated Post entities will also be deleted automatically. This can help simplify our code and reduce the amount of boilerplate code required to manage the relationships between entities.

     */
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Post> posts;
}
