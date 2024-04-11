package com.controller.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.controller.dto.JobDto;
import com.controller.service.JobService;

@RestController
public class JobController {
	
	@Autowired
	JobService jobService;
	
	@RequestMapping(value = "/getJobs", method = RequestMethod.GET, produces = "application/json")
    public List<JobDto> getJob(HttpServletRequest request, HttpServletResponse response) {
		return jobService.getJobs();
		
       
    }
	

}
