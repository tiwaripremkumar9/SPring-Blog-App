package com.blogapp.techviz.base.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CategoryDTO {

    private Integer categoryId;
    @NotEmpty
    @Size(min = 4, max = 20, message = "size should be between 4 to 20 characters")
    private String categoryType;
    @NotEmpty
    @Size(min = 10, max = 200, message = "size should be between 10 to 200 characters")
    private String categoryDescription;
}
