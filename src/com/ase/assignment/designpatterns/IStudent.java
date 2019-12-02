package com.ase.assignment.designpatterns;

import java.util.ArrayList;

public interface IStudent {

	public String getStudentName();
	public ArrayList<Double> getAssignmentMarks();
	public ArrayList<Double> getExamMarks();
	public void addAssignmentScore(double assignmentScore);
	public void addExamScore(double examScore);
	
	//observer pattern methods
    public void registerObserver(IObserver observer);

    public void removeObserver(IObserver observer);

    public void notifyObservers();
}
