package cs544.group1.project.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import cs544.group1.project.types.UserRoles;

@Entity
public class UserRole {
	
	@Id
	@GeneratedValue
	private int id;
	@JsonIgnoreProperties(value = "userrole")
	@ManyToMany(mappedBy = "role", cascade = CascadeType.ALL)
	private List<User> user;
	
	@Enumerated(EnumType.STRING)
	private UserRoles role;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
    
    
    public UserRole() {
    	this.createdDate = new Date();
		this.updatedDate = new Date();
    }


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public List<User> getUser() {
		return user;
	}


	public void setUser(List<User> user) {
		this.user = user;
	}


	public UserRoles getRole() {
		return role;
	}


	public void setRole(UserRoles role) {
		this.role = role;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public Date getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	

}
