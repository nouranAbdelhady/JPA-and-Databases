package Entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_ID", unique = true , updatable = false)
	private int id;
	
	@Column(name = "first_name", nullable = false)
    private String firstName;
 
    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @Column(name = "age", nullable = false)
    private int age;
    
    @Column(name = "national_ID", unique = true , nullable=false)
    private String nationalID;
    
    @Column(name = "phone_number", unique = true , nullable=false)
    private String phoneNumber;
    
    @Column(name = "email", unique = true , nullable=false)
    private String email;
    
    @Column(name = "role", nullable=false)
    private String role;
    
    @ManyToMany
    Set<Project> projects = new HashSet<>();
    
    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getNationalID() {
		return nationalID;
	}

	public void setNationalID(String nationalID) {
		this.nationalID = nationalID;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
    
	public Employee(String firstName, String lastName, int age, String nationalID, String phoneNumber, String email, String role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.nationalID = nationalID;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.role = role;
	}

	public Employee(Employee newEmp) {
		this.firstName = newEmp.firstName;
		this.lastName = newEmp.lastName;
		this.age = newEmp.age;
		this.nationalID = newEmp.nationalID;
		this.phoneNumber = newEmp.phoneNumber;
		this.email = newEmp.email;
		this.role = newEmp.role;
	}
	
	public Employee(){
		
	}
}