import java.util.Scanner ;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
public class Main{
	public static void main(String[] args) throws NoSuchAlgorithmException
	{
		
		
			try {
			System.out.println("Bienvenue dans votre application de crackage de mot de passe du site secret keeper!");

				menu();
			} catch (URISyntaxException e) {
				
				e.printStackTrace();
			}

	}

	static void menu()throws NoSuchAlgorithmException, URISyntaxException{
		String username = " ";
		Scanner sc = new Scanner(System.in) ;
		Scanner sc2 = new Scanner(System.in) ;
		int methode = -1 ;
		do{
		 System.out.println("==================================");
            System.out.println("|         MENU PRINCIPAL         |");
            System.out.println("==================================");
            System.out.println("| 1. Brute force                 |");
            System.out.println("| 2. Dictionnaire                |");
            System.out.println("| 3. Connexion à SecretKeeper   |");
            System.out.println("| 4. Quitter                     |");
            System.out.println("==================================");
		System.out.print("OPTION : ") ;

		 methode = sc.nextInt() ;

		while(methode < 1 || methode > 4) 
		{
		System.out.println("Precisez une OPTION sur la liste") ;
		System.out.print("OPTION : ") ;
		 methode = sc.nextInt() ;
		}

		switch (methode)
		{   
			case 1 :
				System.out.println("Nous ne craquons que des mots de passe de six symboles alphanumerique au plus pour le moment !") ;
				System.out.print("Username : ") ;
                username = sc2.next() ;
				break ;
            case 2 :
				System.out.println("le dictionnaire est francais et ne prend en compte que les lettres alphabétiques") ;
				System.out.print("Username : ") ;
                username = sc2.next() ;
				break ;
			case 3 :
			    Connexion.connexion() ;
				break ;	
				
			case 4 :
				return ;		
		} 
        if(methode >=1  && methode <= 2 ){
        System.out.println("Patientez on va deviner le mot de passe.Cela peut prendre du temps") ;
		Cracker cracker = PasswordCrackerFactory.getInstance(methode,username) ;

        System.out.println("the password is : "+cracker.getFoundPassword()) ;
		
		}

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}while(methode !=4) ;
	
		sc.close() ;
		sc2.close();

	}
	

	 
}