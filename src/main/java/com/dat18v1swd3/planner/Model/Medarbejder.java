package com.dat18v1swd3.planner.Model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "medarbejder")
public class Medarbejder implements Serializable {

    private static final long serialVersionUID = 1L;

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


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_worker", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private Shift shift;

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

    public void setId(Integer id){ this.id = id;}

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
