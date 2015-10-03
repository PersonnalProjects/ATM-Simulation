/**
 * 
 */
package org.projects.spring.atm.simulation.controller;

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

import org.projects.spring.atm.simulation.service.Connection;

import java.io.IOException;

public class TransactionsPanelControler implements Controller {

    protected final Log logger = LogFactory.getLog(getClass());

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		logger.info("TransactionsPanelControler : handleRequest() - Starting............");	    	
    	
        HttpSession session = request.getSession();
        if( session.getAttribute(Connection.ATT_CARD_NUMBER) == null)
        	return new ModelAndView(new RedirectView("login.htm"));
        
        
		logger.info("TransactionsPanelControler : handleRequest() - Finishing............");	
		
        return new ModelAndView("transactions_panel");
    }

}