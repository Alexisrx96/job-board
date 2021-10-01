package sv.edu.udb.www.jobboard.models.dao;

import sv.edu.udb.www.jobboard.models.entities.AccountType;

import java.util.List;

public interface AccountTypeDao {
    List<AccountType> getAccountTypes();
    AccountType getAccountType(int id);
}