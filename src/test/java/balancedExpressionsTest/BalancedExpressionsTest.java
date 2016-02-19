package balancedExpressionsTest;

import static org.junit.Assert.*;
import balancedExpressions.Manager;
import org.junit.*;

public class BalancedExpressionsTest {
	
	private Manager expressionsManager = new Manager();
	
	@Test
	public void isClosingDelimeter() {
		assertTrue(expressionsManager.isClosingDelimeter("}"));
		assertTrue(expressionsManager.isClosingDelimeter("]"));
		assertTrue(expressionsManager.isClosingDelimeter(")"));
	
	}
	
	@Test
	public void isOpeningDelimeterTest() {
		assertTrue(expressionsManager.isOpeningDelimeter("("));
		assertTrue(expressionsManager.isOpeningDelimeter("["));
		assertTrue(expressionsManager.isOpeningDelimeter("{"));
	
	}
	
	@Test
	public void toOpeningDelimeter() {
		assertEquals(expressionsManager.toOpeningDelimeter("}"),"{");
		assertEquals(expressionsManager.toOpeningDelimeter("Sarlompa"),"Not a delimeter");
		assertEquals(expressionsManager.toOpeningDelimeter("]"),"[");
		assertEquals(expressionsManager.toOpeningDelimeter(")"),"(");
	
	}
	
	@Test
	public void goodExamplesShouldBeTrueTest() {
		assertTrue(expressionsManager.isValidExpression("{aa(bb[]cc)(dd)}"));
		assertTrue(expressionsManager.isValidExpression("([xxx]{zzz})"));
		assertTrue(expressionsManager.isValidExpression("(()[]())"));
		assertTrue(expressionsManager.isValidExpression("{x[y(zz)y[]]}"));
	
	}
	
	@Test
	public void badExamplesShouldBeFalseTest() {
		
		assertFalse(expressionsManager.isValidExpression("abc(d[)]"));
		assertFalse(expressionsManager.isValidExpression("(({]))"));
		assertFalse(expressionsManager.isValidExpression("a(b+c{)]"));
	
	}
	
	@Test
	public void nullExpressionsShouldBeTrueTest() {	
		assertTrue(expressionsManager.isValidExpression(""));	
	}
	
	@Test
	public void onlyClosingDelimeterShouldBeFalse() {	
		assertFalse(expressionsManager.isValidExpression("}])"));	
	}
	
	@Test
	public void onlyOpeningDelimeterShouldBeFalse() {	
		assertFalse(expressionsManager.isValidExpression("{[("));	
	}

}
