package sv.edu.udb.www.jobboard.models.dao;


import sv.edu.udb.www.jobboard.models.entities.ProfesionalProfile;

import java.util.List;

public interface ProfesionalProfileDao {

    List<ProfesionalProfile> getProfesionalProfiles();
    ProfesionalProfile getProfesionalProfile(int id);
    void updateProfesionalProfile(ProfesionalProfile profesionalProfile);
    void deleteProfesionalProfile(int id);
    void createProfesionalProfile(ProfesionalProfile profesionalProfile);

}