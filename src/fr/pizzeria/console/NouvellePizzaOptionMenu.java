package fr.pizzeria.console;

import fr.pizzeria.model.Pizza;

public class NouvellePizzaOptionMenu extends OptionMenu {
	
	public NouvellePizzaOptionMenu(PizzaDao dao) {
		super(dao);
	}

	public String getLibelle() {
		return "2. Ajouter une nouvelle pizza";
	}
	
	public boolean execute() {
		Pizza[] carteDesPizzas = dao.getCarteDesPizzas();
		
		System.out.println("Veuillez saisir le code");
		String code = sc.nextLine();

		System.out.println("Veuillez saisir le nom (sans espace)");
		String nomPizza = sc.nextLine();

		System.out.println("Veuillez saisir le prix");
		Integer prix = Integer.parseInt(sc.nextLine());

		int nouvelIndex = dao.findNewId();

		Pizza nouvellePizza = new Pizza(nouvelIndex, code, nomPizza, prix);
		carteDesPizzas[nouvelIndex] = nouvellePizza;

		return false;
	}
	
}
