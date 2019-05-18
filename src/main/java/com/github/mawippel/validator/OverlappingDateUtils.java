package com.github.mawippel.validator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;

/**
 * Util class for validation/comparing {@link LocalDate} and {@link LocalDateTime}
 * 
 * @author Marcelo Wippel (<a href='https://github.com/mawippel'>https://github.com/mawippel</a>)
 */
public class OverlappingDateUtils {

	/**
	 * Validate if the {@link Temporal}s are valid
	 * 
	 * @param date1 a {@link Temporal} representing one date
	 * @param date2 a {@link Temporal} representing one date
	 * @param date3 a {@link Temporal} representing one date
	 * @param date4 a {@link Temporal} representing one date
	 * 
	 * @return <code>true</code> if the dates are valid, otherwise, return
	 *         <code>false</code>
	 */
	protected static boolean areInvalidDates(Temporal date1, Temporal date2, Temporal date3, Temporal date4) {
		if (date1 == null || date2 == null || date3 == null || date4 == null) {
			return true;
		}
		return false;
	}

	protected static boolean isEndBeforeInit(LocalDateTime comparableInit, LocalDateTime comparableEnd,
			LocalDateTime toCompareInit, LocalDateTime toCompareEnd) {
		if (comparableEnd.compareTo(comparableInit) == -1 || toCompareEnd.compareTo(toCompareInit) == -1) {
			return true;
		}
		return false;
	}

	protected static boolean isEndBeforeInit(LocalDate comparableInit, LocalDate comparableEnd, LocalDate toCompareInit,
			LocalDate toCompareEnd) {
		if (comparableEnd.compareTo(comparableInit) == -1 || toCompareEnd.compareTo(toCompareInit) == -1) {
			return true;
		}
		return false;
	}
	
}
