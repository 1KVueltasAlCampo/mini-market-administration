package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class minimarket {
	private int triedToEnter;
	private ArrayList<Person> peopleInTheMarket;
	private int numberOfPeopleInTheMarket;
	private int actualDay;
	
	public minimarket() {
		triedToEnter = 0;
		peopleInTheMarket = new ArrayList<Person>();
		numberOfPeopleInTheMarket = peopleInTheMarket.size();
		actualDay = LocalDate.now().getDayOfMonth();
	}
	
	public int getTriedToEnter() {
		return triedToEnter;
	}
	
	public int getNumberOfPeopleInTheMarket() {
		return numberOfPeopleInTheMarket;
	}
	
	public int getActualDay() {
		return actualDay;
	}
}
