package com.luv2code.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			// createStudent(studentDAO);

			// createMultipleStudents(studentDAO);

			// readStudent(studentDAO);

			// queryForStudents(studentDAO);

			// queryForStudentsByLastName(studentDAO);

			// updateStudent(studentDAO);

			// deleteStudent(studentDAO);

			deleteAllStudents(studentDAO);

		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students ...");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO){
		int studentId = 3002;
		System.out.println("Deleting student id:"+ studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id:"+ studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change the first name to "Scooby"
		System.out.println("Updating student ...");
		myStudent.setFirstName("John");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student: "+ myStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO){

		// get a list of students with last name "Dhamgunde"
		List<Student> theStudents = studentDAO.findByLastName("Dhamgunde");

		// display list of students
		for(Student tempStudent:theStudents){
			System.out.println(tempStudent);
		}

	}

	private void queryForStudents(StudentDAO studentDAO){

		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for(Student tempStudent:theStudents){
			System.out.println(tempStudent);
		}

	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

		// save the student object
		System.out.println("Saving the student....");
		studentDAO.save(tempStudent);

		// display id pf the save student
		System.out.println("Saved student. Generate id: " + tempStudent.getId());

	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code");

		// save the student
		System.out.println("saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("saved student. Generated id:" + theId);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: " + myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating 3 student objects");
		Student tempStudent1 = new Student("Mayur", "Dhamgunde", "mayurdhamgunde@gmail.com");
		Student tempStudent2 = new Student("Samarth", "Dhamgunde", "samarthdhamgunde1402@gmail.com");
		Student tempStudent3 = new Student("Vivek", "Kalpavruksha", "vivekkalp@gmail.com");

		// save the student objets
		System.out.println("saving the students ........");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}
}
