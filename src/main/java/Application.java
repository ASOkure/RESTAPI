

import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

import com.aksam.restapiapp.dao.DAOFactory;
import com.aksam.restapiapp.service.AccountService;
import com.aksam.restapiapp.service.ServiceExceptionMapper;
import com.aksam.restapiapp.service.TransactionService;
import com.aksam.restapiapp.service.UserService;

public class Application {

 private static Logger log = Logger.getLogger(Application.class);

	public static void main(String[] args) throws Exception {
		// Initialize H2 database with demo data
		log.info("Initialize demo .....");
		DAOFactory h2DaoFactory = DAOFactory.getDAOFactory(DAOFactory.H2);
		h2DaoFactory.populateTestData();
		log.info("Initialisation Complete....");
		// Host service on jetty
		startService();
	}

	private static void startService() throws Exception {
		Server server = new Server(8080);
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		server.setHandler(context);
		ServletHolder servletHolder = context.addServlet(ServletContainer.class, "/*");
		servletHolder.setInitParameter("jersey.config.server.provider.classnames",
				UserService.class.getCanonicalName() + "," + AccountService.class.getCanonicalName() + ","
						+ ServiceExceptionMapper.class.getCanonicalName() + ","
						+ TransactionService.class.getCanonicalName());
		try {
			server.start();
			server.join();
		} finally {
			server.destroy();
		}
	}

}

