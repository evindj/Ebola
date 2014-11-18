package inno.test.ebola.helpers;
import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

public class MstfTranslate {
    

   public static void setSecret(){
	   Translate.setClientId("myaaplicationid123");
	    Translate.setClientSecret("4okTBRUFeXqss3/6D8sFpxPQ8YA0Hii76wnXV+cdfB4=");	    
   }
   
   // the starting language is always english as for now
   @SuppressWarnings("finally")
public static String translate(String message, Language arrive){
	   String translatedText="";
	   try {
		   setSecret();
	   translatedText = Translate.execute(message, Language.ENGLISH, arrive);
		return translatedText;
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	}
	   finally{
		   return translatedText;
	   }
   }
   
  
}
