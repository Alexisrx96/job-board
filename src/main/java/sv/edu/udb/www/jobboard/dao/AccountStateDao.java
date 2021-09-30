package sv.edu.udb.www.jobboard.dao;


import sv.edu.udb.www.jobboard.models.AccountState;

import java.util.List;

public interface AccountStateDao {
    List<AccountState> getAccountStates();
    AccountState getAccountState(int id);
}