package com.ase.assignment.designpatterns;

public class GradeTracker {
	
	public Character getClassGrade(double obtainedClassAverage)
	{
		if(obtainedClassAverage >= 90)
			return 'A';
		else if(obtainedClassAverage >= 80)
			return 'B';
		else if(obtainedClassAverage >= 70)
			return 'C';
		else
			return 'D';
	}
}
