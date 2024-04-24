package ru.kata.spring.boot_security.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ROLE_ADMIN;
    private String ROLE_USER;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();
//    private List<User> users;

    private String name;


    public Role() {
    }

    public Role(String ROLE_ADMIN, String ROLE_USER, String name) {
        this.ROLE_ADMIN = ROLE_ADMIN;
        this.ROLE_USER = ROLE_USER;
        this.name = name;
    }

    public String getROLE_ADMIN() {
        return ROLE_ADMIN;
    }

    public void setROLE_ADMIN(String ROLE_ADMIN) {
        this.ROLE_ADMIN = ROLE_ADMIN;
    }

    public String getROLE_USER() {
        return ROLE_USER;
    }

    public void setROLE_USER(String ROLE_USER) {
        this.ROLE_USER = ROLE_USER;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
