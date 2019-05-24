package com.dat18v1swd3.planner.Model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "shift")
public class Shift {

    public Shift(){}

    public Shift(Date start, Date end, int fk_worker) {
        this.start = start;
        this.end = end;
        this.fk_worker = fk_worker;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date start;
    @Temporal(TemporalType.TIMESTAMP)
    private Date end;
    private int fk_worker;

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
}


