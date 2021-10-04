package sv.edu.udb.www.jobboard.models.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.www.jobboard.models.entities.ProfesionalProfileTag;
import sv.edu.udb.www.jobboard.models.entities.ProfesionalProfileTagId;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional

public class ProfesionalProfileTagDaoImp implements ProfesionalProfileTagDao{

    @Autowired
    EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<ProfesionalProfileTag> getProfesionalProfileTags() {
        String query = "FROM ProfesionalProfileTag";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public ProfesionalProfileTag getProfesionalProfileTag(ProfesionalProfileTagId id) {
        return entityManager.find(ProfesionalProfileTag.class,id);
    }

    @Override
    public void updateProfesionalProfileTag(ProfesionalProfileTag profesionalProfileTag) {
        entityManager.merge(profesionalProfileTag);
    }

    @Override
    public void deleteProfesionalProfileTag(ProfesionalProfileTagId id) {
        ProfesionalProfileTag profesionalProfileTag = getProfesionalProfileTag(id);
        entityManager.remove(profesionalProfileTag);
    }

    @Override
    public void createProfesionalProfileTag(ProfesionalProfileTag profesionalProfileTag) {
        entityManager.persist(profesionalProfileTag);
    }
}
