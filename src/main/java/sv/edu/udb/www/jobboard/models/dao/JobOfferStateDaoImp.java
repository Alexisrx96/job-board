package sv.edu.udb.www.jobboard.models.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.www.jobboard.models.entities.JobOfferState;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class JobOfferStateDaoImp implements JobOfferStateDao{

    @Autowired
    EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<JobOfferState> getJobOfferStates() {
        String query = "FROM JobOfferState";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public JobOfferState getJobOfferState(int id) {
        return entityManager.find(JobOfferState.class,id);
    }
}