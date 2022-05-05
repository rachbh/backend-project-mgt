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
@Table(name = "project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "users_id")
	private Users user;
	@Column(name = "Label")
	private String label;
	@Column(name = "description")
	private String description;
	@ManyToOne
	@JoinColumn(name = "states_id")
	private  States state;
	@Column(name = "budget")
	private float budget;
	@Column(name = "dateBeginPlanned")
	private Date dateBeginPlanned;
	@Column(name = "dateEndPlanned")
	private Date dateEndPlanned;
	@Column(name = "dateBeginReal")
	private Date dateBeginReal;
	@Column(name = "dateEndReal")
	private Date dateEndReal;
	@Column(name = "createdAt")
	private Date createdAt;
	@Column(name = "updatedAt")
	private Date updatedAt;
	@Column(name = "status")
	private int status = 1;
	
	
	public Project() {
		super();
	}


	public Project(Long id, Users user, String label, String description, States state, float budget,
			Date dateBeginPlanned, Date dateEndPlanned, Date dateBeginReal, Date dateEndReal, Date createdAt,
			Date updatedAt, int status) {
		super();
		this.id = id;
		this.user = user;
		this.label = label;
		this.description = description;
		this.state = state;
		this.budget = budget;
		this.dateBeginPlanned = dateBeginPlanned;
		this.dateEndPlanned = dateEndPlanned;
		this.dateBeginReal = dateBeginReal;
		this.dateEndReal = dateEndReal;
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


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public States getState() {
		return state;
	}


	public void setState(States state) {
		this.state = state;
	}


	public float getBudget() {
		return budget;
	}


	public void setBudget(float budget) {
		this.budget = budget;
	}


	public Date getDateBeginPlanned() {
		return dateBeginPlanned;
	}


	public void setDateBeginPlanned(Date dateBeginPlanned) {
		this.dateBeginPlanned = dateBeginPlanned;
	}


	public Date getDateEndPlanned() {
		return dateEndPlanned;
	}


	public void setDateEndPlanned(Date dateEndPlanned) {
		this.dateEndPlanned = dateEndPlanned;
	}


	public Date getDateBeginReal() {
		return dateBeginReal;
	}


	public void setDateBeginReal(Date dateBeginReal) {
		this.dateBeginReal = dateBeginReal;
	}


	public Date getDateEndReal() {
		return dateEndReal;
	}


	public void setDateEndReal(Date dateEndReal) {
		this.dateEndReal = dateEndReal;
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
		return "Project [id=" + id + ", user=" + user + ", label=" + label + ", description=" + description + ", state="
				+ state + ", budget=" + budget + ", dateBeginPlanned=" + dateBeginPlanned + ", dateEndPlanned="
				+ dateEndPlanned + ", dateBeginReal=" + dateBeginReal + ", dateEndReal=" + dateEndReal + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + ", status=" + status + "]";
	}
	
	
}
