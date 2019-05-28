package com.dat18v1swd3.planner.Model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface ShiftRepository extends CrudRepository<Shift, Integer> {


    @Query("SELECT s FROM Shift s WHERE WEEK(start) = :weeknumber ORDER BY start ASC")
    ArrayList<Shift> findAllByWeek(@Param("weeknumber") int weeknumber);

    @Query("SELECT s FROM Shift s WHERE WEEK(start) = :weeknumber AND DAYNAME(start) = :weekday ORDER BY start ASC")
    ArrayList<Shift> findAllByWeekAndDay(@Param("weeknumber") int weeknumber, @Param("weekday") String weekday);

}
