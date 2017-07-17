package fr.pizzeria.ihm;

import fr.pizzeria.dao.PizzaDaoMemoire;

public class SupprimerPizzaOptionMenu extends OptionMenu {

	public SupprimerPizzaOptionMenu(PizzaDaoMemoire dao) {
		super(dao);
	}

	@Override
	public String getLibelle() {
		return "4. Supprimer une pizza";
	}

	@Override
	public boolean execute() {

		do {
			System.out.println("Veuillez choisir le code de la pizza à supprimer (en majuscules)");
			userChoice = sc.nextLine();

			trouve = dao.findByCode(userChoice);

			if (!trouve) {
				System.out.println("Le code " + userChoice + " n'existe pas");
			}
		} while (!trouve);

		dao.deletePizza(userChoice);

		return false;
	}
}
