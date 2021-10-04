package sv.edu.udb.www.jobboard.models.dao;


import sv.edu.udb.www.jobboard.models.entities.JobApply;

import java.util.List;

public interface JobApplyDao {
    List<JobApply> getJobApplies();
    JobApply getJobApply(int id);
    void updateJobApply(JobApply jobApply);
    void deleteJobApply(int id);
    void createJobApply(JobApply jobApply);
}