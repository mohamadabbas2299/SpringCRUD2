package com.abbas.CRUDJPAHIB;

import com.abbas.CRUDJPAHIB.dao.StudentDAO;
import com.abbas.CRUDJPAHIB.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudjpahibApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudjpahibApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
		return runner -> {
			//createStudent(studentDAO);
			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentsByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDAO studentDAO) {
		System.out.println("Deleting all the elements");
		int numRowsDeleted = studentDAO.deleteall();
		System.out.println("Deleted row count : "+numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting the student with id : "+studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrive student based on id
		int studentId= 1;
		System.out.println("Getting student with id : "+studentId);
		Student myStudent = studentDAO.findById(studentId);

		//change the first name to something
		System.out.println("updating student ");
		myStudent.setFirst_name("Scooby");

		//update the student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("Updated student :"+myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findByLstName("Abbas");

		//display the students
		for(Student tempStudent : theStudents)
		{
			System.out.println(tempStudent);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {

		//get a list of student

		List<Student> theStudents = studentDAO.findAll();

		//display the list of students

		for(Student tempStudent : theStudents)
		{
			System.out.println(tempStudent);
		}

	}

	private void readStudent(StudentDAO studentDAO){

		//create a student object
		System.out.println("Creating the student");
		Student tempStudent = new Student("Mohamad","Abbas","Abbas@gmail");
		//save the student
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		//display the id of the student
		int theId = tempStudent.getId();
		System.out.println("Saved Student :"+ theId);
		//retrieve the student based on id
		System.out.println("Retrieving the student : "+theId);
		Student myStudent = studentDAO.findById(theId);
		//display the student
		System.out.println("Found the student : "+myStudent);
	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object

		System.out.println("Creating the student object");
		Student tempstudent = new Student("paul","DOS","pauldos@gmail");

		//save the object
		System.out.println("Saving the student obj");
		studentDAO.save(tempstudent);
		//display the id of the student object
		System.out.println("Saved Student Id: "+tempstudent.getId());



	}
}
