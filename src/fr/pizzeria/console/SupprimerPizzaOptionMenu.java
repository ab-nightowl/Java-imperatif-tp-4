package fr.pizzeria.console;

import fr.pizzeria.model.Pizza;

public class SupprimerPizzaOptionMenu extends OptionMenu {

	public SupprimerPizzaOptionMenu(PizzaDao dao) {
		super(dao);
	}

	public String getLibelle() {
		return "4. Supprimer une pizza";
	}

	public boolean execute() {
		Pizza[] carteDesPizzas = dao.getCarteDesPizzas();

		System.out.println("Veuillez choisir le code de la pizza à supprimer (en majuscules)");
		userChoice = sc.nextLine();

		for (Integer i = 0; i < carteDesPizzas.length; i++) {
			if (carteDesPizzas[i] != null) {
				String codeCourant = carteDesPizzas[i].getCode();

				if (userChoice.equals(codeCourant)) {
					trouve = true;
	
					carteDesPizzas[i] = null;
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
