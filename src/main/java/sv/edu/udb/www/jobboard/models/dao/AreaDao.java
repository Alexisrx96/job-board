package sv.edu.udb.www.jobboard.models.dao;

import sv.edu.udb.www.jobboard.models.entities.Area;

import java.util.List;

public interface AreaDao {
    List<Area> getAreas();
    List<Area> getAreas(String name);
    Area getArea(int id);
    void updateArea(Area area);
    void deleteArea(int id);
    void createArea(Area area);
}