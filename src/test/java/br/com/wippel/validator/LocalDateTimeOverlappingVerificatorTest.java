package br.com.wippel.validator;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LocalDateTimeOverlappingVerificatorTest {
	
	private LocalDate date = LocalDate.of(2019, 05, 05);
	
	/**
	 * End date is before than the Initial date
	 */
	@Test
	public void test_LocalDateTimeOverlappingWithException_1() {
		LocalDateTime initAndEndEquals = LocalDateTime.of(date, LocalTime.of(10, 15));
		
		LocalDateTime comparableInit = initAndEndEquals;
		LocalDateTime comparableEnd = initAndEndEquals;
		LocalDateTime toCompareInit = LocalDateTime.of(date, LocalTime.of(10, 15));
		LocalDateTime toCompareEnd = LocalDateTime.of(date, LocalTime.of(9, 15));
		
		Assertions.assertThrows(DateTimeException.class,
				() -> OverlappingVerificator.isOverlapping(comparableInit, comparableEnd, toCompareInit, toCompareEnd));
	}
	
	/**
	 * End date is before than the Initial date
	 */
	@Test
	public void test_LocalDateTimeOverlappingWithException_2() {
		LocalDateTime initAndEndEquals = LocalDateTime.of(date, LocalTime.of(10, 15));
		
		LocalDateTime comparableInit = LocalDateTime.of(date, LocalTime.of(10, 15));
		LocalDateTime comparableEnd = LocalDateTime.of(date, LocalTime.of(9, 15));
		LocalDateTime toCompareInit = initAndEndEquals;
		LocalDateTime toCompareEnd = initAndEndEquals;
		
		Assertions.assertThrows(DateTimeException.class,
				() -> OverlappingVerificator.isOverlapping(comparableInit, comparableEnd, toCompareInit, toCompareEnd));
	}
	
	/**
	 * Some dates are null
	 */
	@Test
	public void test_LocalDateTimeOverlappingWithInvalidDates() {
		LocalDateTime comparableInit = null;
		LocalDateTime comparableEnd = LocalDateTime.of(date, LocalTime.of(10, 15));
		LocalDateTime toCompareInit = LocalDateTime.of(date, LocalTime.of(10, 15));
		LocalDateTime toCompareEnd = null;
		
		boolean overlapping = OverlappingVerificator.isOverlapping(comparableInit, comparableEnd, toCompareInit, toCompareEnd);
		Assertions.assertEquals(false, overlapping);
	}
	
	/**
	 * The comparable dates before the "to Compare" dates
	 */
	@Test
	public void test_LocalDateTimeOverlappingWithSuccess_1() {
		LocalDateTime comparableInit = LocalDateTime.of(date, LocalTime.of(9, 10));
		LocalDateTime comparableEnd = LocalDateTime.of(date, LocalTime.of(10, 15));
		LocalDateTime toCompareInit = LocalDateTime.of(date, LocalTime.of(10, 45));
		LocalDateTime toCompareEnd = LocalDateTime.of(date, LocalTime.of(11, 00));
		
		boolean overlapping = OverlappingVerificator.isOverlapping(comparableInit, comparableEnd, toCompareInit, toCompareEnd);
		Assertions.assertEquals(false, overlapping);
	}
	
	/**
	 * The comparable dates after the "to Compare" dates
	 */
	@Test
	public void test_LocalDateTimeOverlappingWithSuccess_2() {
		LocalDateTime comparableInit = LocalDateTime.of(date, LocalTime.of(20, 00));
		LocalDateTime comparableEnd = LocalDateTime.of(date, LocalTime.of(20, 15));
		LocalDateTime toCompareInit = LocalDateTime.of(date, LocalTime.of(10, 45));
		LocalDateTime toCompareEnd = LocalDateTime.of(date, LocalTime.of(11, 00));
		
		boolean overlapping = OverlappingVerificator.isOverlapping(comparableInit, comparableEnd, toCompareInit, toCompareEnd);
		Assertions.assertEquals(false, overlapping);
	}
	
	/**
	 * The comparable dates overlapping with the "to Compare" dates (case 1)
	 */
	@Test
	public void test_LocalDateTimeOverlappingWithSuccess_3() {
		LocalDateTime comparableInit = LocalDateTime.of(date, LocalTime.of(9, 10));
		LocalDateTime comparableEnd = LocalDateTime.of(date, LocalTime.of(10, 15));
		LocalDateTime toCompareInit = LocalDateTime.of(date, LocalTime.of(10, 00));
		LocalDateTime toCompareEnd = LocalDateTime.of(date, LocalTime.of(11, 00));
		
		boolean overlapping = OverlappingVerificator.isOverlapping(comparableInit, comparableEnd, toCompareInit, toCompareEnd);
		Assertions.assertEquals(true, overlapping);
	}
	
	/**
	 * The comparable dates overlapping with the "to Compare" dates (case 2)
	 */
	@Test
	public void test_LocalDateTimeOverlappingWithSuccess_4() {
		LocalDateTime comparableInit = LocalDateTime.of(date, LocalTime.of(10, 48));
		LocalDateTime comparableEnd = LocalDateTime.of(date, LocalTime.of(15, 00));
		LocalDateTime toCompareInit = LocalDateTime.of(date, LocalTime.of(10, 45));
		LocalDateTime toCompareEnd = LocalDateTime.of(date, LocalTime.of(11, 00));
		
		boolean overlapping = OverlappingVerificator.isOverlapping(comparableInit, comparableEnd, toCompareInit, toCompareEnd);
		Assertions.assertEquals(true, overlapping);
	}
	
}
