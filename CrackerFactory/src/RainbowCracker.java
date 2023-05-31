import java.io.BufferedReader ;
import java.io.FileReader ;
import java.io.IOException ;
// c'est une classe cracker qui utilise la methode de la table de hachage (rainbow table)
class RainbowCracker extends Cracker 
{

     public RainbowCracker(String rightPassword,String foundPassword)
       { 
        super(rightPassword,foundPassword) ;
          try
        {

              BufferedReader reader = new BufferedReader(new FileReader("../files/hash.txt")) ;
              String line = "" ;
              this.foundPassword="" ;
            while((line = reader.readLine())!= null)
            {
              String hash = "" ;
              for(int i = 0 ; i < 32 ; i++)
              {
                  hash+=line.charAt(i) ;
              } 

              if(hash.equals(this.rightPassword))
              {
                for(int i = 35 ; i < line.length() ; i++)
                {
                  this.foundPassword+=line.charAt(i) ;
                }

                break ;
              } 


            }

            reader.close();    
                        
            if (this.foundPassword == null) this.foundPassword = "Not Found" ;

        } catch(IOException e)
           {
            e.printStackTrace() ;
           }
          

       }


}