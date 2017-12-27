package dev.service;

import dev.entity.Account;

import java.util.List;

public interface AccountService {

	Account getAccount(String username);

	List<Account> getAllKFAccount();

	Account getAccount(String username, String password);

	void insertAccount(Account account);

	void updateAccount(Account account);
}
