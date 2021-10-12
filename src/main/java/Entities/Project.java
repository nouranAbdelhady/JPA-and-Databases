package Entities;


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
	
	@Column(name = "start_date")
    private String startDate;
	
	@Column(name = "manager_id", nullable = false)		//should link to empID in Employee table
    private int mngrID;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public int getMngrID() {
		return mngrID;
	}

	public Project(String projectName, String startDate, int mngrID) {
		super();
		this.projectName = projectName;
		this.startDate = startDate;
		this.mngrID = mngrID;
	}
	
	public Project(Project project) {
		this.id = project.id;
		this.projectName = project.projectName;
		this.startDate = project.startDate;
		this.mngrID = project.mngrID;
	}

	public void setMngrID(int mngrID) {
		this.mngrID = mngrID;
	}

	

}
