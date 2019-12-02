package com.ase.assignment.designpatterns;

import java.util.ArrayList;

public class Roster implements IRoster, AvgDispenser {

	public String courseName;
	public ArrayList<Student> enrolledStudent;
	public int iteratorIndex =0;
	
	public Roster(String courseName, String courseNumber) {
		this.courseName = courseName;
		this.enrolledStudent = new ArrayList<Student>();
	}
	@Override
	public String getCourseName() {
		return this.courseName;
	}

	@Override
	public void addStudent(Student newStudent) {
		this.enrolledStudent.add(newStudent);
	}
	@Override
	public boolean hasNext() {
		if(iteratorIndex < this.enrolledStudent.size())
			return true;
		else
			return false;
	}

	public void getEnrolledStudentsAverage()
	{
		while(this.hasNext())
		{
			System.out.println(enrolledStudent.get(iteratorIndex).studentName+" - "+enrolledStudent.get(iteratorIndex).calculateAverage());
			iteratorIndex++;
		}
	}
}
