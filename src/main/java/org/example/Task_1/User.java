package org.example.Task_1;

public class User {

    private int id;
    private String name;
    private String username;
    private String email;
    private Address addres;

    private String phone;
    private String website;
    private Company company;



    public User(int id, String name, String username, String email, Address addres, String phone, String website, Company company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.addres = addres;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return addres;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", addres=" + addres +
                '}';
    }
}
