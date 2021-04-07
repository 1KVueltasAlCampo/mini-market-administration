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
		dayOfTheMonth = 30;
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
	
	@Test
	public void testCorrectRegistration2() {
		setupScenary2();
		int check = 0;
		
		int typeIndicator = 2; //PP
		String idNumber = "19974432013";
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
	
	@Test
	public void testFailByAge() {
		setupScenary2();
		boolean error = false;
		int typeIndicator = 4; //TI
		String idNumber = "19974432013";
		Minimarket mm = new Minimarket();
		mm.setActualDay(dayOfTheMonth);
		try {
			mm.enterAPerson(typeIndicator,idNumber);
		} catch(IncompatibleDayAndIDNumberException e) {
			fail();
		}
		catch (InvalidIDTypeException typeE) {
			error = true;
		}
		assertTrue(error);
	}
	
	@Test
	public void testFailByInvalidIdType() {
		setupScenary1();
		boolean error = false;
		int typeIndicator = 9; //Invalid type
		String idNumber = "19974432023";
		Minimarket mm = new Minimarket();
		mm.setActualDay(dayOfTheMonth);
		try {
			mm.enterAPerson(typeIndicator,idNumber);
		} catch(IncompatibleDayAndIDNumberException e) {
			fail();
		}
		catch (InvalidIDTypeException typeE) {
			error = true;
		}
		assertTrue(error);
	}
	
	@Test
	public void testFailByIncompatibleDayAnIdNumber1() {
		setupScenary1();
		boolean error = false;
		int typeIndicator = 2; //PP
		String idNumber = "19974432013";
		Minimarket mm = new Minimarket();
		mm.setActualDay(dayOfTheMonth);
		try {
			mm.enterAPerson(typeIndicator,idNumber);
		} catch(InvalidIDTypeException e) {
			fail();
		}
		catch (IncompatibleDayAndIDNumberException typeE) {
			error = true;
		}
		assertTrue(error);
	}
	
	@Test
	public void testFailByIncompatibleDayAnIdNumber2() {
		setupScenary2();
		boolean error = false;
		int typeIndicator = 3; //CE
		String idNumber = "19974432023";
		Minimarket mm = new Minimarket();
		mm.setActualDay(dayOfTheMonth);
		try {
			mm.enterAPerson(typeIndicator,idNumber);
		} catch(InvalidIDTypeException e) {
			fail();
		}
		catch (IncompatibleDayAndIDNumberException typeE) {
			error = true;
		}
		assertTrue(error);
	}
	
	

}
