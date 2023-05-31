import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
class RainbowCrackerSha extends Cracker 
{

     public RainbowCrackerSha(String rightPassword,String foundPassword) throws NoSuchAlgorithmException
       { 
        super(rightPassword,foundPassword) ;
        try (BufferedReader reader = new BufferedReader(new FileReader("../files/dico.txt"))) {
            String mot;

            while ((mot = reader.readLine()) != null) {
                String hashedMot = sha256Hash(mot);
                if (hashedMot.equals(this.rightPassword)) {
                    this.foundPassword = mot ;
                
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


       }
       
        public static  String sha256Hash(String input) throws NoSuchAlgorithmException {
        StringBuilder hashedPassword = new StringBuilder();

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes());

            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 1) {
                    hashedPassword.append('0');
                }
                hashedPassword.append(hex);
            }
        } catch (NoSuchAlgorithmException e) {
            throw e;
        }

        return hashedPassword.toString();
     }
       
       }

