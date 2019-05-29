package com.dat18v1swd3.planner.Model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ShiftRepository extends CrudRepository<Shift, Integer> {


    @Query("SELECT s FROM Shift s WHERE WEEK(start) = :weeknumber ORDER BY start ASC")
    ArrayList<Shift> findAllByWeek(@Param("weeknumber") int weeknumber);

    @Query("SELECT s FROM Shift s WHERE WEEK(start) = :weeknumber AND DAYNAME(start) = :weekday ORDER BY start ASC")
    ArrayList<Shift> findAllByWeekAndDay(@Param("weeknumber") int weeknumber, @Param("weekday") String weekday);


    /*@Query("SELECT new ShiftMedbarbejder(m.name, s.start, s.end, s.fk_worker ) "
            + "FROM Shift s INNER JOIN s.fk_worker m WHERE WEEK(start) = :weeknumber AND DAYNAME(start) = :weekday ORDER BY start ASC")
    ArrayList<ShiftMedarbejder> findAllByWeekAndDayWithName(@Param("weeknumber") int weeknumber, @Param("weekday") String weekday);*/

}
