package com.dat18v1swd3.planner.Controller;

import com.dat18v1swd3.planner.Model.*;
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
        return "shift/shifts.html";
    }

    @PostMapping("vagter")
    public String showSelectedWeek(int week, Model model){
        /*ArrayList<Shift> shifts = shiftRepository.findAllByWeek(21);
        model.addAttribute("shifts", shifts);*/
        ArrayList<Shift> mondayShifts = shiftRepository.findAllByWeekAndDay(week, "monday");
        model.addAttribute("monday", mondayShifts );
        ArrayList<Shift> tuesdayShifts = shiftRepository.findAllByWeekAndDay(week, "tuesday");
        model.addAttribute("tuesday", tuesdayShifts);
        ArrayList<Shift> wednesdayShifts = shiftRepository.findAllByWeekAndDay(week, "wednesday");
        model.addAttribute("wednesday", wednesdayShifts);
        ArrayList<Shift> thursdayShifts = shiftRepository.findAllByWeekAndDay(week, "thursday");
        model.addAttribute("thursday", thursdayShifts);
        ArrayList<Shift> fridayShifts = shiftRepository.findAllByWeekAndDay(week, "friday");
        model.addAttribute("friday", fridayShifts);
        ArrayList<Shift> saturdayShifts = shiftRepository.findAllByWeekAndDay(week, "saturday");
        model.addAttribute("saturday", saturdayShifts);
        ArrayList<Shift> sundayShifts = shiftRepository.findAllByWeekAndDay(week, "sunday");
        model.addAttribute("sunday", sundayShifts);

        return "shift/shifts.html";
    }

}
