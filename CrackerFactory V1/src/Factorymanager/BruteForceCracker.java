// c'est une classe cracker qui utilise la methode du bruteforce

class BruteForceCracker extends Cracker {
    
    public BruteForceCracker(String rightPassword,String foundPassword)
       { 
        super(rightPassword,foundPassword) ;

        // char [] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};
                char [] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'} ;

found:  for (int i = 0; i < 26; i++) 
         {
           for (int j = 0; j < 26; j++) 
           {
            for (int k = 0; k < 26; k++) 
            {
             for (int l = 0; l < 26; l++) 
             {
              for (int m = 0; m < 26; m++) 
              {
               for (int n = 0; n < 26; n++) 
               {
                   this.foundPassword = ""+alphabet[i]+alphabet[j]+alphabet[k]+alphabet[l]+alphabet[m]+alphabet[n] ;
                   if(this.foundPassword.equals(this.rightPassword))  break found ;
               }  
               this.foundPassword = ""+alphabet[i]+alphabet[j]+alphabet[k]+alphabet[l]+alphabet[m] ;
                   if(this.foundPassword.equals(this.rightPassword))  break found ;
              }  
              this.foundPassword = ""+alphabet[i]+alphabet[j]+alphabet[k]+alphabet[l];
                   if(this.foundPassword.equals(this.rightPassword))  break found ;
             }  
             this.foundPassword = ""+alphabet[i]+alphabet[j]+alphabet[k] ;
                   if(this.foundPassword.equals(this.rightPassword))  break found ;
            }  
            this.foundPassword = ""+alphabet[i]+alphabet[j] ;
                   if(this.foundPassword.equals(this.rightPassword))  break found ;
           }  
           this.foundPassword = ""+alphabet[i]
            ;
                   if(this.foundPassword.equals(this.rightPassword))  break found ;
         }  

      if(!this.foundPassword.equals(this.rightPassword))  this.foundPassword="Not Found"  ;
         
    }
}

