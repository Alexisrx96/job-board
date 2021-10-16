package sv.edu.udb.www.jobboard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.udb.www.jobboard.models.dao.*;
import sv.edu.udb.www.jobboard.models.dto.JobApplyForm;
import sv.edu.udb.www.jobboard.models.dto.JobOfferForm;
import sv.edu.udb.www.jobboard.models.dto.ProfessionalAccountForm;
import sv.edu.udb.www.jobboard.models.entities.JobApply;
import sv.edu.udb.www.jobboard.models.entities.JobOffer;
import sv.edu.udb.www.jobboard.models.entities.ProfesionalProfile;
import java.util.List;

@Service
public class ProfessionalService {

    @Autowired
    AreaDao areaDao;
    @Autowired
    ProfesionalProfileDao profesionalProfileDao;

    @Autowired
    JobOfferDao jobOfferDao;
    @Autowired
    JobApplyDao jobApplyDao;
    @Autowired
    ResumeDao resumeDao;

    ///Profile

    public ProfessionalAccountForm getProfessionalAccountForm(int id){
        ProfesionalProfile profile = profesionalProfileDao.getProfesionalProfile(id);
        var form=new ProfessionalAccountForm();
        form.setArea(profile.getArea().getId());
        form.setFirstName(profile.getFirstName());
        form.setLastName(profile.getLastName());
        form.setEmail(profile.getEmail().getId());
        return form;
    }


    public void applyToJobForm(JobApplyForm form){
        JobApply apply = new JobApply();
        apply.setJobOffer(jobOfferDao.getJobOffer(form.getId()));
        apply.setResume(resumeDao.getResume(form.getId()));
        jobApplyDao.createJobApply(apply);
    }

    //TODO MOVE TO COMPANY
    //JobOffer
    public JobOfferForm getJobOfferForm(int id){
        JobOffer offer = jobOfferDao.getJobOffer(id);
        var offerForm =new JobOfferForm();
        offerForm.setArea(offer.getArea().getId());
        offerForm.setTitle(offer.getTitle());
        offerForm.setState(offer.getState().getId());
        offerForm.setCompany(offer.getCompany().getId());
        offerForm.setDescription(offer.getDescription());

        return offerForm;
    }


    //TODO MOVE TO ADMIN
    public List<ProfesionalProfile> getProfessionalList() {
        return profesionalProfileDao.getProfesionalProfiles();
    }

    public void editProfessional(ProfessionalAccountForm professional) {
        ProfesionalProfile newProfessional = profesionalProfileDao.getProfesionalProfileByEmail(professional.getEmail());
        newProfessional.setFirstName(professional.getFirstName());
        newProfessional.setLastName(professional.getLastName());
        newProfessional.setArea(areaDao.getArea(professional.getArea()));
        profesionalProfileDao.updateProfesionalProfile(newProfessional);
    }
    public ProfesionalProfile getProfessional(int id) {
        return profesionalProfileDao.getProfesionalProfile(id);
    }

    public List<JobOffer> getAllOffers(){
        return jobOfferDao.getJobOffers();
    }
}
