package cs544.group1.project.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Appointment {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date appointmentDate;
	
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

	@JsonIgnoreProperties(value = "appointment")
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    
    @OneToMany
    private List<Reservation> reservations;
    
    
    @AttributeOverrides({
        @AttributeOverride(name="createdDate",
                           column=@Column(name="LOC_CREATEDDATE")),
        @AttributeOverride(name="updatedDate",
                           column=@Column(name="LOC_UPDATEDDATE"))
    })
    @Embedded
    private Location location;
    
    
    
    public Appointment() {
    	this.createdDate = new Date();
		this.updatedDate = new Date();
    }



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Date getAppointmentDate() {
		return appointmentDate;
	}



	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
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



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public List<Reservation> getReservations() {
		return reservations;
	}



	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	};

}
