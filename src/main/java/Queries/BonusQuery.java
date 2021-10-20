package Queries;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Entities.Employee;
import Entities.Project;

public class BonusQuery {
	private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test_pu");

	public static void main(String[] args) {
		
		//getEmployeesWithoutProject("Software Engineer");
		
		String outputMessage = getEmployeesWithoutProject("Software Engineer");
    	System.out.println(outputMessage);
    	
		entityManagerFactory.close();	
	}
	
	public static String getEmployeesWithoutProject(String role) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
    	
		String strQueryFind = "SELECT e FROM Employee e WHERE e.role =: targetedRole AND e.projects IS EMPTY";
		TypedQuery<Employee> tq = entityManager.createQuery(strQueryFind, Employee.class);
    	List<Employee> employees;
    	
    	String outputMessage = null;
    	outputMessage ="Get all employees with role : " + role + " [that are NOT working in a project]\nResult: \n";
    	
    	try {
    		// Get matching employee object and output
    		employees = tq.setParameter("targetedRole", role).getResultList();
    		//employees.forEach(emp->System.out.println("Employee id: "+emp.getId() +"\tFirst Name: "+emp.getFirstName() + " \tLast Name: " + emp.getLastName()));
    		if(employees.isEmpty()) {
    			outputMessage="No result";
    		}
    		for (Employee emp : employees) {
    			outputMessage+="Employee id: "+emp.getId() + "\t\tFirst Name: "+emp.getFirstName() + " \tLast Name: " + emp.getLastName()+"\n";
    		}
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		entityManager.close();
    	}
    	return outputMessage;
    }

}
