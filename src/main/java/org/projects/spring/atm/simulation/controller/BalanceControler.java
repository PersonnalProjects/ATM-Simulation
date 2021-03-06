package org.projects.spring.atm.simulation.controller;
import org.projects.spring.atm.simulation.service.Connection;
import org.projects.spring.atm.simulation.dao.AccountDAO;

/**
 * @author yves
 *
 */
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;


public class BalanceControler implements Controller {
	
	private final String getMethod = "GET";
	private final String  postMethod = "POST";
    protected final Log logger = LogFactory.getLog(getClass());
    private AccountDAO accountDAO;


	public AccountDAO getAccountDAO() {
		return accountDAO;
	}


	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		logger.info("BalanceControler : handleRequest() - Starting............");				
        HttpSession session = request.getSession();
        if( session.getAttribute(Connection.ATT_CARD_NUMBER) == null)
        	return new ModelAndView(new RedirectView("login.htm"));		
		
          
        if( this.postMethod.equalsIgnoreCase( request.getMethod().toString()) )
        {
        	logger.info("BalanceControler : handleRequest() - Finishing............");		
        	return new ModelAndView( new RedirectView("transactions_panel.htm")); 	
        }
        else
        {
        	logger.info("BalanceControler : handleRequest() - Finishing............");		
        	return new ModelAndView("balance", "balance", accountDAO.getAccount(session.getAttribute(Connection.ATT_ACCOUNT_NUMBER).toString()).getBalance()); 
        }
    }
	
}
