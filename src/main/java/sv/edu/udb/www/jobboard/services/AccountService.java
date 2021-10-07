package sv.edu.udb.www.jobboard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.udb.www.jobboard.models.dao.*;

@Service
public class AccountService {
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


}
