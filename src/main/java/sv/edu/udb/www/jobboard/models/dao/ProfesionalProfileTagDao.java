package sv.edu.udb.www.jobboard.models.dao;

import sv.edu.udb.www.jobboard.models.entities.ProfesionalProfileTag;
import sv.edu.udb.www.jobboard.models.entities.ProfesionalProfileTagId;

import java.util.List;


public interface ProfesionalProfileTagDao {

    List<ProfesionalProfileTag> getProfesionalProfileTags();
    ProfesionalProfileTag getProfesionalProfileTag(ProfesionalProfileTagId id);
    void updateProfesionalProfileTag(ProfesionalProfileTag profesionalProfileTag);
    void deleteProfesionalProfileTag(ProfesionalProfileTagId id);
    void createProfesionalProfileTag(ProfesionalProfileTag profesionalProfileTag);


}