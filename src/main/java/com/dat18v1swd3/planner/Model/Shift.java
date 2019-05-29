package com.dat18v1swd3.planner.Model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "shift")
public class Shift implements Serializable {

    private static final long serialVersionUID = 1L;

    public Shift(){}

    public Shift(Date start, Date end, int fk_worker) {
        this.start = start;
        this.end = end;
        this.fk_worker = fk_worker;
    }

    public Shift(String name, Date start, Date end, int id)
    {
        this.name = name;
        this.start = start;
        this.end = end;
        this.id = id;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date start;
    @Temporal(TemporalType.TIMESTAMP)
    private Date end;
    private int fk_worker;
    private String name;

    @OneToMany(targetEntity = Medarbejder.class, mappedBy = "id", orphanRemoval = false, fetch = FetchType.LAZY)
    private Set<Medarbejder> medarbejder;

    public Integer getId() {
        return id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public int getFk_worker() {
        return fk_worker;
    }

    public void setFk_worker(int fk_worker) {
        this.fk_worker = fk_worker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


