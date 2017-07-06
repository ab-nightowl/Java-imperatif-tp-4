package fr.pizzeria.console;

import fr.pizzeria.model.Pizza;

public class PizzaDao {

	private Pizza[] carteDesPizzas;

	public PizzaDao() {
		carteDesPizzas = new Pizza[100];
		carteDesPizzas[0] = new Pizza(0, "PEP", "Pépéroni", 12.50);
		carteDesPizzas[1] = new Pizza(1, "MAR", "Margherita", 14.00);
		carteDesPizzas[2] = new Pizza(2, "REI", "La Reine", 11.50);
		carteDesPizzas[3] = new Pizza(3, "FRO", "La 4 fromages", 12.00);
		carteDesPizzas[4] = new Pizza(4, "CAN", "La Cannibale", 12.50);
		carteDesPizzas[5] = new Pizza(5, "SAV", "La Savoyarde", 13.00);
		carteDesPizzas[6] = new Pizza(6, "ORI", "L'Orientale", 13.50);
		carteDesPizzas[7] = new Pizza(7, "IND", "L'Indienne", 14.00);

	}

	public Pizza[] getCarteDesPizzas() {
		return carteDesPizzas;
	}

	public void setCarteDesPizzas(Pizza[] carteDesPizzas) {
		this.carteDesPizzas = carteDesPizzas;
	}
	
	public int findNewId(){
		
		for(int i=0; i< carteDesPizzas.length; i++){
			if (carteDesPizzas[i]==null){
				return i;
			}
		}
	
		return 0;
	}
}
