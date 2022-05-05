package pi.polytech.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ProjectProgress")
public class ProjectProgress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "users_id")
	private Users user;
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;
	@Column(name = "description")
	private String description;
	@Column(name = "progressPercentage")
	private float progressPercentage;
	@Column(name = "dateProgress")
	private Date dateProgress;
	@Column(name = "budget")
	private float budget;
	@Column(name = "createdAt")
	private Date createdAt;
	@Column(name = "status")
	private int status = 1;
	
	public ProjectProgress() {
		super();
	}

	public ProjectProgress(Long id, Users user, Project project, String description, float progressPercentage,
			Date dateProgress, float budget, Date createdAt, int status) {
		super();
		this.id = id;
		this.user = user;
		this.project = project;
		this.description = description;
		this.progressPercentage = progressPercentage;
		this.dateProgress = dateProgress;
		this.budget = budget;
		this.createdAt = createdAt;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getProgressPercentage() {
		return progressPercentage;
	}

	public void setProgressPercentage(float progressPercentage) {
		this.progressPercentage = progressPercentage;
	}

	public Date getDateProgress() {
		return dateProgress;
	}

	public void setDateProgress(Date dateProgress) {
		this.dateProgress = dateProgress;
	}

	public float getBudget() {
		return budget;
	}

	public void setBudget(float budget) {
		this.budget = budget;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ProjectProgress [id=" + id + ", user=" + user + ", project=" + project + ", description=" + description
				+ ", progressPercentage=" + progressPercentage + ", dateProgress=" + dateProgress + ", budget=" + budget
				+ ", createdAt=" + createdAt + ", status=" + status + "]";
	}
	
	
	

}
