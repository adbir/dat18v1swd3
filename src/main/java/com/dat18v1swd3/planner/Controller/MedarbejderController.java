package com.dat18v1swd3.planner.Controller;

import com.dat18v1swd3.planner.Model.Medarbejder;
import com.dat18v1swd3.planner.Model.MedarbejderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MedarbejderController {

    @Autowired
    private MedarbejderRepository medarbejderRepository;

    @GetMapping(name = "/")
    public String showIndex(){return "index.html";}

    @GetMapping("/medarbejder")
    public String showMedarbejder(@RequestParam("id") Integer id, Model model)
    {
        Medarbejder modelMedarbejder = medarbejderRepository.getById(id);
        model.addAttribute("medarbejder", modelMedarbejder);
        return "medarbejder/medarbejder.html";
    }

    @PostMapping("/nymedarbejder")
    public String createMedarbejder(@ModelAttribute Medarbejder medarbejder)
    {
        medarbejderRepository.save(medarbejder);

        return "index.html";
    }

    @GetMapping("/nymedarbejder")
    public String createMedarbejder(){ return "medarbejder/nymedarbejder.html";}

    @PostMapping("/medarbejder")
    public String updateMedarbejder(@ModelAttribute Medarbejder medarbejder)
    {

        System.out.println("Kommer hertil.");

        medarbejderRepository.save(medarbejder);
        String redirect = "redirect:/medarbejder?id=" + medarbejder.getId();
        return redirect;
    }

}
