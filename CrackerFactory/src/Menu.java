import java.util.Scanner ;
import java.security.NoSuchAlgorithmException;
public class Menu{
	public static void main(String[] args) throws NoSuchAlgorithmException{

        String password = " ";
		Scanner sc = new Scanner(System.in) ;
		Scanner sc2 = new Scanner(System.in) ;

 		System.out.println("Bienvenue dans votre application de crackage de code!") ;
		System.out.println("Precisez la methode que vous voulez utiliser\n\t1-Brute force\n\t2-Dictionnaire\n\t3-Rainbow table MD5\n\t4-Rainbow table SHA\n\t5-Cryptage MD5\n\t6-Cryptage SHA") ; //ajouter le cryptage aprés
		System.out.print("Methode : ") ;

		int methode = sc.nextInt() ;

		while(methode != 1 && methode !=2 && methode != 3 && methode != 4 && methode!=5 && methode!=6) 
		{
		System.out.println("Precisez une methode sur la liste") ;
		System.out.print("Methode : ") ;
		 methode = sc.nextInt() ;
		}

		switch (methode)
		{   
			case 1 :
				System.out.println("Nous ne craquons que des mots de passe de six lettres alphabetiques miniscules pour le moment !") ;
				System.out.print("Mot de passe : ") ;
                password = sc2.next() ;
				break ;
            case 2 :
				System.out.println("le dictionnaire est francais et ne prend en compte que les lettres alphabétiques") ;
				System.out.print("Mot de passe : ") ;
                password = sc2.next() ;
				break ;
			case 3 :
			   	System.out.println("Donner le Hash MD5 et nous trouverons peut-etre le mot de passe!") ;
				System.out.print("Hash : ") ;
                password = sc2.next() ;

				while(password.length() != 32) 
				{
				System.out.println("Precisez un hash valide"+ password.length()) ;
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
				System.out.println("Precisez un hash valide"+ password.length()) ;
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
		} 



        System.out.println("Patientez on va deviner le mot de passe.Cela peut prendre du temps") ;
		Cracker cracker = PasswordCrackerFactory.getInstance(methode,password) ;

        System.out.println("the password is : "+cracker.getFoundPassword()) ;
		
		 
	}

	 


}