package inno.test.ebola.helpers;
import java.util.Random;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

public class MstfTranslate {
    

   public static void setSecret(){
	   Translate.setClientId("myaaplicationid123");
	    Translate.setClientSecret("4okTBRUFeXqss3/6D8sFpxPQ8YA0Hii76wnXV+cdfB4=");	    
   }
   
   // the starting language is always english as for now
   @SuppressWarnings("finally")
public static String translate(String message){
	   String translatedText="";
	   try {
		   setSecret();
	   Language[] langSet= Language.values();
	   Random randomGenerator = new Random();
	   int randomInt = randomGenerator.nextInt(langSet.length);
	   translatedText = Translate.execute(message, Language.ENGLISH, langSet[randomInt]);
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
