import java.security.NoSuchAlgorithmException;
class PasswordCrackerFactory
{
    public static Cracker getInstance(int method,String rightPassword)  throws  NoSuchAlgorithmException
 {
        Cracker cracker = null;
        String fPassword="Not found" ;
        if(method == 1 ){
          cracker  = new BruteForceCracker(rightPassword,fPassword) ;
        }
         if(method == 2){
          cracker  = new DictionaryCracker(rightPassword,fPassword) ;
        }
        if(method == 3){
          cracker  = new RainbowCracker(rightPassword,fPassword) ;
        }
        if(method == 4){
          cracker  = new RainbowCrackerSha(rightPassword,fPassword) ;
        }
        if(method == 5){
          cracker  = new Cracker();
          fPassword = HachGenerator.md5(rightPassword) ;
          HachGenerator h = new HachGenerator() ;
         h.addWord(rightPassword) ;
          cracker.setRightPassword(rightPassword) ; 
          cracker.setFoundPassword(fPassword) ;
        }
        if(method == 6){
          cracker  = new Cracker();
          fPassword = RainbowCrackerSha.sha256Hash(rightPassword) ;
          cracker.setRightPassword(rightPassword) ; 
          cracker.setFoundPassword(fPassword) ;
        }
        


        return cracker ;
  }

}