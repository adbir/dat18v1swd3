package com.dat18v1swd3.planner.Controller;

import com.dat18v1swd3.planner.Model.Shift;
import com.dat18v1swd3.planner.Model.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class ShiftController {

    @Autowired
    private  ShiftRepository shiftRepository;

    @GetMapping("/vagter")
    public String showAllShifts(Model model){
        ArrayList<Shift> shifts = (ArrayList<Shift>) shiftRepository.findAll();
        model.addAttribute("shifts", shifts);
        return "vagt/vagter.html";
    }

    @PostMapping("vagter")
    public String showSelectedWeek(int week, Model model){
        ArrayList<Shift> shifts = shiftRepository.findAllByWeek(week);
        model.addAttribute("shifts", shifts);
        ArrayList<Shift> mondayShifts = shiftRepository.findAllByWeekAndDay(week, "monday");
        ArrayList<Shift> tuesdayShifts = shiftRepository.findAllByWeekAndDay(week, "tuesday");
        ArrayList<Shift> wednesdayShifts = shiftRepository.findAllByWeekAndDay(week, "wednesday");
        model.addAttribute("monday", mondayShifts);
        model.addAttribute("tuesday", tuesdayShifts);
        model.addAttribute("wednesday", wednesdayShifts);
        return "vagt/vagter.html";
    }

}
