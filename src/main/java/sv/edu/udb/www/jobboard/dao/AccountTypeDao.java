package sv.edu.udb.www.jobboard.dao;

import sv.edu.udb.www.jobboard.models.AccountType;

import java.util.List;

public interface AccountTypeDao {
    List<AccountType> getAccountTypes();
    AccountType getAccountType(int id);
}