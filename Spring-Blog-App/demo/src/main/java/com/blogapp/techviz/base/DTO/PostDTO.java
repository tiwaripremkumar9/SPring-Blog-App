package com.blogapp.techviz.base.DTO;

import com.blogapp.techviz.base.Pojo.Category;
import com.blogapp.techviz.base.Pojo.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDTO {

    private String title;
    private String content;
    private CategoryDTO category;
    private UserDTO user;

    @Override
    public String toString() {
        return "[title:"+this.title+" content: "+this.getContent()+" User: "+this.getUser().toString()+" Category: "+this.getCategory().toString()+"]";
    }
}
