package org.launchcode.techjobs.persistent.controllers;

import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
//--done part 3c. todo: add repository,add employer data to form, select correct employer object

@Controller
public class HomeController {

    @Autowired //--done
    private EmployerRepository employerRepository;

    @Autowired //--done
    private SkillRepository skillRepository;

    @Autowired //--done
    private JobRepository jobRepository;
    @RequestMapping("")
    public String index(Model model) {

        model.addAttribute("title", "My Jobs");

        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());
        model.addAttribute("employers", employerRepository.findAll());
        model.addAttribute("skills", skillRepository.findAll());
        return "add";
    }

    @PostMapping("add")  //--done part 3 and part 4 create new jobs
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                       Errors errors, Model model, @RequestParam int employerId, @RequestParam List<Integer> skills) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            return "add";
        } else{
            Optional<Employer> optEmployer = employerRepository.findById(employerId);
            Employer employer = optEmployer.get();
            newJob.setEmployer(employer);
            List<Skill> skillObjects = (List<Skill>) skillRepository.findAllById(skills);
            newJob.setSkills(skillObjects);
            jobRepository.save(newJob);
        }

        return "redirect:";
    }

    @GetMapping("view/{jobId}") //--done part 3. finish job view
    public String displayViewJob(Model model, @PathVariable int jobId) {
        Optional<Job> optJob = jobRepository.findById(jobId);
        Job job = optJob.get();
        model.addAttribute("job", job);
        return "view";
    }


}
