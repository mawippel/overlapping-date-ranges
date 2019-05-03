package br.com.wippel.validator;

import java.time.DateTimeException;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LocalDateOverlappingVerificatorTest {
	
	/**
	 * End date is before than the Initial date
	 */
	@Test
	public void test_LocalDateOverlappingWithException_1() {
		LocalDate initAndEndEquals = LocalDate.of(2019, 05, 02);
		LocalDate comparableInit = initAndEndEquals;
		LocalDate comparableEnd = initAndEndEquals;
		LocalDate toCompareInit = LocalDate.of(2019, 05, 05);
		LocalDate toCompareEnd = LocalDate.of(2019, 05, 04);
		
		Assertions.assertThrows(DateTimeException.class,
				() -> OverlappingVerificator.isOverlapping(comparableInit, comparableEnd, toCompareInit, toCompareEnd));
	}
	
	/**
	 * End date is before than the Initial date
	 */
	@Test
	public void test_LocalDateOverlappingWithException_2() {
		LocalDate initAndEndEquals = LocalDate.of(2019, 05, 02);
		LocalDate comparableInit = LocalDate.of(2019, 05, 05);
		LocalDate comparableEnd = LocalDate.of(2019, 05, 04);
		LocalDate toCompareInit = initAndEndEquals;
		LocalDate toCompareEnd = initAndEndEquals;
		
		Assertions.assertThrows(DateTimeException.class,
				() -> OverlappingVerificator.isOverlapping(comparableInit, comparableEnd, toCompareInit, toCompareEnd));
	}
	
	/**
	 * Some dates are null
	 */
	@Test
	public void test_LocalDateOverlappingWithInvalidDates() {
		LocalDate comparableInit = null;
		LocalDate comparableEnd = LocalDate.of(2019, 05, 02);
		LocalDate toCompareInit = LocalDate.of(2019, 05, 05);
		LocalDate toCompareEnd = null;
		
		boolean overlapping = OverlappingVerificator.isOverlapping(comparableInit, comparableEnd, toCompareInit, toCompareEnd);
		Assertions.assertEquals(false, overlapping);
	}
	
	/**
	 * The comparable dates before the "to Compare" dates
	 */
	@Test
	public void test_LocalDateOverlappingWithSuccess_1() {
		LocalDate comparableInit = LocalDate.of(2019, 05, 01);
		LocalDate comparableEnd = LocalDate.of(2019, 05, 02);
		LocalDate toCompareInit = LocalDate.of(2019, 05, 05);
		LocalDate toCompareEnd = LocalDate.of(2019, 05, 06);
		
		boolean overlapping = OverlappingVerificator.isOverlapping(comparableInit, comparableEnd, toCompareInit, toCompareEnd);
		Assertions.assertEquals(false, overlapping);
	}
	
	/**
	 * The comparable dates after the "to Compare" dates
	 */
	@Test
	public void test_LocalDateOverlappingWithSuccess_2() {
		LocalDate comparableInit = LocalDate.of(2019, 05, 10);
		LocalDate comparableEnd = LocalDate.of(2019, 05, 12);
		LocalDate toCompareInit = LocalDate.of(2019, 05, 05);
		LocalDate toCompareEnd = LocalDate.of(2019, 05, 06);
		
		boolean overlapping = OverlappingVerificator.isOverlapping(comparableInit, comparableEnd, toCompareInit, toCompareEnd);
		Assertions.assertEquals(false, overlapping);
	}
	
	/**
	 * The comparable dates overlapping with the "to Compare" dates (case 1)
	 */
	@Test
	public void test_LocalDateOverlappingWithSuccess_3() {
		LocalDate comparableInit = LocalDate.of(2019, 05, 01);
		LocalDate comparableEnd = LocalDate.of(2019, 05, 05);
		LocalDate toCompareInit = LocalDate.of(2019, 05, 03);
		LocalDate toCompareEnd = LocalDate.of(2019, 05, 10);
		
		boolean overlapping = OverlappingVerificator.isOverlapping(comparableInit, comparableEnd, toCompareInit, toCompareEnd);
		Assertions.assertEquals(true, overlapping);
	}
	
	/**
	 * The comparable dates overlapping with the "to Compare" dates (case 2)
	 */
	@Test
	public void test_LocalDateOverlappingWithSuccess_4() {
		LocalDate comparableInit = LocalDate.of(2019, 05, 06);
		LocalDate comparableEnd = LocalDate.of(2019, 05, 12);
		LocalDate toCompareInit = LocalDate.of(2019, 05, 03);
		LocalDate toCompareEnd = LocalDate.of(2019, 05, 10);
		
		boolean overlapping = OverlappingVerificator.isOverlapping(comparableInit, comparableEnd, toCompareInit, toCompareEnd);
		Assertions.assertEquals(true, overlapping);
	}
	
}
