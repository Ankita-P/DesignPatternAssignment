package com.ase.assignment.designpatterns;

public class StudentClassAverage{

	public static void main(String args[])
	{
		
		double studentAverage = 0;
		char studentGrade = 0;
		
		Student student = new Student("Ankita");
		student.addAssignmentScore(94);
		student.addAssignmentScore(92);
		student.addAssignmentScore(90);
		
		student.addExamScore(88);
		student.addExamScore(98);
		
		System.out.println("Calculating class average");
		studentAverage = student.calculateAverage();
		System.out.println("Class Average of "+student.getStudentName() +" is: " + studentAverage);
		
		System.out.println();
		
		System.out.println("Calculating class average after removing least ");
		student.removeLeastAssignmentMarks = true;
		studentAverage = student.calculateAverage();
		student.removeLeastAssignmentMarks = false;
		System.out.println("Class Average of "+student.getStudentName() +" is: " + studentAverage);
		
		// Calculating grade obtained manually
		GradeTracker gradeTracker = new GradeTracker();
		studentGrade = gradeTracker.getClassGrade(studentAverage);
		System.out.println("Current class grade obtained is: "+studentGrade);
		
		System.out.println();
		
		// Registering gradeTracker as an observer for student class. 
		// Grade is calculated everytime marks are added for a student.
		GradeObserver gradeObserver = new GradeObserver();
		student.registerObserver(gradeObserver);
		
		student.addExamScore(50);
		
		
		//Create 2 new students
		Student student2 = new Student("Shrirang");
		student2.addAssignmentScore(96);
		student2.addAssignmentScore(94);
		student2.addAssignmentScore(92);
		
		student2.addExamScore(88);
		student2.addExamScore(90);
		
		Student student3 = new Student("Sonali");
		student3.addAssignmentScore(91);
		student3.addAssignmentScore(93);
		student3.addAssignmentScore(95);
		
		student3.addExamScore(80);
		student3.addExamScore(90);
		
		//Adding all students to roster
		Roster roster = new Roster("Advanced Software Engineering", "CS 5800");
		roster.addStudent(student);
		roster.addStudent(student2);
		roster.addStudent(student3);
		
		// Using AvgDispnser interface, average of enrolled students is calculated and displayed
		System.out.println();
		System.out.println("Calculating and displaying average of students enrolled in the roster");
		AvgDispenser averageDispenser = roster;
		averageDispenser.getEnrolledStudentsAverage();
	}
}
