package br.com.wippel.validator;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LocalDateTimeOverlappingVerificatorTest {
	
	private LocalDate date = LocalDate.of(2019, 05, 05);
	
	/**
	 * End date is before than the Initial date
	 */
	@Test
	public void test_LocalDateTimeOverlappingWithException_1() {
		LocalDateTime initAndEndEquals = LocalDateTime.of(2019, 05, 02, 10, 15); // 2019-05-05 10:15
		
		LocalDateTime comparableInit = initAndEndEquals;
		LocalDateTime comparableEnd = initAndEndEquals;
		LocalDateTime toCompareInit = LocalDateTime.of(2019, 05, 05, 10, 15); // 2019-05-05 10:15
		LocalDateTime toCompareEnd = LocalDateTime.of(2019, 05, 05, 9, 15); // 2019-05-05 09:15
		
		Assertions.assertThrows(DateTimeException.class,
				() -> OverlappingVerificator.isOverlapping(comparableInit, comparableEnd, toCompareInit, toCompareEnd));
	}
	
	/**
	 * End date is before than the Initial date
	 */
	@Test
	public void test_LocalDateTimeOverlappingWithException_2() {
		LocalDateTime initAndEndEquals = LocalDateTime.of(2019, 05, 02, 10, 15);
		
		LocalDateTime comparableInit = LocalDateTime.of(2019, 05, 05, 10, 15); // 2019-05-05 10:15
		LocalDateTime comparableEnd = LocalDateTime.of(2019, 05, 05, 9, 15); // 2019-05-05 09:15
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
		LocalDateTime comparableEnd = LocalDateTime.of(2019, 05, 02, 10, 15);
		LocalDateTime toCompareInit = LocalDateTime.of(2019, 05, 05, 10, 15);
		LocalDateTime toCompareEnd = null;
		
		boolean overlapping = OverlappingVerificator.isOverlapping(comparableInit, comparableEnd, toCompareInit, toCompareEnd);
		Assertions.assertEquals(false, overlapping);
	}
	
	/**
	 * The comparable dates before the "to Compare" dates
	 */
	@Test
	public void test_LocalDateTimeOverlappingWithSuccess_1() {
		LocalDateTime comparableInit = LocalDateTime.of(2019, 05, 02, 9, 10);
		LocalDateTime comparableEnd = LocalDateTime.of(2019, 05, 02, 10, 15);
		LocalDateTime toCompareInit = LocalDateTime.of(2019, 05, 02, 10, 45);
		LocalDateTime toCompareEnd = LocalDateTime.of(2019, 05, 02, 11, 00);
		
		boolean overlapping = OverlappingVerificator.isOverlapping(comparableInit, comparableEnd, toCompareInit, toCompareEnd);
		Assertions.assertEquals(false, overlapping);
	}
	
	/**
	 * The comparable dates after the "to Compare" dates
	 */
	@Test
	public void test_LocalDateTimeOverlappingWithSuccess_2() {
		LocalDateTime comparableInit = LocalDateTime.of(2019, 05, 02, 20, 00);
		LocalDateTime comparableEnd = LocalDateTime.of(2019, 05, 02, 20, 15);
		LocalDateTime toCompareInit = LocalDateTime.of(2019, 05, 02, 10, 45);
		LocalDateTime toCompareEnd = LocalDateTime.of(2019, 05, 02, 11, 00);
		
		boolean overlapping = OverlappingVerificator.isOverlapping(comparableInit, comparableEnd, toCompareInit, toCompareEnd);
		Assertions.assertEquals(false, overlapping);
	}
	
	/**
	 * The comparable dates overlapping with the "to Compare" dates (case 1)
	 */
	@Test
	public void test_LocalDateTimeOverlappingWithSuccess_3() {
		LocalDateTime comparableInit = LocalDateTime.of(2019, 05, 02, 9, 10);
		LocalDateTime comparableEnd = LocalDateTime.of(2019, 05, 02, 10, 15);
		LocalDateTime toCompareInit = LocalDateTime.of(2019, 05, 02, 10, 00);
		LocalDateTime toCompareEnd = LocalDateTime.of(2019, 05, 02, 11, 00);
		
		boolean overlapping = OverlappingVerificator.isOverlapping(comparableInit, comparableEnd, toCompareInit, toCompareEnd);
		Assertions.assertEquals(true, overlapping);
	}
	
	/**
	 * The comparable dates overlapping with the "to Compare" dates (case 2)
	 */
	@Test
	public void test_LocalDateTimeOverlappingWithSuccess_4() {
		LocalDateTime comparableInit = LocalDateTime.of(2019, 05, 02, 10, 48);
		LocalDateTime comparableEnd = LocalDateTime.of(2019, 05, 02, 15, 00);
		LocalDateTime toCompareInit = LocalDateTime.of(2019, 05, 02, 10, 45);
		LocalDateTime toCompareEnd = LocalDateTime.of(2019, 05, 02, 11, 00);
		
		boolean overlapping = OverlappingVerificator.isOverlapping(comparableInit, comparableEnd, toCompareInit, toCompareEnd);
		Assertions.assertEquals(true, overlapping);
	}
	
}
