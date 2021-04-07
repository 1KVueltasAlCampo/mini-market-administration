package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.IncompatibleDayAndIDNumberException;
import exceptions.InvalidIDTypeException;

class MinimarketTest {
	
	private int dayOfTheMonth;

	
	public void setupScenary1() {
		dayOfTheMonth = 27;
	}
	public void setupScenary2() {
		dayOfTheMonth = 31;
	}
	
	@Test
	public void testCorrectRegistration1() {
		setupScenary1();
		int check = 0;
		
		int typeIndicator = 1; //CC
		String idNumber = "19974432023";
		Minimarket mm = new Minimarket();
		mm.setActualDay(dayOfTheMonth);
		try {
			mm.enterAPerson(typeIndicator,idNumber);
		} catch (IncompatibleDayAndIDNumberException | InvalidIDTypeException typeE) {
			fail();
		}
		
		check = mm.getNumberOfPeopleInTheMarket();
		
		assertTrue(check==1);
	}

}
