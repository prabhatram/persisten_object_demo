package edu.database;

public class Customer {

    private Integer id;
    private String name;
    private String email;

    public Customer(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Customer(String name, String email) {
        this(null, name, email);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void changeEmail(String newEmail) {
        this.email = newEmail;
    }

    @Override
    public String toString() {
        return "Customer{id=" + id
            + ", name='" + name
            + "', email='" + email + "'}";
    }
}