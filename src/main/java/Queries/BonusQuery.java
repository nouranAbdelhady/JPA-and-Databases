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
		
		getEmployeesWithoutProject("Software Engineer");
		entityManagerFactory.close();	
	}
	
	public static void getEmployeesWithoutProject(String role) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
    	
		String strQueryFind = "SELECT e FROM Employee e WHERE e.role =: targetedRole AND e.projects IS EMPTY";
		TypedQuery<Employee> tq = entityManager.createQuery(strQueryFind, Employee.class);
    	List<Employee> employees;
    	try {
    		// Get matching employee object and output
    		employees = tq.setParameter("targetedRole", role).getResultList();
    		employees.forEach(emp->System.out.println("Employee id: "+emp.getId() +"\tFirst Name: "+emp.getFirstName() + " \tLast Name: " + emp.getLastName()));
    		//System.out.println("found");
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		entityManager.close();
    	}
    }

}
