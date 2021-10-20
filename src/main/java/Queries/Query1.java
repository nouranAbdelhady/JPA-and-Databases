package Queries;

import java.util.List;
import javax.persistence.*;
import Entities.Employee;

public class Query1 {
	private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test_pu");

	public static void main(String[] args) {
		
		//List<Employee> allEmployees = getEmployees();
		//System.out.println("Result: ");
		//allEmployees.forEach(emp->System.out.println("Employee id: "+emp.getId() +"\t\tFirst Name: "+emp.getFirstName() + " \tLast Name: " + emp.getLastName()));
		
    	String outputMessage = getEmployees();
    	System.out.println(outputMessage);
    	
    	
		entityManagerFactory.close();	
	}
	
	public static String getEmployees() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
    	
		//gets all employees
    	String strQuery = "SELECT e FROM Employee e WHERE e.id IS NOT NULL";
    	
    	// Issue the query and get a matching Employee
    	TypedQuery<Employee> tq = entityManager.createQuery(strQuery, Employee.class);
    	List<Employee> employees = null;
    	
    	String outputMessage = null;
    	outputMessage ="Get all employees \nResult: \n";
    	
    	try {
    		// Get matching employee object and output
    		employees = tq.getResultList();
    		//employees.forEach(emp->System.out.println("Employee id: "+emp.getId() +"\t\tFirst Name: "+emp.getFirstName() + " \tLast Name: " + emp.getLastName()));
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
