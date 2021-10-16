package sv.edu.udb.www.jobboard.models.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.www.jobboard.models.entities.JobOffer;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional

public class JobOfferDaoImp implements JobOfferDao{


    @Autowired
    EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<JobOffer> getJobOffers() {
        String query = "FROM JobOffer";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<JobOffer> getJobOffersByCompany(int id) {
        String query = "FROM JobOffer J WHERE J.company.id = ?1";
        var result = entityManager.createQuery(query).setParameter(1,id).getResultList();
        return result;
    }

    @Override
    public JobOffer getJobOffer(int id) {
        return entityManager.find(JobOffer.class,id);
    }

    @Override
    public void updateJobOffer(JobOffer jobOffer) {
        entityManager.merge(jobOffer);
    }

    @Override
    public void deleteJobOffer(int id) {
        JobOffer jobOffer = getJobOffer(id);
        entityManager.remove(jobOffer);
    }

    @Override
    public void createJobOffer(JobOffer jobOffer) {
        entityManager.persist(jobOffer);
    }
}




