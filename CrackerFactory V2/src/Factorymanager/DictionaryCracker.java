import java.io.BufferedReader ;
import java.io.BufferedWriter;
import java.io.FileReader ;
import java.io.FileWriter;
import java.io.IOException ;
import java.net.URISyntaxException;

// c'est une classe cracker qui utilise la methode du dictionnaire
class DictionaryCracker extends Cracker
{

       public DictionaryCracker(String username,String foundPassword) throws URISyntaxException
       { 
        super(username,foundPassword) ;
        String word="" ;

        try
        {

            BufferedReader reader = new BufferedReader(new FileReader("../files/dico.txt")) ;
           
            while(word != null)

            {
                word = reader.readLine() ;
                if(Connexion._connexion(this.username,word)== 0){
                    this.foundPassword = word;
                    break;
                }
            }

            reader.close();    
                        
        } catch(IOException e)
           {
            e.printStackTrace() ;
           }
          
           
       } 
       public static void addWordToDico(String word){
         try{
         BufferedWriter writer = new BufferedWriter(new FileWriter("../files/dico.txt",true)) ;
          writer.write(word+"\n") ;
          writer.close() ;  
            }
            catch(IOException e)
           {
            e.printStackTrace() ;
           }
        }
   
}