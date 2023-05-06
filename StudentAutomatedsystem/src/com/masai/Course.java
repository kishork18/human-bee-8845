package com.masai;

public class Course {
	  private String name;
	    private int duration;
	    private double fee;

	    public Course(String name, int duration, double fee) {
	        this.name = name;
	        this.duration = duration;
	        this.fee = fee;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public int getDuration() {
	        return duration;
	    }

	    public void setDuration(int duration) {
	        this.duration = duration;
	    }

	    public double getFee() {
	        return fee;
	    }

	    public void setFee(double fee) {
	        this.fee = fee;
	    }
}
