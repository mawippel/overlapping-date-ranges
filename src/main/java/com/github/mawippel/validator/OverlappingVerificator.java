package com.github.mawippel.validator;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Operations on {@link LocalDate} and {@link LocalDateTime} to verify date/time
 * overlaps.
 * 
 * @author Marcelo Wippel (<a href=
 *         'https://github.com/mawippel'>https://github.com/mawippel</a>)
 */
public final class OverlappingVerificator {

	/**
	 * Private default constructor to avoid instantiation of this class
	 */
	private OverlappingVerificator() {
	}

	/**
	 * Compares two periods of {@link LocalDate}, searching for overlaps.
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
	public static boolean isOverlap(LocalDate comparableInit, LocalDate comparableEnd, LocalDate toCompareInit,
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
	 * Compares two periods of {@link LocalDateTime}, searching for overlaps.
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
	public static boolean isOverlap(LocalDateTime comparableInit, LocalDateTime comparableEnd,
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
	 * Verifies if the dates are overlapping.
	 * 
	 * @see OverlappingVerificator#isOverlap(LocalDate, LocalDate, LocalDate,
	 *      LocalDate)
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

	/**
	 * Verifies if the dates are overlapping.
	 * 
	 * @see OverlappingVerificator#isOverlap(LocalDateTime, LocalDateTime,
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

}
