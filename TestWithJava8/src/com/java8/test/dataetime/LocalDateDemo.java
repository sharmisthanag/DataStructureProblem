package com.java8.test.dataetime;

import java.time.LocalDate;
import java.time.Period;

public class LocalDateDemo {

	public static void main(String[] args) {
		//LocalDate ld=LocalDate.of(2017, 02, 29);
		//System.out.println(ld.minusDays(1));
		//LocalDate lsd=LocalDate.of(2017, 99, 99);
		
		Period period5month = Period.of(0, 5, 0);
		Period period10month = Period.of(0, 10, 0);
		Period period10days = Period.of(0, 0, 10);
		System.out.println(period5month.plus(period10month));
		System.out.println(period10days.plusDays(35));
		System.out.println(period10days.plusMonths(5));
		System.out.println(period10days.plusYears(5));
		
		System.out.println(Period.of(10, 2, 60).toTotalMonths());



	}

}
