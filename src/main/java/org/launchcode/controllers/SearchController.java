package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    // TODO #1 - Create handler to process search request and display results

    @RequestMapping(value = "results")// producing results
    public String search(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {

        ArrayList<HashMap<String, String>> jobs;

        if (searchType.equals("")) // search all to...
        { jobs = JobData.findByValue(searchType);} // search by value
            else {
            jobs = JobData.findByColumnAndValue(searchType, searchTerm);} //search by column and value


        model.addAttribute("columns", ListController.columnChoices); // attribute: column
        model.addAttribute("jobs", jobs); // attribute jobs
        return "search";
    }

}