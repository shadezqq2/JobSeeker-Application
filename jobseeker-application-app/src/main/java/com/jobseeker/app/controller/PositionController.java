package com.jobseeker.app.controller;

import com.jobseeker.app.data.DataStore;
import com.jobseeker.app.service.JobSeekerFacade;
import com.jobseeker.domain.JobEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/position")
public class PositionController {
    @Autowired
    JobSeekerFacade jobSeekerFacade;
    @Autowired
    DataStore dataStore;

    @GetMapping
    public String creatingPage(Model model) {
        model.addAttribute("job", new JobEntity());
        return "newPosition";
    }

    @PostMapping
    public String successfulPost(JobEntity job) {
        if (jobSeekerFacade.registerJob(job)) {
            return "redirect:position/" + job.getId();
        } else {
            return "redirect:newPosition";
        }
    }

    @GetMapping("/{position_id}")
    public String getJob(@PathVariable Long position_id, Model model) {
        JobEntity job = dataStore.getJobById(position_id);
        model.addAttribute("job", job);
        return "position";
    }
}
