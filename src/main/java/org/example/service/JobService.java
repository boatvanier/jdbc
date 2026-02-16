package org.example.service;

import org.example.dao.JobDAO;
import org.example.model.Job;

public class JobService {

    private final JobDAO jobDAO;

    public JobService(JobDAO jobDAO) {
        this.jobDAO = jobDAO;
    }

    public void addJob(Job job) {
        jobDAO.addJob(job);
    }
}
