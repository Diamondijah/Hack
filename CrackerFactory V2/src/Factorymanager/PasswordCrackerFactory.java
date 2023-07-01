import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
class PasswordCrackerFactory
{
    public static Cracker getInstance(int method,String username)  throws  NoSuchAlgorithmException, URISyntaxException
 {
        Cracker cracker = null;
        String fPassword="not found" ;
        if(method == 1 ){
          cracker  = new BruteForceCracker(username,fPassword) ;
           if(!cracker.getFoundPassword().equals("not found")){
           DictionaryCracker.addWordToDico(cracker.getFoundPassword()) ;
          }
        }
         if(method == 2){
          cracker  = new DictionaryCracker(username,fPassword) ;
           if(!cracker.getFoundPassword().equals("not found")){
           DictionaryCracker.addWordToDico(cracker.getFoundPassword()) ;
          }
        }
        return cracker ;
  }

}