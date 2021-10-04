package sv.edu.udb.www.jobboard.models.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.www.jobboard.models.entities.Resume;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
@Transactional
public class ResumeDaoImp implements ResumeDao{
    @Autowired
    EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<Resume> getResumes() {
        String query = "FROM Resume";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Resume getResume(int id) {
        return entityManager.find(Resume.class, id);

    }




    @Override
    public void updateResume(Resume resume) {

        entityManager.merge(resume);
    }

    @Override
    public void deleteResume(int id) {
        Resume resume = getResume(id);//instancia a eliminar
        entityManager.remove(resume);
    }

    @Override
    public void createResume(Resume resume) {

        entityManager.persist(resume);
    }
}