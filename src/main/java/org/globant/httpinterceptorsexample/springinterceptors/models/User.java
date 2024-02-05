package org.globant.httpinterceptorsexample.springinterceptors.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 3, max=30)
    @NotEmpty
    private String name;

    @Size(min = 4,  max=50)
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Size(min = 5,  max = 15)
    @NotEmpty
    private String password;

    public User(){}

    public User(Integer id, @Size(min = 3, max = 30) @NotEmpty String name, @Size(min = 4, max = 50) @Email String email,
            @Size(min = 5, max = 15) @NotEmpty String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    

    public User(@Size(min = 4, max = 50) @Email String email, @Size(min = 5, max = 15) @NotEmpty String password) {
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
    
}
