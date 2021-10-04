package sv.edu.udb.www.jobboard.models.dao;

import sv.edu.udb.www.jobboard.models.entities.Resume;

import java.util.List;


public interface ResumeDao {

    List<Resume> getResumes();
    Resume getResume(int id);
    void updateResume(Resume resume);
    void deleteResume(int id);
    void createResume(Resume resume);


}