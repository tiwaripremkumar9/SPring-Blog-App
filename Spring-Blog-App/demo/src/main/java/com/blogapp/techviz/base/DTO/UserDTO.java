package com.blogapp.techviz.base.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private int id;
    private String name;
    private String email;
    private String about;
    private String password;
}
