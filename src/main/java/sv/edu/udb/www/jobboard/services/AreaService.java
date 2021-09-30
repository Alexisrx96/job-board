package sv.edu.udb.www.jobboard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.udb.www.jobboard.dao.AreaDao;
import sv.edu.udb.www.jobboard.models.Area;

import java.util.List;


@Service
public class AreaService {
    @Autowired
    AreaDao areaDao;
    public List<Area> getAreaList(){
        return areaDao.getAreas();
    }
    public void addArea(Area area){
        areaDao.createArea(area);
    }
    public void editArea(Area area){
        areaDao.updateArea(area);
    }
    public Area getArea(int id){
        return areaDao.getArea(id);
    }
    public void removeArea(int id){
        areaDao.deleteArea(id);
    }
}
