package Entities;

import javax.persistence.*;


@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "empID", unique = true , updatable = false)
	private int id;
	
	@Column(name = "firstName", nullable = false)
    private String firstName;
 
    @Column(name = "lastName", nullable = false)
    private String lastName;
    
    @Column(name = "nationalID", unique = true )//, nullable=false)
    private String nationalID;

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
	
	public Employee(){
		
	}
    
    
    
}