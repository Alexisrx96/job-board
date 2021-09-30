package sv.edu.udb.www.jobboard.dao;

import sv.edu.udb.www.jobboard.models.Area;

import java.util.List;

public interface AreaDao {
    List<Area> getAreas();
    Area getArea(int id);
    void updateArea(Area area);
    void deleteArea(int id);
    void createArea(Area area);
}