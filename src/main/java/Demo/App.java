package Demo;

import javax.persistence.*;
import Entities.Employee;

public class App {
	private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test_pu");

	public static void main(String[] args) {
		
		addEmployee(new Employee("Nouran", "Abdelhady",20,"natID1","012","nouranabdelhady@gmail.com","Software Engineer"));
		addEmployee(new Employee("Salma", "Azzam",25,"natID2","015","salmaazzam@gmail.com","Project Manager"));
		addEmployee(new Employee("Zeyad", "Hesham",26,"natID3","013","zeyadhesham@gmail.com","HR"));
		addEmployee(new Employee("Ahmed", "Youssef",22,"natID4","014","ahmedyoussef@gmail.com","Software Engineer"));
		addEmployee(new Employee("Mariam", "Hossam",19,"natID5","017","mariamhossam@gmail.com","Developer"));
		
		entityManagerFactory.close();
				
		System.out.println("Employees added");
	}
	
	public static void addEmployee(Employee newEmp) {
        // The EntityManager class allows operations such as create, read, update, delete
		EntityManager entityManager = entityManagerFactory.createEntityManager();
        // Used to issue transactions on the EntityManager
        EntityTransaction entitytransaction = null;
 
        try {
            // Get transaction and start
        	entitytransaction = entityManager.getTransaction();
        	entitytransaction.begin();
 
            // Create and set values for new employee
            Employee emp = new Employee(newEmp);

            // Save the employee object
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
	
}
