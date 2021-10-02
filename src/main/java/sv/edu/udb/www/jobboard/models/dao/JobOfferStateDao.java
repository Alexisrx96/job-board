package sv.edu.udb.www.jobboard.models.dao;

import sv.edu.udb.www.jobboard.models.entities.JobOfferState;

import java.util.List;

public interface JobOfferStateDao {
    List<JobOfferState> getJobOfferStates();
    JobOfferState getJobOfferState(int id);
}