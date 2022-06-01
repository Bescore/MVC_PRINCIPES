package controllers;

import modèles.Client;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class CrudClient {
	Connection connecti= new Connections().getConnection();
	
	
	public Client create() {
		Client zak=new Client();
		zak.setPrenom("zak");
		zak.setNom("Kassimi");
		try {
			Statement statement= connecti.createStatement();
			statement.executeUpdate("INSERT INTO client (nom,prenom,email) VALUES ('kassimi','Zak','zak@kas') ");
			System.out.println("ok inséré");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return zak;
	}
	
}
