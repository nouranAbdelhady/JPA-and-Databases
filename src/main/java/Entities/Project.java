package Entities;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "project")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "proj_ID", unique = true , updatable = false)
	private int id;
	
	@Column(name = "project_name", nullable = false)
    private String projectName;
	
	@Column(name = "start_date", nullable = false)
    private Date startDate;
	
	@Column(name = "manager_id", nullable = false)		//should link to empID in Employee table
    private int mngrID;

}
