package br.com.wippel.validator;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Operations on {@link LocalDate} and {@link LocalDateTime} to
 * verify date/time overlapping.
 * 
 * @author Marcelo Wippel
 */
public class OverlappingVerificator {
	
	public static boolean isOverlap(LocalDate comparableInit, LocalDate comparableEnd, LocalDate toCompareInit, LocalDate toCompareEnd) {
		return false;
	}
	
	public static boolean isOverlap(LocalDateTime comparableInit, LocalDateTime comparableEnd, LocalDateTime toCompareInit, LocalDateTime toCompareEnd) {
		return false;
	}
	
}
