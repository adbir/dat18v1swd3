package com.dat18v1swd3.planner.Model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface ShiftRepository extends CrudRepository<Shift, Integer> {

    @Query("Select s from Shift s where week(start)=weeknumber")
    ArrayList<Shift> findAllByWeek(@Param("weeknumber") int weeknumber);


    ArrayList<Shift> findAllByStartContains(int weeknumber);
}
