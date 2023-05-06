package com.masai;

public class Batch {
	private String batchName;
	private String startDate;
	private String endDate;
	private int availableSeats;
	private Course course;

	public Batch(String name, String startDate, String endDate, int availableSeats, Course course) {
		this.batchName = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.availableSeats = availableSeats;
		this.course = course;
	}

	// getters and setters
	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public void decreaseAvailableSeats(int count) {
		availableSeats -= count;
	}

	public void increaseAvailableSeats(int count) {
		availableSeats += count;
	}

	public Object getName() {
		// TODO Auto-generated method stub
		return null;
	}

	
}