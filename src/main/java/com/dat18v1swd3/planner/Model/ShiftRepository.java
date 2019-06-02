package com.dat18v1swd3.planner.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Integer> {


    @Query("SELECT s FROM Shift s WHERE WEEK(start) = :weeknumber ORDER BY start ASC")
    ArrayList<Shift> findAllByWeek(@Param("weeknumber") Integer weeknumber);

    @Query("SELECT s FROM Shift s WHERE WEEK(start) = :weeknumber AND DAYNAME(start) = :weekday ORDER BY start ASC")
    ArrayList<Shift> findAllByWeekAndDay(@Param("weeknumber") Integer weeknumber, @Param("weekday") String weekday);


}
