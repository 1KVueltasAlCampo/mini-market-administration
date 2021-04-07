package model;

import java.time.LocalDate;
import java.util.ArrayList;

import exceptions.IncompatibleDayAndIDNumberException;
import exceptions.InvalidIDTypeException;

public class Minimarket {
	private int triedToEnter;
	private ArrayList<Person> peopleInTheMarket;
	private int numberOfPeopleInTheMarket;
	private int actualDay;
	
	public Minimarket() {
		triedToEnter = 0;
		peopleInTheMarket = new ArrayList<Person>();
		numberOfPeopleInTheMarket = peopleInTheMarket.size();
		actualDay = LocalDate.now().getDayOfMonth();
	}
	
	public void enterAPerson(int typeIndicator,String idNumber) throws InvalidIDTypeException, IncompatibleDayAndIDNumberException{
		triedToEnter++;
		switch(typeIndicator) {
			case 1:
			
			case 2:
			
			case 3:
				if(evaluateDayAnIdCompatibility(idNumber)) {
					peopleInTheMarket.add(new Person(typeIndicator,idNumber));
					numberOfPeopleInTheMarket++;
				}
				else {
					throw new IncompatibleDayAndIDNumberException();
				}
				break;
			default: throw new InvalidIDTypeException();
		}
	}
	
	public boolean evaluateDayAnIdCompatibility(String idNumber) {
		boolean oddDay = actualDay % 2 != 0;
		int penultimateNumberOfId = Character.getNumericValue(idNumber.charAt(idNumber.length()-2));
		boolean penultimateNumberOfIdIsEven = penultimateNumberOfId % 2 == 0;
		return oddDay==penultimateNumberOfIdIsEven;
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
	
	public void setActualDay(int actualDay) { 		//Created for tests
		this.actualDay=actualDay;
	}
}
