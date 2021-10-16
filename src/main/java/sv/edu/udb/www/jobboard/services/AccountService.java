package sv.edu.udb.www.jobboard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import sv.edu.udb.www.jobboard.models.dao.*;
import sv.edu.udb.www.jobboard.models.dto.CompanyAccountForm;
import sv.edu.udb.www.jobboard.models.dto.ProfessionalAccountForm;
import sv.edu.udb.www.jobboard.models.entities.Account;
import sv.edu.udb.www.jobboard.models.entities.CompanyProfile;
import sv.edu.udb.www.jobboard.models.entities.ProfesionalProfile;

@Service
public class AccountService {

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    AccountDao accountDao;
    @Autowired
    CompanyProfileDao companyProfileDao;
    @Autowired
    ProfesionalProfileDao profesionalProfileDao;
    @Autowired
    AccountStateDao accountStateDao;
    @Autowired
    AccountTypeDao accountTypeDao;
    @Autowired
    AreaDao areaDao;

    public ProfesionalProfile getProfesionalProfile(String email){
        return profesionalProfileDao.getProfesionalProfileByEmail(email);
    }

    public CompanyProfile getCompanyProfile(String email){
        return companyProfileDao.getCompanyProfileByEmail(email);
    }

    public Account getAdminAccount(String email){
        var account = accountDao.getAccount(email);
        if (account.getType().getId()!=1)
            return null;
        return account;
    }
    public CompanyProfile newCompany(CompanyAccountForm company){
        Account acc = new Account();
        acc.setId(company.getEmail());
        acc.setPwrd(encoder.encode(company.getPassword()));
        acc.setConfirmCode("123456"); //TODO GENERATE RANDOMLY
        acc.setState(accountStateDao.getAccountState(3));
        acc.setType(accountTypeDao.getAccountType(2));
        accountDao.createAccount(acc);
        CompanyProfile profile = new CompanyProfile();
        profile.setAbout(company.getAbout());
        profile.setEmail(acc);
        profile.setName(company.getName());
        companyProfileDao.createCompanyProfile(profile);
        return profile;
    }

    public ProfesionalProfile newCompany(ProfessionalAccountForm professional){
        Account acc = new Account();
        acc.setId(professional.getEmail());
        acc.setPwrd(encoder.encode(professional.getPassword()));
        acc.setConfirmCode("123456"); //TODO GENERATE RANDOMLY
        acc.setType(accountTypeDao.getAccountType(3));
        acc.setState(accountStateDao.getAccountState(3));
        accountDao.createAccount(acc);
        ProfesionalProfile profile = new ProfesionalProfile();
        profile.setEmail(acc);
        profile.setArea(areaDao.getArea(professional.getArea()));
        profile.setFirstName(professional.getFirstName());
        profile.setLastName(professional.getLastName());
        profesionalProfileDao.createProfesionalProfile(profile);
        return profile;
    }
}
