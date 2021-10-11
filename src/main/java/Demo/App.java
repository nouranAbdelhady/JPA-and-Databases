package Demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Entities.Employee;

public class App {
	private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test_pu");

	public static void main(String[] args) {
		
		addEmployee(1, "Nouran", "Abdelhady");
		addEmployee(2, "Salma", "Azzam");
		addEmployee(3, "Mohamed", "Kadry");
		getEmployees();
				
		entityManagerFactory.close();
				
		System.out.println("Hello World!");
	}
	
	public static void addEmployee(int id, String firstname, String lastname) {
        // The EntityManager class allows operations such as create, read, update, delete
		EntityManager entityManager = entityManagerFactory.createEntityManager();
        // Used to issue transactions on the EntityManager
        EntityTransaction entitytransaction = null;
 
        try {
            // Get transaction and start
        	entitytransaction = entityManager.getTransaction();
        	entitytransaction.begin();
 
            // Create and set values for new customer
            Employee emp = new Employee();
            emp.setId(id);
            emp.setFirstName(firstname);
            emp.setLastName(lastname);
 
            // Save the customer object
            entityManager.persist(emp);
            entitytransaction.commit();
        } catch (Exception ex) {
            if (entitytransaction != null) {
            	entitytransaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            // Close EntityManager
        	entityManager.close();
        }
    }
	
	public static void getEmployees() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
    	
		//gets all employees
    	String strQuery = "SELECT e FROM Employee e WHERE e.id IS NOT NULL";
    	
    	// Issue the query and get a matching Customer
    	TypedQuery<Employee> tq = entityManager.createQuery(strQuery, Employee.class);
    	List<Employee> employees;
    	try {
    		// Get matching customer object and output
    		employees = tq.getResultList();
    		employees.forEach(emp->System.out.println("First Name: "+emp.getFirstName() + "\nLast Name: " + emp.getLastName()));
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		entityManager.close();
    	}
    }

}
