package com.example.JOBCRUD.service;

import com.example.JOBCRUD.Repository.JobRepository;
import com.example.JOBCRUD.exception.ResourceNotFoundException;
import com.example.JOBCRUD.model.Job;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    public List<Job> getJobs() {
        return jobRepository.findAll();

    }

    public Job updateJob(Job job) throws ResourceNotFoundException {
        Optional<Job> job1 = jobRepository.findById(job.getId());
        if (!job1.isPresent()) {
            throw new ResourceNotFoundException("Resource Not Found");
        } else {
            Job job2 = job1.get();
            job2.setJobLocation(job.getJobLocation());
            job2.setJobDescription(job.getJobDescription());
            job2.setJobName(job.getJobName());
            job2.setId(job.getId());
            job2.setJobType(job.getJobType());
            jobRepository.save(job2);
            return job2;
        }
    }
        public Job getJobById(long id) throws ResourceNotFoundException {
            Optional<Job> job1 = jobRepository.findById(id);
            if (!job1.isPresent()) {
                throw new ResourceNotFoundException("Resource Not Found");
            } else {
                return job1.get();
            }
        }
        public void deleteJob(long id) throws ResourceNotFoundException {
            Optional<Job> job1 = jobRepository.findById(id);
            if(!job1.isPresent()) {
                throw new ResourceNotFoundException("Resource Not Found!!!!");
            }else {
                jobRepository.delete(job1.get());
            }
        }


}