package sv.edu.udb.www.jobboard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.udb.www.jobboard.models.dao.CompanyProfileDao;
import sv.edu.udb.www.jobboard.models.entities.CompanyProfile;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    CompanyProfileDao companyProfileDao;

    public List<CompanyProfile> getCompanyProfiles(){
        return companyProfileDao.getCompanyProfiles();
    }
}
