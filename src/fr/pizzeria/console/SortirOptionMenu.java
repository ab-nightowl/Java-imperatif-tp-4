package fr.pizzeria.console;

public class SortirOptionMenu extends OptionMenu {

	public SortirOptionMenu(PizzaDao dao) {
		super(dao);
	}

	@Override
	public String getLibelle() {
		return "99. Sortir";
	}

	@Override
	public boolean execute() {
		System.exit(0);
		return false;
	}

}
