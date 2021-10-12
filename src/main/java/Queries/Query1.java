package Queries;

import java.util.List;
import javax.persistence.*;
import Entities.Employee;

public class Query1 {
	private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test_pu");

	public static void main(String[] args) {
		
		getEmployees();		
		entityManagerFactory.close();	
	}
	
	public static void getEmployees() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
    	
		//gets all employees
    	String strQuery = "SELECT e FROM Employee e WHERE e.id IS NOT NULL";
    	
    	// Issue the query and get a matching Employee
    	TypedQuery<Employee> tq = entityManager.createQuery(strQuery, Employee.class);
    	List<Employee> employees;
    	try {
    		// Get matching employee object and output
    		employees = tq.getResultList();
    		employees.forEach(emp->System.out.println("Employee id: "+emp.getId() +"\tFirst Name: "+emp.getFirstName() + " \tLast Name: " + emp.getLastName()));
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		entityManager.close();
    	}
    }

}
