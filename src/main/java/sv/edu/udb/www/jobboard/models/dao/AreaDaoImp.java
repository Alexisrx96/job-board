package sv.edu.udb.www.jobboard.models.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.www.jobboard.models.entities.Area;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class AreaDaoImp implements AreaDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Area> getAreas(){
        String query = "FROM Area";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void createArea(Area area){
        entityManager.persist(area);
    }

    @Override
    public Area getArea(int id) {
        return entityManager.find(Area.class,id);
    }

    @Override
    public void updateArea(Area area) {
        entityManager.merge(area);
    }

    @Override
    public void deleteArea(int id) {
        Area area = entityManager.find(Area.class,id);
        entityManager.remove(area);
    }
}
