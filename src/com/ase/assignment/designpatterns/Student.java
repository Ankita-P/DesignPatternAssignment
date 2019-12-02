package com.ase.assignment.designpatterns;

import java.util.ArrayList;
import java.util.Collections;

public class Student implements IStudent {

	public String studentName;
	public ArrayList<Double> AssignmentMarks;
	public ArrayList<Double> ExamMarks;
	IAverage averageCalculator;
	public boolean removeLeastAssignmentMarks = false;
	public double studentAverage = 0;
	
	private ArrayList<IObserver> observers = new ArrayList<IObserver>();
	 
	public Student(String studentName) {
		this.studentName = studentName;
		this.AssignmentMarks = new ArrayList<Double>();
		this.ExamMarks = new ArrayList<Double>();
	}
	
	@Override
	public String getStudentName() {
		return this.studentName;
	}

	@Override
	public ArrayList<Double> getAssignmentMarks() {
		return this.AssignmentMarks;
	}

	@Override
	public ArrayList<Double> getExamMarks() {
		return this.ExamMarks;
	}

	@Override
	public void addAssignmentScore(double assignmentScore) {
		this.AssignmentMarks.add(assignmentScore);
		notifyObservers();
	}

	@Override
	public void addExamScore(double examScore) {
		this.ExamMarks.add(examScore);
		notifyObservers();

	}

	public double calculateAverage()
	{
		averageCalculator = new AverageCalculator(this);
		if(removeLeastAssignmentMarks)
			this.studentAverage = averageCalculator.calculateAverage_AlgorithmB();
		else
			this.studentAverage = averageCalculator.calculateAverage_AlgorithmA();
	
		return this.studentAverage;
	}

	//observer pattern methods
	@Override
	public void registerObserver(IObserver observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(IObserver observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (IObserver ob : observers) 
		{
            System.out.println("Notifying Observers on change in students marks");
            System.out.println();
            ob.updateClassGrade(this);
		}
	}
	
	
}
