package com.dat18v1swd3.planner.Model;

public class ShiftMedarbejder {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String name;
    private String start;
    private String end;
    private Integer id;

    public ShiftMedarbejder(String name, String start, String end, Integer id)
    {
        this.name = name;
        this.start = start;
        this.end = end;
        this.id = id;
    }
}
