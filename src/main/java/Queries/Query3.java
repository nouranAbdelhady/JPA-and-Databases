package Queries;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import Entities.Employee;
import Entities.Project;

public class Query3 {
	private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test_pu");

	public static void main(String[] args) {
		
		//getEmployeesInProject("IT Project");
		
		String outputMessage = getEmployeesInProject("IT Project");
    	System.out.println(outputMessage);
		entityManagerFactory.close();	
	}
	
	public static String getEmployeesInProject(String projectName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
    	
		//gets employees working on "projectName"
    	String strQueryFind = "SELECT e FROM Project p JOIN p.employees e WHERE p.projectName =: targetedProject ";
    	
    	List<Employee> employees;
    	
    	String outputMessage = null;
    	outputMessage ="Get all employees in project : " + projectName + " \nResult: \n";
    	try {
    		// Get matching employee object and output
    		employees = entityManager.createQuery(strQueryFind).setParameter("targetedProject", projectName).getResultList();
    		//employees.forEach(emp->System.out.println("Employee id: "+emp.getId() +"\tFirst Name: "+emp.getFirstName() + " \tLast Name: " + emp.getLastName()));
    		//projects.forEach(project->System.out.println("Project id: "+project.getId() +"\tProject Name: "+project.getProjectName()));
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