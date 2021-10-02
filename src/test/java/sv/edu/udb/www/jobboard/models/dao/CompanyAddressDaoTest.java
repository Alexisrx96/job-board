package sv.edu.udb.www.jobboard.models.dao;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sv.edu.udb.www.jobboard.models.entities.CompanyAddress;
import sv.edu.udb.www.jobboard.models.entities.CompanyProfile;

import static org.junit.jupiter.api.Assertions.*;

class CompanyAddressDaoTest {
    @Autowired
    CompanyProfileDao companyProfileDao;
    @Autowired
    CompanyAddressDao companyAddressDao;
    @Test
    void getCompanyAddresses() {
        companyAddressDao.getCompanyAddresses().forEach(c->System.out.println());
    }

    @Test
    void getCompanyAddress() {
        System.out.println(companyAddressDao.getCompanyAddress(1));
    }

    @Test
    void updateCompanyAddress() {
        CompanyAddress newAddress = companyAddressDao.getCompanyAddress(1);
        CompanyAddress oldAddress = new CompanyAddress();
        oldAddress.setAddress(newAddress.getAddress());
        newAddress.setAddress("new address");
        companyAddressDao.updateCompanyAddress(newAddress);
        newAddress = companyAddressDao.getCompanyAddress(1);
        Assert.assertFalse(newAddress.getAddress().equals(oldAddress.getAddress()));
    }

    @Test
    void deleteCompanyAddress() {
        companyAddressDao.deleteCompanyAddress(1);
        CompanyAddress address = companyAddressDao.getCompanyAddress(1);
        Assert.assertTrue(address==null);
    }

    @Test
    void createCompanyAddress() {
        CompanyAddress companyAddress = new CompanyAddress();
        companyAddress.setCompany(new CompanyProfile());
        companyAddress.setAddress("new address");
        companyAddressDao.createCompanyAddress(companyAddress);
        CompanyAddress created = companyAddressDao.getCompanyAddress(companyAddress.getId());
        Assert.assertTrue(created != null);
    }
}