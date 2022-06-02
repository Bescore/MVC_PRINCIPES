package vues;

import java.util.Scanner;

import controllers.CrudClient;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner( System.in );
		System.out.print( "Que voulez vous faire ? \n \n"
		 		+ "1--Ajouter un utilisateur \n"
		 		+ "2--Afficher la liste \n"
		 		+ "3--Modifier un utilisateur \n"
		 		+ "4--Supprimer un utilisateur \n"
		 		+ "5--Rechercher un utilisateur via son email \n"
		 		+ "0--Quitter \n " );
		
		int choix;
		
			choix = scanner.nextInt();
			 switch (choix) {
			case 1: {
				Scanner scan = new Scanner( System.in );
				System.out.print("votre prénom? \n");
				String prenom = scan.nextLine();
				System.out.print("votre nom? \n");
				String nom = scan.nextLine();
				System.out.print("votre email? \n");
				String email = scan.nextLine();
				CrudClient crudClient = new CrudClient();
				crudClient.create(prenom,nom,email);
				scan.close();
				break;
			}
			case 2: {
				System.out.println("La liste des utilisateurs \n");
				CrudClient crudClient = new CrudClient();
				crudClient.affiche();
				break;
			}
			case 3: {
				Scanner sca = new Scanner( System.in );
				System.out.print("email dont vous aimeriez changer les informations ? \n");
				String email = sca.nextLine();
				System.out.print("modifier prénom? \n");
				String prenom = sca.nextLine();
				System.out.print("modifier nom? \n");
				String nom = sca.nextLine();
				CrudClient crudClient = new CrudClient();
				crudClient.modif(nom, prenom, email);
				sca.close();
				break;
			}
			case 4: {
				Scanner scans = new Scanner( System.in );
				System.out.println("adresse email de la personne à supprimer\n");
				CrudClient crudClient = new CrudClient();
				crudClient.erase(scans.nextLine());
				scans.close();
				break;
			}
			case 5: {
				Scanner scans = new Scanner( System.in );
				System.out.println("quel est l'email recherché \n");
				CrudClient crudClient = new CrudClient();
				crudClient.searchMail(scans.nextLine());
				scans.close();
				break;
			}
			default :{
				System.out.println("choix impossible dans ce programme");
			}
			
			 }
		/*CrudClient crudClient = new CrudClient();
		crudClient.dot();*/
		
		
	}

}
