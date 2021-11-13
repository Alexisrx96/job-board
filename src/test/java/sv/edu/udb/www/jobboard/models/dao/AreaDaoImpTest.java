package sv.edu.udb.www.jobboard.models.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sv.edu.udb.www.jobboard.models.entities.Area;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

class AreaDaoImpTest {

    @PersistenceContext
    private EntityManager entityManager;
    @Test
    void getAreas() {
    }

    @Test
    void testGetAreas() {
    }
}