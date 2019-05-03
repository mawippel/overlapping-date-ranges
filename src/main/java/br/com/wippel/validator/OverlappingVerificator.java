package br.com.wippel.validator;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;

/**
 * Operations on {@link LocalDate} and {@link LocalDateTime} to verify date/time
 * overlapping.
 * 
 * @author Marcelo Wippel
 */
public final class OverlappingVerificator {

	/**
	 * Private default constructor to avoid instantiation of this class
	 */
	private OverlappingVerificator() {
	}

	public static boolean isOverlapping(LocalDate comparableInit, LocalDate comparableEnd, LocalDate toCompareInit,
			LocalDate toCompareEnd) {
		if(areInvalidDates(comparableInit, comparableEnd, toCompareInit, toCompareEnd)) {
			return false;
		}
		// Verifies if some end date is before the initial date
		if(comparableEnd.compareTo(comparableInit) == -1 || toCompareEnd.compareTo(toCompareInit) == -1) {
			throw new DateTimeException("End date is before the initial date");
		}
		
		if(!(comparableEnd.isBefore(toCompareInit) || comparableInit.isAfter(toCompareEnd))) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isOverlapping(LocalDateTime comparableInit, LocalDateTime comparableEnd,
			LocalDateTime toCompareInit, LocalDateTime toCompareEnd) {
		if(areInvalidDates(comparableInit, comparableEnd, toCompareInit, toCompareEnd)) {
			return false;
		}
		// Verifies if some end date is before the initial date
		if(comparableEnd.compareTo(comparableInit) == -1 || toCompareEnd.compareTo(toCompareInit) == -1) {
			throw new DateTimeException("End date is before the initial date");
		}
		
		if(!(comparableEnd.isBefore(toCompareInit) || comparableInit.isAfter(toCompareEnd))) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Validate if the {@link Temporal}s are valid
	 * 
	 * @param date1 a {@link Temporal} representing one date
	 * @param date2 a {@link Temporal} representing one date
	 * @param date3 a {@link Temporal} representing one date
	 * @param date4 a {@link Temporal} representing one date
	 * 
	 * @return <code>true</code> if the dates are valid, otherwise, return <code>false</code>
	 */
	private static boolean areInvalidDates(Temporal date1, Temporal date2, Temporal date3, Temporal date4) {
		if(date1 == null || date2 == null || date3 == null || date4 == null) {
			return true;
		}
		return false;
	}

}
