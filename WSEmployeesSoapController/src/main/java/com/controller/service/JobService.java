package com.controller.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controller.dto.JobDto;
import com.controller.entity.Job;
import com.controller.repository.JobRepository;

@Service
public class JobService {
	
	@Autowired
	JobRepository jobRepository;
	
	public List<JobDto> getJobs(){
		  List<Job> jobs = jobRepository.findAll();
	        
	       List<JobDto> jobDtos = jobs.stream().map(job -> {
	            JobDto jobDto = new JobDto();
	            jobDto.setJobId(job.getJobId());
	            jobDto.setJobTitle(job.getJobTitle());
	            jobDto.setMinSalary(job.getMinSalary());
	            jobDto.setMaxSalary(job.getMaxSalary());
	            return jobDto;
	        }).collect(Collectors.toList());
	        
	        return jobDtos;
	}
	

}
