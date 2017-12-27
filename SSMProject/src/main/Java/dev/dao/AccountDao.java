package dev.dao;

import dev.entity.Account;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AccountDao {
	Account getAccountByUsername(String username);


	List<Account> getAllKFAccount();

	Account getAccountByUsernameAndPassword(String username, String password);

	void insertAccount(Account account);

	void updateAccount(Account account);

	void insertSignon(Account account);

	void updateSignon(Account account);
}
