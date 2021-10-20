package Queries;

import javax.persistence.*;
import Entities.Employee;
import Entities.Project;

public class Query2 {
	private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test_pu");

	public static void main(String[] args) {
		
		/*
		 * System.out.println("Query 2");
		 * 
		 * Employee foundEmployee = findEmployee(2); if (foundEmployee != null) {
		 * System.out.println("Employee found!");
		 * System.out.println("Employee id: "+foundEmployee.getId()
		 * +"\tFirst Name: "+foundEmployee.getFirstName() + " \tLast Name: " +
		 * foundEmployee.getLastName()); } else
		 * {System.out.println("Employee NOT found");}
		 * 
		 * Project foundProject = findProject(93); if (foundProject != null) {
		 * System.out.println("Project found!");
		 * System.out.println("Project name: "+foundProject.getProjectName()); } else
		 * {System.out.println("Project NOT found");}
		 */
	    
	    addEmployeeToProject(1,9);
	    addEmployeeToProject(1,7);
	    addEmployeeToProject(4,9);
	    addEmployeeToProject(5,9);
	    addEmployeeToProject(2,7);
		entityManagerFactory.close();	
	}
	
	public static Employee findEmployee(int empID) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
    	
		//gets targeted employee
    	String strQueryFind = "SELECT e FROM Employee e WHERE e.id =: targetedID";
    	
    	// Issue the query and get a matching Employee
    	TypedQuery<Employee> query = entityManager.createQuery(strQueryFind, Employee.class);
    			
    	try {
    		// Get matching employee object and output
    		Employee targetedEmployee = query.setParameter("targetedID", empID).getSingleResult();
    		return targetedEmployee;
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		entityManager.close();
    	}
		return null;
    }
	
	public static Project findProject(int prjID) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
    	
		//gets targeted project
    	String strQueryFind = "SELECT p FROM Project p WHERE p.id =: targetedID";
    	
    	// Issue the query and get a matching Project
    	TypedQuery<Project> query = entityManager.createQuery(strQueryFind, Project.class);
    			
    	try {
    		// Get matching project object and output
    		Project targetedProject = query.setParameter("targetedID", prjID).getSingleResult();
    		return targetedProject;
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		entityManager.close();
    	}
		return null;
    }
	
	public static void addEmployeeToProject(int empID, int prjID) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        String findEmployeeQuery = "SELECT e FROM Employee e WHERE e.id =: targetedID";
        Employee foundEmployee = (Employee) entityManager.createQuery(findEmployeeQuery).setParameter("targetedID", empID).getSingleResult();
        
        String findProjectQuery = "SELECT p FROM Project p WHERE p.id =: targetedID";
        Project foundProject = (Project) entityManager.createQuery(findProjectQuery).setParameter("targetedID", prjID).getSingleResult();
        
        if(foundEmployee != null){
        	if (foundProject != null) {
        		entityManager.getTransaction().begin();

            	foundProject.getEmployees().add(foundEmployee);
            	foundEmployee.getProjects().add(foundProject);
                System.out.println("Added Employee to Project!");

                entityManager.persist(foundProject);
                entityManager.getTransaction().commit();
        	} 
        	else {
                System.out.println("Project NOT found!");
            }
        } 
        else {
            System.out.println("Employee NOT found!");
        }
    }
	
}