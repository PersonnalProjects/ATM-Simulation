package atm.controler;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import atm.dao.AccountDAO;
import atm.dao.TransactionDAO;
import atm.domain.Account;
import atm.domain.Transaction;
import atm.service.Connection;
import atm.service.WithdrawalManager;
/**
 * @author yves
 *
 */


import org.springframework.validation.BindException;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class WithdrawalControler extends SimpleFormController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    
	private AccountDAO accountDAO;
    private TransactionDAO transactionDAO;
    
    public TransactionDAO getTransactionDAO() {
		return transactionDAO;
	}

	public void setTransactionDAO(TransactionDAO transactionDAO) {
		this.transactionDAO = transactionDAO;
	}

	public AccountDAO getAccountDAO() {
		return accountDAO;
	}

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
	
	@Override
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object obj, BindException e)throws ServletException {
		
		logger.info("WithdrawalControler : onSubmit() - Starting............");	
		
		/*
        HttpSession session = request.getSession();
        if( session.getAttribute(Connection.ATT_CARD_NUMBER) == null)
        	return new ModelAndView(new RedirectView("login.htm"));		
       */
		
		Principal principal = request.getUserPrincipal();
		
    	WithdrawalManager withdrawalForm = (WithdrawalManager) obj;
	
		Account account =  accountDAO.getAccount(principal.getName());
		boolean status = false;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = Calendar.getInstance().getTime();        
		String nowString = df.format(now);						
		
		if( withdrawalForm.getAmount() <= account.getBalance())
		{
			System.out.println("Withdrawal BALANCE: " +account.getBalance() + "EST SUPERIEURE OU EGALE AU MONTANT: "+ withdrawalForm.getAmount() );					
			//new account balance
			double balance = account.getBalance() - withdrawalForm.getAmount();
			account.setBalance(balance);						
			//saving the account
			if(accountDAO.SaveAccount(account))
				status = true;
			
			//saving the transaction ( even if saving the account failed)
			Transaction transaction = transactionDAO.CreateTransaction(withdrawalForm.getAmount(), status,  nowString, Transaction.withdrawal, account.getAccountNumber());
			transactionDAO.SaveTransaction(transaction);				
		}
		else
		{
			System.out.println("Withdrawal AMOUNT: " + withdrawalForm.getAmount() + "EST SUPERIEUR A LA BALANCE: "+ account.getBalance());
			logger.info("Fond inssufissant!!!!!! Transaction rejetée ");

			//errors.rejectValue("amount", "error.insufficient-fund", null, "Insufficient fund.");
			
			//saving the transaction ( even if saving the account failed)
			Transaction transaction = transactionDAO.CreateTransaction(withdrawalForm.getAmount(), status,  nowString, Transaction.withdrawal, account.getAccountNumber());
			transactionDAO.SaveTransaction(transaction);
			
			return new ModelAndView( new RedirectView("withdrawal.htm"));
		}    
		
		logger.info("WithdrawalControler : onSubmit() - Finishing............");	        
        return new ModelAndView(new RedirectView(getSuccessView()));
    }

}
