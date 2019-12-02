package com.ase.assignment.designpatterns;

import java.util.ArrayList;
import java.util.Collections;

public class AverageCalculator implements IAverage{
	
	public double calculatedAverage = 0;
	public String studentName;
	ArrayList<Double> obtainedAssignmentMarks;
	ArrayList<Double> obtainedExamMarks;
	
	public AverageCalculator(Student student) {
		this.studentName = student.studentName;
		this.obtainedAssignmentMarks = student.AssignmentMarks;
		this.obtainedExamMarks = student.ExamMarks;
	}

	@Override
	public double calculateAverage_AlgorithmA() {
		double assignmentSumTotal = 0;
		for(int i = 0; i < this.obtainedAssignmentMarks.size(); i++)
		{
			assignmentSumTotal += this.obtainedAssignmentMarks.get(i);
		}
		
		assignmentSumTotal = assignmentSumTotal / this.obtainedAssignmentMarks.size();
		
		double examSumTotal = 0;
		for(int i = 0; i < this.obtainedExamMarks.size(); i++)
		{
			examSumTotal += this.obtainedExamMarks.get(i);
		}
		
		examSumTotal = examSumTotal / this.obtainedExamMarks.size();
		
		calculatedAverage = (0.40*assignmentSumTotal) + (0.60*examSumTotal);
		
		return calculatedAverage;
	}

	@Override
	public double calculateAverage_AlgorithmB() {
		
		if(this.obtainedAssignmentMarks.size() > 2)
		{
			Collections.sort(this.obtainedAssignmentMarks);
			this.obtainedAssignmentMarks.remove(0);
			
			calculateAverage_AlgorithmA();
		}
		return calculatedAverage;
	}
}
