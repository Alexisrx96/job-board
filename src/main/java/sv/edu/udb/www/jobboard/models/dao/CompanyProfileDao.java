package sv.edu.udb.www.jobboard.models.dao;

import sv.edu.udb.www.jobboard.models.entities.CompanyProfile;

import java.util.List;

public interface CompanyProfileDao {
    List<CompanyProfile> getCompanyProfiles();
    CompanyProfile getCompanyProfile (int id);
    CompanyProfile getCompanyProfileByEmail (String email);
    void updateCompanyProfile(CompanyProfile companyProfile);
    void deleteCompanyProfile(int id);
    void createCompanyProfile(CompanyProfile companyProfile);
}