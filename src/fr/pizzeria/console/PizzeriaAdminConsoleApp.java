package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] menuDeBienvenue = new String[6];
		
		menuDeBienvenue[0] = "***** Pizzeria Administration *****";
		menuDeBienvenue[1] = "1. Lister les pizzas";
		menuDeBienvenue[2] = "2. Ajouter une nouvelle pizza";
		menuDeBienvenue[3] = "3. Mettre à jour une pizza";
		menuDeBienvenue[4] = "4. Supprimer une pizza";
		menuDeBienvenue[5] = "99. Sortir";
		
		Pizza pizza0 = new Pizza(0, "PEP", "Pépéroni", 12.50);
		Pizza pizza1 = new Pizza(1, "MAR", "Margherita", 14.00);
		Pizza pizza2 = new Pizza(2, "REI", "La Reine", 11.50);
		Pizza pizza3 = new Pizza(3, "FRO", "La 4 fromages", 12.00);
		Pizza pizza4 = new Pizza(4, "CAN", "La Cannibale", 12.50);
		Pizza pizza5 = new Pizza(5, "SAV", "La Savoyarde", 13.00);
		Pizza pizza6 = new Pizza(6, "ORI", "L'Orientale", 13.50);
		Pizza pizza7 = new Pizza(7, "IND", "L'Indienne", 14.00);
		
		Pizza[] carteDesPizzas = {
				pizza0,
				pizza1,
				pizza2,
				pizza3,
				pizza4,
				pizza5,
				pizza6,
				pizza7
		};
		
		Scanner sc = new Scanner(System.in);
		String userInput = "";
		
		while (!(userInput.equals("99"))) {
			PizzeriaAdminConsoleApp.afficherMenu(menuDeBienvenue);
			userInput = sc.nextLine();
			
			switch (userInput) {
				case ("1") : 
					System.out.println(menuDeBienvenue[1]);
					PizzeriaAdminConsoleApp.afficherCarte(carteDesPizzas);
				break;
				
				case ("2") : 
					System.out.println(menuDeBienvenue[2]);
					
					System.out.println("Veuillez saisir le code");
					String code = sc.nextLine();
					
					System.out.println("Veuillez saisir le nom (sans espace)");
					String nomPizza = sc.nextLine();
					
					System.out.println("Veuillez saisir le prix");
					Integer prix = Integer.parseInt(sc.nextLine());
					
					
					int dernierIndexCarte = carteDesPizzas[carteDesPizzas.length-1].getId();
					int nouvelIndex = dernierIndexCarte + 1;

					Pizza nouvellePizza = new Pizza(nouvelIndex, code, nomPizza, prix);
					
					Pizza[] carteTemporaireA = new Pizza[carteDesPizzas.length + 1];
					System.arraycopy(carteDesPizzas, 0, carteTemporaireA, 0, carteDesPizzas.length);
					carteTemporaireA[carteTemporaireA.length - 1] = nouvellePizza;
					
					carteDesPizzas = carteTemporaireA;
					
				break;
				
				case ("3") : 
					System.out.println(menuDeBienvenue[3]);
					PizzeriaAdminConsoleApp.afficherCarte(carteDesPizzas);
					
					System.out.println("Veuillez choisir le code de la pizza à modifier (en majuscules)");
					String userChoice = sc.nextLine();
					
					boolean trouve = false;
					
					for (Integer i = 0; i < carteDesPizzas.length; i++) {
						String codeCourant = carteDesPizzas[i].getCode();
						
						if (userChoice.equals(codeCourant)) {
							trouve = true;
							
							System.out.println("Veuillez saisir le code");
							String nouveauCode = sc.nextLine();
							
							System.out.println("Veuillez saisir le nom (sans espace)");
							String nouveauNom = sc.nextLine();
							
							System.out.println("Veuillez saisir le prix");
							Integer nouveauPrix = Integer.parseInt(sc.nextLine());
							
							carteDesPizzas[i] = new Pizza(i, nouveauCode, nouveauNom, nouveauPrix);
						}
					}
					
					if (!trouve) {
						System.out.println("Ce code n'existe pas.");
						System.out.println("Veuillez choisir le code de la pizza à modifier (en majuscules)");
					}
				break;
				
				case ("4") : 
					System.out.println(menuDeBienvenue[4]);
					
					PizzeriaAdminConsoleApp.afficherCarte(carteDesPizzas);
					
					System.out.println("Veuillez choisir le code de la pizza à supprimer (en majuscules)");
					userChoice = sc.nextLine();
					
					trouve = false;
					
					for (Integer i = 0; i < carteDesPizzas.length; i++) {
						String codeCourant = carteDesPizzas[i].getCode();
						
						if (userChoice.equals(codeCourant)) {
							trouve = true;
							
							carteDesPizzas[i] = null; // Erreur NullPointerException quand lister pizzas
							
						}
					}
					
					if (!trouve) {
						System.out.println("Ce code n'existe pas.");
						System.out.println("Veuillez choisir le code de la pizza à supprimer (en majuscules)");
					}
				break;
				
				case ("99") : 
					System.out.println(menuDeBienvenue[5]);
				break;
				
				default :
					PizzeriaAdminConsoleApp.afficherMenu(menuDeBienvenue);
			}
		}
		

	}
	
	public static void afficherMenu(String[] menuDeBienvenue) {
		for (String e: menuDeBienvenue) {
			System.out.println(e);
		}
	}
	
	public static void afficherCarte(Pizza[] carteDesPizzas) {
		for (Pizza pizza: carteDesPizzas) {
			if (pizza != null) {
				System.out.println(pizza.getCode() + " -> " + pizza.getNom() + " (" + pizza.getPrix() + ")");
			}
		}
	}
	
	public static void inviteSaisieValeurs() {
		// TO DO!
	}

}
