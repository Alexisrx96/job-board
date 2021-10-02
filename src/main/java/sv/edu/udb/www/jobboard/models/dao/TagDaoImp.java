package sv.edu.udb.www.jobboard.models.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.www.jobboard.models.entities.Tag;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class TagDaoImp implements TagDao{
    @Autowired
    EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<Tag> getTags() {
        String query = "FROM Tag";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Tag getTag(int id) {
        return entityManager.find(Tag.class,id);
    }

    @Override
    public void updateTag(Tag tag) {
        entityManager.merge(tag);
    }

    @Override
    public void deleteTag(int id) {
        Tag tag = getTag(id);
        entityManager.remove(tag);
    }

    @Override
    public void createTag(Tag tag) {
        entityManager.persist(tag);
    }
}