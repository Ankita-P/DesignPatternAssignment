package com.ase.assignment.designpatterns;

public class GradeObserver implements IObserver {
	GradeTracker gradeTracker;
	@Override
	public void updateClassGrade(Student student) {
		gradeTracker = new GradeTracker();
		System.out.println("Calculating class average after addition of new exam score");
		double calculatedAverage = student.calculateAverage();
		System.out.println("Class Average of "+student.getStudentName() +" is: " + calculatedAverage);
		char gradeObtained = gradeTracker.getClassGrade(calculatedAverage);
		System.out.println("Grade calculated using design pattern is: "+gradeObtained);
	}

}
