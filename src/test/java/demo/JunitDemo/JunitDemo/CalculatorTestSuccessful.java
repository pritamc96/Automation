package demo.JunitDemo.JunitDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CalculatorTestSuccessful {
    private static ICalculator calculator;
 
    @BeforeAll
    public static void initCalculator() {
        calculator = new Calculator();
    }
 
    @BeforeEach
    public void beforeEachTest() {
        System.out.println("This is executed before each Tests");
    }
 
    @AfterEach
    public void afterEachTest() {
        System.out.println("This is exceuted after each Tests");
    }
 
    @Test
    public void testSum() {
        int result = calculator.sum(3, 4);
 
        assertEquals(7, result);
    }
 
    @Test
    public void testDivison() {
        try {
            int result = calculator.divison(10, 2);
 
            assertEquals(5, result);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
 
    @Test
    public void testDivisionException() throws Exception {
    	Assertions.assertThrows(java.lang.Exception.class, () -> {
    		calculator.divison(10, 0);
    	  });

    }
 
    @Disabled
    @Test
    public void testEqual() {
        boolean result = calculator.equalIntegers(20, 20);
 
        assertFalse(result);
    }
 
    @Disabled
    @Test
    public void testSubstraction() {
        int result = 10 - 3;
 
        assertTrue(result == 9);
    }
}
