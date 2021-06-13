package com.dfm.softparking.business;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

public enum ClockFormatter {
	MilitaryClock("kk:mm:ss MMM d, y"),
	StandardClock("hh:mm:ss a MMM d, y");
	
	@Getter
	@Setter
	@NonNull
	private SimpleDateFormat simpleDateFormat;
	
	ClockFormatter(@NonNull SimpleDateFormat simpleDateFormat) {
		this.simpleDateFormat = simpleDateFormat;
	}
	
	ClockFormatter(@NonNull String pattern) {
		this(new SimpleDateFormat(pattern));		
	}
	
	public void setPattern(String pattern) {
		setSimpleDateFormat(new SimpleDateFormat(pattern));
	}
	
	public String format(Date date) {
		return simpleDateFormat.format(date);
	}
}
