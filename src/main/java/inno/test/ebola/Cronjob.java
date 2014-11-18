package inno.test.ebola;

import inno.test.ebola.helpers.FacebookHelper;
import inno.test.ebola.helpers.MstfTranslate;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class Cronjob extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// read tokens from the Datastore
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		// Use class Query to assemble a query
		Query q = new Query("Token");

		// Use PreparedQuery interface to retrieve results
		PreparedQuery pq = datastore.prepare(q);


		for (Entity result : pq.asIterable()) {
		  String code = (String) result.getProperty("code");
		  Random randomGenerator = new Random();
		  int randomInt = randomGenerator.nextInt(ServiceHelper.tips.length);
		  FacebookHelper.postMessage(code,MstfTranslate.translate(ServiceHelper.tips[randomInt]) );
		}
		//translate and save on facebook.
		super.doGet(req, resp);
	}

}