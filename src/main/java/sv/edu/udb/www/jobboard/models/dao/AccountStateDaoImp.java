package sv.edu.udb.www.jobboard.models.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.www.jobboard.models.entities.AccountState;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class AccountStateDaoImp implements AccountStateDao{
    @Autowired
    EntityManager entityManager;

    @SuppressWarnings("unchecked")
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