package se.mah.k3lara.skaneAPI.model;

import java.util.Calendar;

public class Line {
	private String line;
	private Calendar depTime;
	public String depTimeDeviation;
	private String towards;
	private String stopPoint;
	
	public Line() {
	}
	public String getLine() {
		return line;
	}
	
	public String getTowards() {
		return towards;
	}
	public void setTowards(String towards) {
		this.towards = towards;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public Calendar getDepTime() {
		return depTime;
	}
	public void setDepTime(Calendar depTime) {
		this.depTime = depTime;
	}
	public String getDepTimeDeviation() {
		return depTimeDeviation;
	}
	public void setDepTimeDeviation(String depTimeDeviation) {
		this.depTimeDeviation = depTimeDeviation;
	}
	

}
