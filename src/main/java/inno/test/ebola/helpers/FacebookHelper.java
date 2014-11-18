package inno.test.ebola.helpers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;

public class FacebookHelper  {
	static String accessToken="";
	static DefaultFacebookClient client;
	
	public static String postMessage(String code, String message){
	   
		// AccessToken accessToken = client.obtainAppAccessToken("315817055276955", "b6c6a7b6d72e514be6d449741d9b4cc5");
		//FacebookHelper.accessToken = accessToken.getAccessToken();
		try{
	    String g = "https://graph.facebook.com/oauth/access_token?client_id=315817055276955&redirect_uri=" + URLEncoder.encode("http://thermal-well-768.appspot.com/sign", "UTF-8") + "&client_secret=b6c6a7b6d72e514be6d449741d9b4cc5" + code;
        URL u = new URL(g);
        URLConnection c = u.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
        String inputLine;
        StringBuffer b = new StringBuffer();
        while ((inputLine = in.readLine()) != null)
            b.append(inputLine + "\n");            
        in.close();
      String  token = b.toString();
        client = new DefaultFacebookClient(token);
		FacebookType publishMessageResponse =
				  client.publish("me/feed", FacebookType.class,
				    Parameter.with("message", message));
		return publishMessageResponse.getId();
		}
		catch(Exception e){
			
		}
		return null;

				
	}
	
	

}
