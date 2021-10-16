package sv.edu.udb.www.jobboard.models.dao;

import sv.edu.udb.www.jobboard.models.entities.JobOffer;

import java.util.List;

public interface JobOfferDao {

    List<JobOffer> getJobOffers();
    List<JobOffer> getJobOffersByCompany(int id);
    JobOffer getJobOffer(int id);
    void updateJobOffer(JobOffer jobOffer);
    void deleteJobOffer(int id);
    void createJobOffer(JobOffer jobOffer);

}