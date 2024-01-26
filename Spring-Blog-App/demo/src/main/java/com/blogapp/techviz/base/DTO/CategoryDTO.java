package com.blogapp.techviz.base.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CategoryDTO {

    private Integer categoryId;
    private String categoryType;
    private String categoryDesc;
}
