package com.dat18v1swd3.planner.Model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "workers")
public class Worker {

    public Worker(){ }

    public Worker(String email, String password, String name, Integer userlevel) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.userlevel = userlevel;
    }

    public Worker(Integer id, String email, String name, String password)
    {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public Worker(Integer id, String email, String name, String password, List<Shift> shift)
    {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.shift = shift;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String email;
    private String password;
    private String name;
    @OneToMany(mappedBy = "worker")
    private List<Shift> shift;

    public List<Shift> getShift() {
        return shift;
    }

    public void setShift(List<Shift> shift) {
        this.shift = shift;
    }

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
