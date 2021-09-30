package sv.edu.udb.www.jobboard.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.www.jobboard.models.Account;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class AccountDaoImp implements AccountDao{
    
    @Autowired
    EntityManager entityManager;

    @Override
    public List<Account> getAccounts() {
        String query = "FROM Account";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Account getAccount(String email) {
        return entityManager.find(Account.class,email);
    }

    @Override
    public void updateAccount(Account account) {
        entityManager.merge(account);
    }

    @Override
    public void deleteAccount(String email) {
        Account account = entityManager.find(Account.class,email);
        entityManager.remove(account);
    }

    @Override
    public void createAccount(Account account) {
        entityManager.persist(account);
    }
}