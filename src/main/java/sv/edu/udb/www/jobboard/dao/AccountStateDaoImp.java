package sv.edu.udb.www.jobboard.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.www.jobboard.models.AccountState;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class AccountStateDaoImp implements AccountStateDao{
    @Autowired
    EntityManager entityManager;
    @Override
    public List<AccountState> getAccountStates() {
        String query = "FROM AccountState";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public AccountState getAccountState(int id) {
        return entityManager.find(AccountState.class, id);
    }
}