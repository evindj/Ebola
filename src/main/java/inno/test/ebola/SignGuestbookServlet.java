/**
 * Copyright 2012 Google Inc. All Rights Reserved. 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package inno.test.ebola;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import inno.test.ebola.helpers.FacebookHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

public class SignGuestbookServlet extends HttpServlet {
	
	
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {
	  String code = req.getParameter("code");
      if (code == null || code.equals("")) {
          // an error occurred, handle this
      }
	  else{
		 

	    
	      Key codeKey = KeyFactory.createKey("Guestbook", code);
	      String content = req.getParameter("content");
	      Date date = new Date();
	      Entity token = new Entity("Token", codeKey);
	      token.setProperty("code", code);
	     
	      DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	      datastore.put(token);
		   FacebookHelper.postMessage(code,"test");
		   resp.sendRedirect("/Thanks.html");
		   //store in the datastore
		   //display popup
	  } 
    

    resp.sendRedirect("guestbook/.jsp");
  }
  
 
 
}
