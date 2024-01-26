package com.blogapp.techviz.base.DTO;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private int id;
    @NotEmpty //handles both null entry and empty entry
    @Size(min = 4, message = "Name should be minimum 4 character")
    private String name;
    @Email(message = "email address is not valid")
    private String email;
    @NotEmpty
    private String about;
    @NotEmpty
    @Size(min = 4, max = 16, message = "Password: min 4 characters and max 16 characters")
    //@Pattern(regexp = )
    private String password;
}
