package com.microservice.Sales.domain.external;

public class User {
    private Long id;
    private String name;
    private String email;
    private Long rol;

    // Getters y setters
    
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


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Long getRol() {
        return rol;
    }
     public void setRol(Long rol) {
        this.rol = rol;
    }

      
}
