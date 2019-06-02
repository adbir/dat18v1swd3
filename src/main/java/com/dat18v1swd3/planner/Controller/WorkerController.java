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
    public String showWorker(@RequestParam("id") Integer id, Model model)
    {
        Worker modelWorker = workerRepository.getById(id);
        model.addAttribute("worker", modelWorker);
        return "worker/worker.html";
    }

    @PostMapping("/nymedarbejder")
    public String createWorker(@ModelAttribute Worker worker)
    {
        workerRepository.save(worker);

        return "redirect:/medarbejdere";
    }

    @PostMapping("/medarbejder")
    public String updateWorker(@RequestParam("id") Integer id, @ModelAttribute Worker worker)
    {
        workerRepository.save(worker);
        return "/medarbejder?id=" + worker.getId();
    }

    @GetMapping("/nymedarbejder")
    public String newWorker(){return "worker/newworker.html";}

    @GetMapping("/medarbejdere")
    public String showAllWorkers(Model model)
    {
        List<Worker> workerList = workerRepository.findAll();
        model.addAttribute("workerList", workerList);

        return "worker/workers.html";
    }

    @GetMapping(value = "delete", params = "id")
    public String deleteWorker(@RequestParam(value = "id") Integer id)
    {
        workerRepository.deleteById(id);
        return "redirect:/medarbejdere";
    }

}
