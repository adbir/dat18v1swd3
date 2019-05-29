package com.dat18v1swd3.planner.Model;

import com.dat18v1swd3.planner.Dto.MedarbejderShiftDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface MedarbejderRepository extends JpaRepository<Medarbejder, Integer> {

    Medarbejder getById(Integer id);

    ArrayList<Medarbejder> findAll();

    @Query("SELECT new MedarbejderShiftDto (m.name, s.start, s.end, s.id) "
            + "FROM Medarbejder m, Shift s INNER JOIN m.id s")
    ArrayList<MedarbejderShiftDto> fetchAll();
}
