package com.dat18v1swd3.planner.Model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "shift")
public class Shift {

    public Shift(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date start;
    @Temporal(TemporalType.TIMESTAMP)
    private Date end;
    private Integer fk_worker;
    @ManyToOne
    @JoinColumn(name = "fk_worker", insertable = false, updatable = false)
    private Medarbejder medarbejder;

    public Shift(Integer id, Date start, Date end, Medarbejder medarbejder)
    {
        this.id = id;
        this.start = start;
        this.end = end;
        this.medarbejder = medarbejder;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public void setFk_worker(Integer fk_worker) {
        this.fk_worker = fk_worker;
    }

    public Medarbejder getMedarbejder() {
        return medarbejder;
    }

    public void setMedarbejder(Medarbejder medarbejder) {
        this.medarbejder = medarbejder;
    }
}