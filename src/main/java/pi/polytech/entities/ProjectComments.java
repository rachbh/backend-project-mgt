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
@Table(name = "ProjectComments")
public class ProjectComments {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "users_id")
	private Users user;
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;
	@Column(name = "content")
	private String content;
	@Column(name = "createdAt")
	private Date createdAt;
	@Column(name = "updatedAt")
	private Date updatedAt;
	@Column(name = "status")
	private int status = 1;

	public ProjectComments() {
		super();
	}

	public ProjectComments(Long id, Users user, Project project, String content, Date createdAt, Date updatedAt,
			int status) {
		super();
		this.id = id;
		this.user = user;
		this.project = project;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ProjectComments [id=" + id + ", user=" + user + ", project=" + project + ", content=" + content
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", status=" + status + "]";
	}

}
