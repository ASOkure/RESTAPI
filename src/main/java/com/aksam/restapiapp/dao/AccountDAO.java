package com.aksam.restapiapp.dao;

import java.math.BigDecimal;
import java.util.List;

import com.aksam.restapiapp.exception.CustomException;
import com.aksam.restapiapp.model.Account;
import com.aksam.restapiapp.model.UserTransaction;

public interface AccountDAO {
	
	
	 List<Account> getAllAccounts() throws CustomException;
	    Account getAccountById(long accountId) throws CustomException;
	    long createAccount(Account account) throws CustomException;
	    int deleteAccountById(long accountId) throws CustomException;

	    /**
	     *
	     * @param accountId user accountId
	     * @param deltaAmount amount to be debit(less than 0)/credit(greater than 0).
	     * @return no. of rows updated
	     */
	    int updateAccountBalance(long accountId, BigDecimal deltaAmount) throws CustomException;
	    int transferAccountBalance(UserTransaction userTransaction) throws CustomException;

}
