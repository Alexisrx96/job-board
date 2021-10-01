package sv.edu.udb.www.jobboard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.udb.www.jobboard.models.dao.AreaDao;
import sv.edu.udb.www.jobboard.models.dto.AreaForm;
import sv.edu.udb.www.jobboard.models.entities.Area;

import java.util.List;


@Service
public class AreaService {
    @Autowired
    AreaDao areaDao;
    public List<Area> getAreaList(){
        return areaDao.getAreas();
    }
    public void addArea(AreaForm area){
        Area newArea = new Area();
        newArea.setName(area.getName());
        areaDao.createArea(newArea);
    }
    public void editArea(AreaForm area){
        Area newArea = new Area();
        newArea.setId(area.getId());
        newArea.setName(area.getName());
        areaDao.updateArea(newArea);
    }
    public AreaForm getArea(int id){
        Area area = areaDao.getArea(id);
        AreaForm areaForm = new AreaForm();
        areaForm.setId(area.getId());
        areaForm.setName(area.getName());
        return areaForm;
    }
    public void removeArea(int id){
        areaDao.deleteArea(id);
    }
}
