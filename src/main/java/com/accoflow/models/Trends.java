package com.accoflow.models;

import java.util.List;

import com.accoflow.dto.Course;
import com.accoflow.dto.Location;
import com.accoflow.dto.Year;

public class Trends {

	private List<Course> Courses;
	private List<Location> Locations;
	private List<Year> Years;
	public List<Course> getCourses() {
		return Courses;
	}
	public void setCourses(List<Course> courses) {
		Courses = courses;
	}
	public List<Location> getLocations() {
		return Locations;
	}
	public void setLocations(List<Location> locations) {
		Locations = locations;
	}
	public List<Year> getYears() {
		return Years;
	}
	public void setYears(List<Year> years) {
		Years = years;
	}
}
