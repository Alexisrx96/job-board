package sv.edu.udb.www.jobboard.models.dao;


import sv.edu.udb.www.jobboard.models.entities.AccountState;

import java.util.List;

public interface AccountStateDao {
    List<AccountState> getAccountStates();
    AccountState getAccountState(int id);
}