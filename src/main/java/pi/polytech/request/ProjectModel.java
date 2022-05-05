package pi.polytech.request;

import java.util.Date;



public class ProjectModel {
	private Long user;
	private Long state;
	private String label;
	private String description;
	private float budget;
	private Date dateBeginPlanned;
	private Date dateEndPlanned;
	private Date dateBeginReal;
	private Date dateEndReal;
	private int status = 1;
	public ProjectModel() {
		super();
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getUser() {
		return user;
	}
	public void setUser(Long user) {
		this.user = user;
	}
	public Long getState() {
		return state;
	}
	public void setState(Long state) {
		this.state = state;
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
	
	
}
