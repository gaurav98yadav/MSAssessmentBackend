package com.accoflow.constants;

public class Queries {

	public static final String DUPLICATE_CHECK ="SELECT assessment_id FROM assessment_details where   grad_id=? and course=? and test_name=? and assessment_type=?";
	public static final String INSERT_ASSSESSMENT = "insert into assessment_details(grad_id,trainer_id,final_marks,trainer_feedback,assessment_type,course,test_name) values(?,?,?,?,?,?,?)";
	public static final String GET_TOTAL_QUIZ  = "Select quiz_graded from student_marks where grad_id=?";
	public static final String GET_QUIZ_MARKS = "Select quiz_marks from student_marks where grad_id=?";
	public static final String UPDATE_QUIZ ="update student_marks set quiz_graded=? , quiz_marks= ? where grad_id= ?";
	public static final String GET_TOTAL_MCQ  = "Select mcq_graded from student_marks where grad_id=?";
	public static final String GET_MCQ_MARKS = "Select mcq_marks from student_marks where grad_id=?";
	public static final String UPDATE_MCQ ="update student_marks set mcq_graded=? , mcq_marks= ? where grad_id= ?";
	public static final String GET_TOTAL_ASSIGNMENT  = "Select assignment_graded from student_marks where grad_id=?";
	public static final String GET_ASSIGNMENT_MARKS = "Select assignment_marks from student_marks where grad_id=?";
	public static final String UPDATE_ASSIGNMENT ="update student_marks set assignment_graded=? , assignment_marks= ? where grad_id= ?";
	public static final String INSERT_PROJECT ="insert into project_marks(assessment_id,build_marks,testing_marks,process_marks) values(?,?,?,?)";
	public static final String GET_TOTAL_PROJECT  = "Select project_graded from student_marks where grad_id=?";
	public static final String GET_PROJECT_MARKS = "Select project_marks from student_marks where grad_id=?";
	public static final String UPDATE_PROJECT ="update student_marks set project_graded=? , project_marks= ? where grad_id= ?";
	public static final String FETCH_ASSIGNMENTS = " Select * from assessment_details,grad_details where assessment_details.grad_id=grad_details.grad_id and assessment_type=?";
	public static final String FETCH_PROJECTS = "Select *from project_marks where assessment_id=?";
	public static final String FETCH_OLD_MARKS = "select final_marks from assessment_details where assessment_id=?";
	public static final String UPDATE_ASSESSMENT = "update assessment_details set final_marks= ? ,trainer_feedback= ? where assessment_id=?";
	public static final String EDIT_QUIZ = "update student_marks set quiz_marks= ? where grad_id= ?";
	public static final String EDIT_MCQ = "update student_marks set mcq_marks= ? where grad_id= ?";
	public static final String EDIT_ASSIGNMENT = "update student_marks set assignment_marks= ? where grad_id= ?";
	public static final String EDIT_PROJECT = "update student_marks set project_marks= ? where grad_id= ?";
	public static final String EDIT_PROJECT_MARKS = "update project_marks set build_marks=?,process_marks=?,testing_marks=? where assessment_id=? ";
	public static final String DELETE_ASSESSMENT ="delete from assessment_details where assessment_id=?";
	public static final String DELETE_PROJECT = "delete from project_marks where assessment_id=?";
	public static final String FETCH_GRAD_DETAILS = "SELECT * FROM grad_details,student_marks where grad_details.grad_id=student_marks.grad_id";
	public static final String FETCH_TRAINER_DETAILS = "select * from trainer_details where trainer_details.trainer_email=?"; 
	public static final String INSERT_TRAINER = "insert into trainer_details(trainer_name,trainer_email,trainer_photo) values(?,?,?)";
	public static final String FETCH_TRAINER_ID = "select trainer_id from trainer_details where trainer_details.trainer_email=?"; 
	public static final String GET_FILES = "Select * from training_material";
	public static final String FETCH_SCORECARD = "Select course,assessment_type,final_marks,test_name from assessment_details where grad_id=?";
	public static final String FETCH_STUDENT = "SELECT * FROM grad_details,student_marks where grad_details.grad_id=student_marks.grad_id and grad_details.grad_id =?";
}

