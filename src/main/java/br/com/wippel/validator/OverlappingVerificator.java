package br.com.wippel.validator;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Operations on {@link LocalDate} and {@link LocalDateTime} to verify date/time
 * overlapping.
 * 
 * @author Marcelo Wippel (https://github.com/mawippel)
 */
public final class OverlappingVerificator {

	/**
	 * Private default constructor to avoid instantiation of this class
	 */
	private OverlappingVerificator() {
	}

	/**
	 * Compares the two periods of {@link LocalDate} and search for overlaps
	 * 
	 * If there's an overlap, returns <code>true</code>, otherwise, returns
	 * <code>false</code>
	 * 
	 * @param comparableInit - The Initial comparator date
	 * @param comparableEnd  - The End comparator date
	 * @param toCompareInit  - The Initial date to compare to
	 * @param toCompareEnd   - The End date to compare to
	 * @return a <code>boolean</code>
	 */
	public static boolean isOverlapping(LocalDate comparableInit, LocalDate comparableEnd, LocalDate toCompareInit,
			LocalDate toCompareEnd) {
		if (OverlappingDateUtils.areInvalidDates(comparableInit, comparableEnd, toCompareInit, toCompareEnd)) {
			return false;
		}

		if (OverlappingDateUtils.isEndBeforeInit(comparableInit, comparableEnd, toCompareInit, toCompareEnd)) {
			throw new DateTimeException("End date is before the initial date");
		}

		return hasOverlap(comparableInit, comparableEnd, toCompareInit, toCompareEnd);
	}

	/**
	 * Compares the two periods of {@link LocalDateTime} and search for overlaps
	 * 
	 * If there's an overlap, returns <code>true</code>, otherwise, returns
	 * <code>false</code>
	 * 
	 * @param comparableInit - The Initial comparator date
	 * @param comparableEnd  - The End comparator date
	 * @param toCompareInit  - The Initial date to compare to
	 * @param toCompareEnd   - The End date to compare to
	 * @return a <code>boolean</code>
	 */
	public static boolean isOverlapping(LocalDateTime comparableInit, LocalDateTime comparableEnd,
			LocalDateTime toCompareInit, LocalDateTime toCompareEnd) {
		if (OverlappingDateUtils.areInvalidDates(comparableInit, comparableEnd, toCompareInit, toCompareEnd)) {
			return false;
		}

		if (OverlappingDateUtils.isEndBeforeInit(comparableInit, comparableEnd, toCompareInit, toCompareEnd)) {
			throw new DateTimeException("End date is before the initial date");
		}

		return hasOverlap(comparableInit, comparableEnd, toCompareInit, toCompareEnd);
	}

	/**
	 * Verifies if the dates are overlapping. Private method that receives 4
	 * {@link LocalDateTime} and perform the verification.
	 * 
	 * @see OverlappingVerificator#isOverlapping(LocalDate, LocalDate, LocalDate,
	 *      LocalDate)
	 * @see OverlappingVerificator#isOverlapping(LocalDateTime, LocalDateTime,
	 *      LocalDateTime, LocalDateTime)
	 * 
	 * @param comparableInit a {@link LocalDateTime}
	 * @param comparableEnd  a {@link LocalDateTime}
	 * @param toCompareInit  a {@link LocalDateTime}
	 * @param toCompareEnd   a {@link LocalDateTime}
	 * @return a <code>boolean</code>
	 */
	private static boolean hasOverlap(LocalDateTime comparableInit, LocalDateTime comparableEnd,
			LocalDateTime toCompareInit, LocalDateTime toCompareEnd) {
		if (!(comparableEnd.isBefore(toCompareInit) || comparableInit.isAfter(toCompareEnd))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method that transforms the {@link LocalDate} to a {@link LocalDateTime} to
	 * verify the overlapping
	 * 
	 * @param comparableInit a {@link LocalDateTime}
	 * @param comparableEnd  a {@link LocalDateTime}
	 * @param toCompareInit  a {@link LocalDateTime}
	 * @param toCompareEnd   a {@link LocalDateTime}
	 * @return a <code>boolean</code>
	 */
	private static boolean hasOverlap(LocalDate comparableInit, LocalDate comparableEnd, LocalDate toCompareInit,
			LocalDate toCompareEnd) {
		if (!(comparableEnd.isBefore(toCompareInit) || comparableInit.isAfter(toCompareEnd))) {
			return true;
		} else {
			return false;
		}
	}

}
