package sv.edu.udb.www.jobboard.models.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.www.jobboard.models.entities.CompanyProfile;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional


public class CompanyProfileDaoImp implements CompanyProfileDao{

    @Autowired
    EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<CompanyProfile> getCompanyProfiles() {
        String query = "FROM CompanyProfile";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public CompanyProfile getCompanyProfileByEmail(String email) {
        String query = "SELECT C FROM CompanyProfile C WHERE C.email like ?1";
        return entityManager.createQuery(query,CompanyProfile.class)
                .setParameter(1, email).getSingleResult();
    }

    @Override
    public CompanyProfile getCompanyProfile(int id) {
        return entityManager.find(CompanyProfile.class,id);
    }

    @Override
    public void updateCompanyProfile(CompanyProfile companyProfile) {
        entityManager.merge(companyProfile);
    }

    @Override
    public void deleteCompanyProfile(int id) {
        CompanyProfile companyProfile = getCompanyProfile(id);
        entityManager.remove(companyProfile);
    }

    @Override
    public void createCompanyProfile(CompanyProfile companyProfile) {
        entityManager.persist(companyProfile);
    }
}





