package fr.pizzeria.console;

import java.util.Scanner;

public abstract class OptionMenu {

	PizzaDao dao;
	Scanner sc;
	String userChoice;
	boolean trouve;
	
	public OptionMenu(PizzaDao dao) {
		this.dao = dao;
		this.sc = new Scanner(System.in);
		this.userChoice = "";
		this.trouve = false;
	}
	
	public abstract String getLibelle();
	
	public abstract boolean execute();
	
}
