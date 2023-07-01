import java.net.http.* ;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;
import java.io.IOException;
import java.net.*;


 public class Connexion{
    public static void connexion() {
         Scanner scanner = new Scanner(System.in) ;
         Scanner scanner2 = new Scanner(System.in) ;
         System.out.println("Connexion à MySecretKeeper") ;
				System.out.print("Username : ") ;
				String username = scanner.next() ;
				System.out.print("Mot de passe : ") ;
                String mdp = scanner2.nextLine() ;
        try {
            _connexion(username,mdp);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } 
     }
    static int  _connexion(String username,String mdp ) throws URISyntaxException{
       
        URI uri = new URI("http://localhost/secretkeeper/log.php?user="+username+"&pwd="+mdp+"&getsecret") ;
          
        HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build() ;

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> reponse ;
        try {
            reponse =   client.send(request, BodyHandlers.ofString()) ;
            if(reponse.statusCode() != 200 ){
            System.out.println("Information erroné.veuillez réessayer")  ;
            
            return 1 ; 
            }
            else{
              System.out.println(reponse.body())  ;  
              
              return 0 ;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      
       return 1;
    }

}