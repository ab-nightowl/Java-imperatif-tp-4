package fr.pizzeria.console;

import fr.pizzeria.model.Pizza;

public class MettreAJourPizzaOptionMenu extends OptionMenu {

	public MettreAJourPizzaOptionMenu(PizzaDao dao) {
		super(dao);
	}

	public String getLibelle() {
		return "3. Mettre à jour une pizza";
	}

	public boolean execute() {
		Pizza[] carteDesPizzas = dao.getCarteDesPizzas();

		System.out.println("Veuillez choisir le code de la pizza à modifier (en majuscules)");
		userChoice = sc.nextLine();

		for (Integer i = 0; i < carteDesPizzas.length; i++) {
			if (carteDesPizzas[i] != null) {
				String codeCourant = carteDesPizzas[i].getCode();

				if (userChoice.equals(codeCourant)) {
					trouve = true;

					System.out.println("Veuillez saisir le code");
					String nouveauCode = sc.nextLine();

					System.out.println("Veuillez saisir le nom (sans espace)");
					String nouveauNom = sc.nextLine();

					System.out.println("Veuillez saisir le prix");
					Integer nouveauPrix = Integer.parseInt(sc.nextLine());

					Pizza nouvellePizza = new Pizza(i, nouveauCode, nouveauNom, nouveauPrix);
					carteDesPizzas[i] = nouvellePizza;
				}
			}
		}

		do {
			System.out.println("Ce code n'existe pas.");
			System.out.println("Veuillez choisir le code de la pizza à supprimer (en majuscules)");
			ListerPizzasOptionMenu.afficherCarte(carteDesPizzas);
			userChoice = sc.nextLine();
		} while(!trouve);
		
		return false;
	}
}
