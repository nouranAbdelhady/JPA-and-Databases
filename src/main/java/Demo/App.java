package Demo;


import javax.persistence.*;
import Entities.Employee;
import Entities.Project;

public class App {
	private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test_pu");

	public static void main(String[] args) {
		
		addEmployee(new Employee("Nouran", "Abdelhady",20,"natID1","012","nouranabdelhady@gmail.com","Software Engineer"));
		addEmployee(new Employee("Salma", "Azzam",25,"natID2","015","salmaazzam@gmail.com","Project Manager"));
		addEmployee(new Employee("Zeyad", "Hesham",26,"natID3","013","zeyadhesham@gmail.com","HR"));
		addEmployee(new Employee("Ahmed", "Youssef",22,"natID4","014","ahmedyoussef@gmail.com","Software Engineer"));
		addEmployee(new Employee("Mariam", "Hossam",19,"natID5","017","mariamhossam@gmail.com","Developer"));
		addEmployee(new Employee("Farah", "Ahmed",25,"natID7","01495","farahA@gmail.com","Software Engineer"));
		System.out.println("Employees added");
		
		
		addProject(new Project("IT Project","5 October",1));	
		addProject(new Project("Networking Project","7 June",2));	
		addProject(new Project("Java Project","23 January",1));	
		addProject(new Project("IT Project","1 April",4));		
		System.out.println("Projects added");
		
		entityManagerFactory.close();
		
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
	
	public static void addProject(Project newProj) {
        // The EntityManager class allows operations such as create, read, update, delete
		EntityManager entityManager = entityManagerFactory.createEntityManager();
        // Used to issue transactions on the EntityManager
        EntityTransaction entitytransaction = null;
 
        try {
            // Get transaction and start
        	entitytransaction = entityManager.getTransaction();
        	entitytransaction.begin();
 
            // Create and set values for new Project
            Project prj = new Project(newProj);

            // Save the project object
            entityManager.persist(prj);
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
