package dev.service.imple;

import dev.dao.AccountDao;
import dev.entity.Account;
import dev.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImple implements AccountService {
	@Autowired
	private AccountDao accountDao;

	public Account getAccount(String username) {
		return accountDao.getAccountByUsername(username);
	}
	public List<Account> getAllKFAccount() {
		return accountDao.getAllKFAccount();
	}

	public Account getAccount(String username, String password) {
		return accountDao.getAccountByUsernameAndPassword(username, password);
	}

	@Transactional
	public void insertAccount(Account account) {
		accountDao.insertAccount(account);
		accountDao.insertSignon(account);
	}

	@Transactional
	public void updateAccount(Account account) {
		accountDao.updateAccount(account);

		if (account.getPassword() != null && account.getPassword().length() > 0) {
			accountDao.updateSignon(account);
		}
	}
}
