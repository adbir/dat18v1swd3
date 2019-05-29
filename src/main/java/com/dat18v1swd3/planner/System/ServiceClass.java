package com.dat18v1swd3.planner.System;

import com.dat18v1swd3.planner.Dto.MedarbejderShiftDto;
import com.dat18v1swd3.planner.Model.MedarbejderRepository;
import com.dat18v1swd3.planner.Model.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServiceClass {

    @Autowired
    private ShiftRepository shiftRepository;
    @Autowired
    private MedarbejderRepository medarbejderRepository;

    @Query("SELECT new MedarbejderShiftDto (m.name, s.start, s.end, s.id) "
            + "FROM Medarbejder m, Shift s INNER JOIN m.id s")
    public ArrayList<MedarbejderShiftDto> fetchInnerJoin(){
        return medarbejderRepository.fetchAll();
    }
}
