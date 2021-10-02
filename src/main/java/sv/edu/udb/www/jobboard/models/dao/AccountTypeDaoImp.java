package sv.edu.udb.www.jobboard.models.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.www.jobboard.models.entities.AccountType;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class AccountTypeDaoImp implements AccountTypeDao {
    @Autowired
    EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<AccountType> getAccountTypes() {
        String query = "FROM AccountType";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public AccountType getAccountType(int id) {
        return entityManager.find(AccountType.class,id);
    }
}