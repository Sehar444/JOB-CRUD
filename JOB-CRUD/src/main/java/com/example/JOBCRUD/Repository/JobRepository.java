package com.example.JOBCRUD.Repository;

import com.example.JOBCRUD.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {
}
