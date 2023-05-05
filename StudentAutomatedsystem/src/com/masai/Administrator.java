package com.masai;

import java.util.*;

public class Administrator {
	// List to store all courses
	private List<Course> courses;

	// List to store all batches
	private List<Batch> batches;

	// List to store all students
	private List<Student> students;

	public Administrator() {
		courses = new ArrayList<Course>();
		batches = new ArrayList<Batch>();
		students = new ArrayList<Student>();
	}

	public void addCourse(Course course) {
		// Check if course with same name already exists
		for (Course c : courses) {
			if (c.getName().equals(course.getName())) {
				throw new IllegalArgumentException("Course with same name already exists");
			}
		}
		courses.add(course);
	}

	public Course getCourseByName(String name) {
		for (Course course : courses) {
			if (course.getName().equals(name)) {
				return course;
			}
		}
		return null; // Course not found
	}

	// getter and setter
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<Batch> getBatches() {
		return batches;
	}

	public void setBatches(List<Batch> batches) {
		this.batches = batches;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
}