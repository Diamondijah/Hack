import java.io.BufferedReader ;
import java.io.BufferedWriter ;
import java.io.FileReader ;
import java.io.FileWriter ;
import java.io.IOException ;
import java.nio.charset.*;
import java.security.*;


/* 
la fonction md5 permet de generer un hash avec le mot comme parametre
la fonction addWord permet de renseigner un mot et son hash dans le fichier hash.txt
dicoHash genere les mots du fichier dico.txt
*/
class HachGenerator
{
 
 public void dicoHash() throws NoSuchAlgorithmException
 {
   try
        {

            String word="hello crack" ;
            BufferedReader reader = new BufferedReader(new FileReader("../files/dico.txt")) ;
           
            while((word = reader.readLine()) != null)
            {                
                HachGenerator h = new HachGenerator() ;
                h.addWord(word.toLowerCase()) ;

            }

            reader.close(); 
                        

        } catch(IOException e)
           {
            e.printStackTrace() ;
           }
          
            
 } 


       public static String  md5 (String word) throws NoSuchAlgorithmException
       {
        MessageDigest msg = MessageDigest.getInstance("MD5");
        byte[] hash = msg.digest(word.getBytes(StandardCharsets.UTF_8));
             //can use isEquals of messageDigest
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
            return sb.toString();
        }



        public void addWord(String word) throws NoSuchAlgorithmException{
         try{
         BufferedWriter writer = new BufferedWriter(new FileWriter("../files/hash.txt",true)) ;
          writer.write(md5(word)+" : "+word+"\n") ;
          writer.close() ;  
            }
            catch(IOException e)
           {
            e.printStackTrace() ;
           }

        }

 
}





