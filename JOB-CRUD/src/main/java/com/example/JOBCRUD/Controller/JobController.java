package com.example.JOBCRUD.Controller;

import com.example.JOBCRUD.exception.ResourceNotFoundException;
import com.example.JOBCRUD.model.Job;
import com.example.JOBCRUD.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    @Autowired
    JobService jobService;
    @GetMapping("/job")
    public List<Job> getAllJobs(){
        return jobService.getJobs();
    }
    @PostMapping("/job")
    public ResponseEntity<Job> saveJob(@RequestBody Job job){
        return new ResponseEntity<Job>(jobService.saveJob(job), HttpStatus.CREATED);
    }
    @PutMapping("/job/{id}")
    public ResponseEntity<Job> updateJobs(@RequestBody Job job, @PathVariable("id") long id) throws ResourceNotFoundException, ResourceNotFoundException {
        job.setId(id);

        return new ResponseEntity<Job>(jobService.updateJob(job), HttpStatus.CREATED);
    }
    @DeleteMapping("/job/{id}")
    public ResponseEntity<String> deleteJobs(@PathVariable("id") long id) throws ResourceNotFoundException{
        jobService.deleteJob(id);
        return new ResponseEntity<String>("Deleted",HttpStatus.OK);

    }

}
