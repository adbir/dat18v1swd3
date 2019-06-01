package com.dat18v1swd3.planner.Controller;

import com.dat18v1swd3.planner.Model.Worker;
import com.dat18v1swd3.planner.Model.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WorkerController {

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping(name = "/")
    public String showIndex(){return "index.html";}

    @GetMapping("/medarbejder")
    public String showMedarbejder(@RequestParam("id") Integer id, Model model)
    {
        Worker modelWorker = workerRepository.getById(id);
        model.addAttribute("worker", modelWorker);
        return "medarbejder/medarbejder.html";
    }

    @PostMapping("/nymedarbejder")
    public String createMedarbejder(@ModelAttribute Worker worker)
    {
        workerRepository.save(worker);

        return "index.html";
    }

    @GetMapping("/nymedarbejder")
    public String createMedarbejder(){ return "medarbejder/nymedarbejder.html";}

    @PostMapping("/medarbejder")
    public String updateMedarbejder(@RequestParam("id") Integer id, @ModelAttribute Worker worker)
    {
        workerRepository.save(worker);
        String redirect = "redirect:/medarbejder?id=" + worker.getId();
        return redirect;
    }

    @GetMapping("/medarbejdere")
    public String showAllMedarbejdere(Model model)
    {
        List<Worker> workerList = (List<Worker>) workerRepository.findAll();
        model.addAttribute("workerList", workerList);

        return "medarbejder/medarbejdere.html";
    }

    @GetMapping(value = "medarbejder/delete", params = "id")
    public String deleteMedarbejder(@RequestParam(value = "id") Integer id)
    {
        workerRepository.deleteById(id);
        return "redirect:/medarbejdere";
    }

}
