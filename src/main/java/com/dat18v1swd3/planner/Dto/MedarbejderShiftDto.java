package com.dat18v1swd3.planner.Dto; //Data Transfer Object

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class MedarbejderShiftDto {

    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    private Date start;
    @Temporal(TemporalType.TIMESTAMP)
    private Date end;
    private int id;

    public MedarbejderShiftDto(String name, Date start, Date end, int id) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}