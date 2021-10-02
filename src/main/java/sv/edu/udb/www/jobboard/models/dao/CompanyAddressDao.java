package sv.edu.udb.www.jobboard.models.dao;

import sv.edu.udb.www.jobboard.models.entities.CompanyAddress;

import java.util.List;

public interface CompanyAddressDao {
    List<CompanyAddress> getCompanyAddresses();
    CompanyAddress getCompanyAddress(int id);
    void updateCompanyAddress(CompanyAddress companyAddress);
    void deleteCompanyAddress(int id);
    void createCompanyAddress(CompanyAddress companyAddress);
}