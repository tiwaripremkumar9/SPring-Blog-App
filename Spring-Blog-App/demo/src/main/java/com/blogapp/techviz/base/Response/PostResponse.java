package com.blogapp.techviz.base.Response;

import com.blogapp.techviz.base.DTO.PostDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class PostResponse {

    private List<PostDTO> content;
    private int pageNumber;
    private int pageSize;
//    private int totalElements;
    private long totalElements; // can't be int since Page object's getTotalElement returns long
    private  int totalPages;
    private boolean isLastPage;
}
