import java.util.Scanner ;
import java.security.NoSuchAlgorithmException;
public class Main{
	public static void main(String[] args) throws NoSuchAlgorithmException
	{
		
		System.out.println("Bienvenue dans votre application de crackage de code!");
		
			menu();

	}

	static void menu()throws NoSuchAlgorithmException{
		String password = " ";
		Scanner sc = new Scanner(System.in) ;
		Scanner sc2 = new Scanner(System.in) ;
		int methode = -1 ;
		do{
		System.out.println("===============================================");
            System.out.println("|          MENU PRINCIPAL                     |");
            System.out.println("===============================================");
            System.out.println("| 1. Brute force                              |");
            System.out.println("| 2. Dictionnaire                             |");
            System.out.println("| 3. Rainbow table MD5                        |");
            System.out.println("| 4. Rainbow table SHA                        |");
            System.out.println("| 5. Cryptage MD5                             |");
            System.out.println("| 6. Cryptage SHA                             |");
            System.out.println("| 7. Connexion à SecretKeeper                |");
            System.out.println("| 8. Quitter                                  |");
            System.out.println("===============================================");
		System.out.print("OPTION : ") ;	
		methode = sc.nextInt() ;

		while(methode < 1 || methode > 8) 
		{
		System.out.println("Precisez une methode sur la liste") ;
		System.out.print("OPTION : ") ;
		 methode = sc.nextInt() ;
		}

		switch (methode)
		{   
			case 1 :
				System.out.println("Nous ne craquons que des mots de passe de six lettres alphanumerique au plus pour le moment !") ;
				System.out.print("Mot de passe : ") ;
                password = sc2.next() ;
				break ;
            case 2 :
				System.out.println("le dictionnaire est francais et ne prend en compte que les lettres alphabétiques minuscule") ;
				System.out.print("Mot de passe : ") ;
                password = sc2.next() ;
				break ;
			case 3 :
			   	System.out.println("Donner le Hash MD5 et nous trouverons peut-etre le mot de passe!") ;
				System.out.print("Hash : ") ;
                password = sc2.next() ;

				while(password.length() != 32) 
				{
				System.out.println("Precisez un hash valide de 32 char caracteres") ;
				System.out.print("Hash : ") ;
				password = sc2.next() ;
			    }
				break ;   
			case 4 :
			   	System.out.println("Donner le Hash et nous trouverons peut-etre le mot de passe!") ;
				System.out.print("Hash : ") ;
                password = sc2.next() ;

				while(password.length() != 64) 
				{
				System.out.println("Precisez un hash valide de 64 caracteres") ;
				System.out.print("Hash : ") ;
				password = sc2.next() ;
			    }
				break ; 
			case 5 :
				System.out.println("Cryptage MD5") ;
				System.out.print("Mot de passe : ") ;
                password = sc2.next() ;
				break ;	 

			case 6 :
				System.out.println("Cryptage SHA256") ;
				System.out.print("Mot de passe : ") ;
                password = sc2.next() ;
				break ;	
			case 7 :
			    Connexion.connexion() ;
				break ;	 

			case 8 :
			  sc.close();
			  sc2.close();
			   return ;	
		} 
        if(methode >=1  && methode <= 6 ){
        System.out.println("Patientez on va deviner le mot de passe.Cela peut prendre du temps") ;
		Cracker cracker = PasswordCrackerFactory.getInstance(methode,password) ;

        System.out.println("the password is : "+cracker.getFoundPassword()) ;
		
		}
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}while(methode!=8) ;
		sc.close() ;
		sc2.close();

	}
	

	 
}