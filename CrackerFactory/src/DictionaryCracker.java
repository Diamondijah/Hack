import java.io.BufferedReader ;
import java.io.FileReader ;
import java.io.IOException ;

// c'est une classe cracker qui utilise la methode du dictionnaire
class DictionaryCracker extends Cracker
{

       public DictionaryCracker(String rightPassword,String foundPassword)
       { 
        super(rightPassword,foundPassword) ;

        try
        {

            BufferedReader reader = new BufferedReader(new FileReader("../files/dico.txt")) ;
           
            while((this.foundPassword != null)&&(!this.foundPassword.equals(this.rightPassword)))
            {
                this.foundPassword = reader.readLine() ;
            }

            reader.close();    
                        
            if (this.foundPassword == null) this.foundPassword = "Not Found" ;

        } catch(IOException e)
           {
            e.printStackTrace() ;
           }
          
           
       } 
   
}