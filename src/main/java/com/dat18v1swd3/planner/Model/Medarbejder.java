package com.dat18v1swd3.planner.Model;

import javax.persistence.*;

@Entity
@Table(name = "medarbejder")
public class Medarbejder {

    public Medarbejder(){

    }

    public Medarbejder(String email, String password, String name, Integer userlevel) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.userlevel = userlevel;
    }

    public Medarbejder(Integer id, String email, String name, String password)
    {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String email;
    private String password;
    private String name;

    public Integer getUserlevel() {
        return userlevel;
    }

    public void setUserlevel(Integer userlevel) {
        this.userlevel = userlevel;
    }

    private Integer userlevel;

    public Integer getId() {
        return id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
