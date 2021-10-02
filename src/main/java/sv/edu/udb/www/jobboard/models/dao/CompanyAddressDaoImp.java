package sv.edu.udb.www.jobboard.models.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.www.jobboard.models.entities.CompanyAddress;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class CompanyAddressDaoImp implements CompanyAddressDao{
    @Autowired
    EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<CompanyAddress> getCompanyAddresses() {
        String query = "FROM CompanyAddress";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public CompanyAddress getCompanyAddress(int id) {
        return entityManager.find(CompanyAddress.class,id);
    }

    @Override
    public void updateCompanyAddress(CompanyAddress companyAddress) {
        entityManager.merge(companyAddress);
    }

    @Override
    public void deleteCompanyAddress(int id) {
        CompanyAddress companyAddress = entityManager.find(CompanyAddress.class,id);
        entityManager.remove(companyAddress);
    }

    @Override
    public void createCompanyAddress(CompanyAddress companyAddress) {
        // int id == undefined
        entityManager.persist(companyAddress);
        //  id = último id
    }
}