package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Ahsan Habib
 */
public class DateUtilTest {
	
	  // Day Boundary Equivalence Classes
    private static final int DB1 = 1;
    private static final int DB2 = 30;
    private static final int DB3 = 31;
    private static final int DB4 = 28;
    private static final int DB5 = 29;

    // Month Boundary Equivalence Classes
    private static final int MB1 = 1;
    private static final int MB2 = 12;

    // Year Boundary Equivalence Classes
    private static final int YB1 = 1700;
    private static final int YB2 = 2024;
	
	@Test
	public void testStudentIdentity() {
		String studentId = "222341387";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Simranjit Singh";
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
	}
	
	/*
	 * Complete below test cases.
	 */
	
	 @Test
	    public void testMinJanuary1ShouldIncrementToJanuary2() {
		 	System.out.println("January1ShouldIncrementToJanuary2 ");
	        DateUtil date = new DateUtil(DB1, MB1, YB2);
	        date.increment();
	        Assert.assertEquals(2, date.getDay());
	        Assert.assertEquals(1, date.getMonth());
	        Assert.assertEquals(YB2, date.getYear());
	    }

	    @Test
	    public void testMinJanuary1ShouldDecrementToDecember31() {
	    	System.out.println("January1ShouldDecrementToDecember31 ");
	        DateUtil date = new DateUtil(DB1, MB1, YB2);
	        date.decrement();
	        Assert.assertEquals(31, date.getDay());
	        Assert.assertEquals(12, date.getMonth());
	        Assert.assertEquals(YB1, date.getYear());
	    }

	    // Write tests for the rest of the months of year 2024
	    // February - Non-leap year
	    @Test
	    public void testFeb28NonLeapYearShouldIncrementToFeb29() {
	    	System.out.println("Feb28NonLeapYearShouldIncrementToFeb29 ");
	        DateUtil date = new DateUtil(DB4, 2, YB2);
	        date.increment();
	        Assert.assertEquals(DB5, date.getDay());
	        Assert.assertEquals(2, date.getMonth());
	        Assert.assertEquals(YB2, date.getYear());
	    }

	    @Test
	    public void testFeb29NonLeapYearShouldDecrementToFeb28() {
	    	System.out.println("Feb29NonLeapYearShouldDecrementToFeb28 ");
	        DateUtil date = new DateUtil(DB5, 2, YB2);
	        date.decrement();
	        Assert.assertEquals(DB4, date.getDay());
	        Assert.assertEquals(2, date.getMonth());
	        Assert.assertEquals(YB2, date.getYear());
	    }

	    // February - Leap year
	    @Test
	    public void testFeb28LeapYearShouldIncrementToMar1() {
	    	System.out.println("Feb28LeapYearShouldIncrementToMar1 ");
	        DateUtil date = new DateUtil(DB4, 2, YB2);
	        date.increment();
	        Assert.assertEquals(1, date.getDay());
	        Assert.assertEquals(3, date.getMonth());
	        Assert.assertEquals(YB2, date.getYear());
	    }

	    @Test
	    public void testFeb29LeapYearShouldDecrementToFeb28() {
	    	System.out.println("Feb29LeapYearShouldDecrementToFeb28");
	        DateUtil date = new DateUtil(DB5, 2, YB2);
	        date.decrement();
	        Assert.assertEquals(DB4, date.getDay());
	        Assert.assertEquals(2, date.getMonth());
	        Assert.assertEquals(YB2, date.getYear());
	    }

	    // Other months
	    @Test
	    public void testMaxDaysOfMonthShouldIncrementToNextMonth() {
	        // December 31st, 2024 should increment to January 1st, 2025
	    	System.out.println("DaysOfMonthShouldIncrementToNextMonth");
	        DateUtil date = new DateUtil(DB3, MB2, YB2);
	        date.increment();
	        Assert.assertEquals(1, date.getDay());
	        Assert.assertEquals(1, date.getMonth());
	        Assert.assertEquals(YB2 + 1, date.getYear());
	    }

	    @Test
	    public void testMinDaysOfMonthShouldDecrementToPreviousMonth() {
	        // January 1st, 2024 should decrement to December 31st, 2023
	    	System.out.println("DaysOfMonthShouldIncrementToNextMonth");
	        DateUtil date = new DateUtil(DB1, MB1, YB2);
	        date.decrement();
	        Assert.assertEquals(31, date.getDay());
	        Assert.assertEquals(12, date.getMonth());
	        Assert.assertEquals(YB1, date.getYear());
	    }
}
