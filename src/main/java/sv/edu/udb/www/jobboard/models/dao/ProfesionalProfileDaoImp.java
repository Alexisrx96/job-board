package sv.edu.udb.www.jobboard.models.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.www.jobboard.models.entities.ProfesionalProfile;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional

public class ProfesionalProfileDaoImp implements ProfesionalProfileDao{


    @Autowired
    EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<ProfesionalProfile> getProfesionalProfiles() {
        String query = "FROM ProfesionalProfile";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public ProfesionalProfile getProfesionalProfile(int id) {
        return entityManager.find(ProfesionalProfile.class,id);
    }




    @Override
    public void updateProfesionalProfile(ProfesionalProfile profesionalProfile) {
        entityManager.merge(profesionalProfile);
    }

    @Override
    public void deleteProfesionalProfile(int id) {
        ProfesionalProfile profesionalProfile = getProfesionalProfile(id);
        entityManager.remove(profesionalProfile);
    }

    @Override
    public void createProfesionalProfile(ProfesionalProfile profesionalProfile) {
        entityManager.persist(profesionalProfile);
    }


}