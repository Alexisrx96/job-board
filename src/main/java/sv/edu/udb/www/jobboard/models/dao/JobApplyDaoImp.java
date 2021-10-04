package sv.edu.udb.www.jobboard.models.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.www.jobboard.models.entities.JobApply;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional

public class JobApplyDaoImp implements JobApplyDao{


    @Autowired
    EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<JobApply> getJobApplies() {
        String query = "FROM JobApply";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public JobApply getJobApply(int id) {
        return entityManager.find(JobApply.class,id);
    }

    @Override
    public void updateJobApply(JobApply jobApply) {
        entityManager.merge(jobApply);
    }

    @Override
    public void deleteJobApply(int id) {
        JobApply jobApply = getJobApply(id);
        entityManager.remove(jobApply);
    }

    @Override
    public void createJobApply(JobApply jobApply) {
        entityManager.persist(jobApply);
    }
}


