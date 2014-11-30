
package atm.controler;
import atm.service.Connection;
import atm.service.TransactionManager;



import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @author yves
 *
 */
//import org.springframework.web.servlet.mvc.SimpleFormController;
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

public class DisconnectionControler implements Controller {
	
    protected final Log logger = LogFactory.getLog(getClass());

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		logger.info("DisconnectionControler : handleRequest() - Starting............");		
		
        HttpSession session = request.getSession();   
        try{
        	session.invalidate();
        }
        catch(Exception e){
        	logger.info("DisconnectionControler : handleRequest() - Session has already been invalidated...");
        }
        
        
        logger.info("DisconnectionControler : handleRequest() - Finishing............");        
        return new ModelAndView( new RedirectView("login.htm")); 	

    }
	
}
	