package sv.edu.udb.www.jobboard.services;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;
import sv.edu.udb.www.jobboard.models.dao.*;
import sv.edu.udb.www.jobboard.models.dto.CompanyAccountForm;
import sv.edu.udb.www.jobboard.models.dto.JobOfferForm;
import sv.edu.udb.www.jobboard.models.entities.CompanyProfile;
import sv.edu.udb.www.jobboard.models.entities.JobOffer;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    CompanyProfileDao companyProfileDao;
    @Autowired
    CompanyAddressDao companyAddressDao;
    @Autowired
    JobOfferDao jobOfferDao;
    @Autowired
    AreaDao areaDao;
    @Autowired
    JobOfferStateDao jobOfferStateDao;

    public CompanyAccountForm getCompanyAccountForm(int id){
        CompanyAccountForm form = new CompanyAccountForm();
        CompanyProfile profile = companyProfileDao.getCompanyProfile(id);
        form.setAbout(profile.getAbout());
        form.setEmail(profile.getEmail().getId());
        form.setName(profile.getName());
        return form;
    }

    public void publishOffer(JobOfferForm form){
        JobOffer jobOffer = new JobOffer();
        jobOffer.setTitle(form.getTitle());
        jobOffer.setDescription(form.getDescription());
        jobOffer.setCompany(companyProfileDao.getCompanyProfile(form.getCompany()));
        jobOffer.setArea(areaDao.getArea(form.getArea()));
        jobOffer.setState(jobOfferStateDao.getJobOfferState(form.getState()));
        jobOfferDao.createJobOffer(jobOffer);
    }
    public List<JobOffer> getMyOffers(int id){
        return jobOfferDao.getJobOffersByCompany(id);
    }
}
