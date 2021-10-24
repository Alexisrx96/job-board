package sv.edu.udb.www.jobboard.models.dao;


import sv.edu.udb.www.jobboard.models.entities.Account;

import java.util.List;

public interface AccountDao {
    List<Account> getAccounts();
    Account getAccount(String email);
    void updateAccount(Account account);
    void deleteAccount(String email);
    void createAccount(Account account);
}