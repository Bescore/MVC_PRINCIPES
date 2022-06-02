package controllers;

import modèles.Client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudClient {
	Connection connecti = new Connections().getConnection();

	public Client create(String prenom, String nom, String email) {
		Client newClient = new Client(prenom, nom, email);
		newClient.setPrenom(prenom);
		newClient.setNom(nom);
		newClient.setEmail(email);
		try {
			Statement statement = connecti.createStatement();
			statement.executeUpdate("INSERT INTO client (nom,prenom,email) VALUES ('" + newClient.getNom() + "','"
					+ newClient.getPrenom() + "','" + newClient.getEmail() + "') ");
			System.out.println(" entrées inséré dans la base \n");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Client modif(String prenom, String nom, String email) {
		Client newClient = new Client(prenom, nom, email);
		Boolean IsExist = false;
		try {
			Statement statement = connecti.createStatement();
			ResultSet rs = statement.executeQuery("Select * from client ");

			while (rs.next()) {
				String mail = rs.getString("email");
				if (mail.equalsIgnoreCase(newClient.getEmail())) {
					statement.executeUpdate("UPDATE client SET nom='" + newClient.getNom() + "', prenom='"
							+ newClient.getPrenom() + "' WHERE email='" + newClient.getEmail() + "'");
					IsExist = true;
					System.out.println("donné modifié !");
				}

			}

			if (IsExist == false) {
				System.out.println("Cette email n'est pas présente dans la base de donnée\r\n" + "");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newClient;
	}

	public void affiche() {
		try {
			Statement statement = connecti.createStatement();
			ResultSet rs = statement.executeQuery("Select * from client ");

			while (rs.next()) {
				System.out.println(
						rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Client erase(String email) {
		Client newClient = new Client(email);
		try {
			Statement statement = connecti.createStatement();
			statement.executeUpdate("DELETE FROM client WHERE email='" + newClient.getEmail() +"'");
			System.out.println(" supprimé \n");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Client searchMail(String email) {
		Client newClient = new Client(email);

		Boolean IsExist = false;
		try {
			Statement statement = connecti.createStatement();
			ResultSet rs = statement.executeQuery("Select * from client ");

			while (rs.next()) {
				String mail = rs.getString("email");
				if (mail.equalsIgnoreCase(newClient.getEmail())) {
					System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
					IsExist = true;
				}

			}

			if (IsExist == false) {
				System.out.println("Cette email n'est pas présente dans la base de donnée\r\n" + "");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newClient;
	}

}
