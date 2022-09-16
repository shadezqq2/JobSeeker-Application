package com.jobseeker.app.controller;

import com.jobseeker.app.data.DataStore;
import com.jobseeker.domain.JobEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    DataStore dataStore;

    private List<JobEntity> searchResult;

    @GetMapping
    public String searchPage(Model model) {
        searchResult = dataStore.getJobs();
        model.addAttribute("jobs", searchResult);
        model.addAttribute("job", new JobEntity());
        return "search";
    }

    @PostMapping
    public String searching(JobEntity job, Model model) {
        searchResult = dataStore.getJobsByTitleAndLocationLike(job.getTitle().toLowerCase(), job.getLocation().toLowerCase());
        model.addAttribute("job", job);
        model.addAttribute("jobs", searchResult);
        return "search";
    }

}
