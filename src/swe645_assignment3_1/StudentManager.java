package swe645_assignment3_1;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;



/**
 * 
 * @param userId
 *	Rishab Banskota
 *G01047184
 */

@Path("studentinfo")
public class StudentManager {

	@GET
	@Path("{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudent(@PathParam("userId")String userId) {		
		EntityManagerFactory emfactory=Persistence.createEntityManagerFactory("JPA-assignment4-persistence");
		EntityManager entitymanager= emfactory.createEntityManager();
		Student s=entitymanager.find(Student.class,userId);
		if(s==null)
		{
			throw new NullPointerException();
		}
		System.out.println("Found " +s.getFIRSTNAME() + " in the database!");
		entitymanager.close();
		emfactory.close();
		return s;
	}
	
	
	//adds a student to the DB when passed all the student fields as URL encoded parameters	1`
	@POST
	@Path("addStudent")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public void addStudent(Student student)
							throws SQLException{

		System.out.println("Starting 'add' transaction!");
		EntityManagerFactory emfactory=Persistence.createEntityManagerFactory("JPA-assignment4-persistence");
		EntityManager entitymanager= emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Student s=entitymanager.find(Student.class,student.getUSERID());
		if(s!=null)
		{
			throw new SQLException("Student already exists");
		}
		entitymanager.persist(student);
		System.out.println("Added student" + student.toString());
		entitymanager.getTransaction().commit();
		System.out.println("Committed changes..closing connection now!");
		entitymanager.close();
		emfactory.close();
		
		}
	
	
	//returns the list of student ID's from the database
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getAllUserIds()
	{
		EntityManagerFactory emfactory=Persistence.createEntityManagerFactory("JPA-assignment4-persistence");
		EntityManager entitymanager= emfactory.createEntityManager();
		
		
		List<Object> result=null;
		try {
			entitymanager.getTransaction().begin();
			result=entitymanager.createNamedQuery("get_all_studentIds").getResultList();
			
		}catch(Exception e)
		{
			System.out.println("Something went wrong with executing get all students query!!");
			System.out.println(e);
			entitymanager.getTransaction().commit();
			System.out.println("Committed changes..closing connection now!");
			entitymanager.close();
			emfactory.close();
		}
		
		List<String> strings = new ArrayList<>(result.size());
		for (Object object : result) {
		    strings.add(Objects.toString(object, null));
		}
		return strings;
	}
	
	
	
}
