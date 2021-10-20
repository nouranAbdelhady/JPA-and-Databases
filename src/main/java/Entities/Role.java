//package Entities;
//
//import java.util.Set;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "Role")
//public class Role {
//	
//	@Id
//	@SequenceGenerator (
//			name = "role_sequence",
//			sequenceName = "role_sequence",
//			allocationSize = 1)
//	@GeneratedValue(
//			strategy = GenerationType.SEQUENCE,
//			generator = "role_sequence")
//	@Column(name = "role_ID", updatable = false)
//	private int id;
//	
//	@Column(name = "role_name", nullable = false)
//    private String roleName;
//	
//	@OneToMany(cascade = CascadeType.ALL)
//	Set<Employee> employees;
//	
//	public Role(String roleName) {
//		super();
//		this.roleName = roleName;
//	}
//	
//	public Role(Role role) {
//		super();
//		this.id = role.id;
//		this.roleName = role.roleName;
//		this.employees = role.employees;
//	}
//	
//	public Role() {
//		
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getRoleName() {
//		return roleName;
//	}
//
//	public void setRoleName(String roleName) {
//		this.roleName = roleName;
//	}
//	
//	public Set<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(Set<Employee> employees) {
//        this.employees = employees;
//    }
//}
