package cs544.group1.project.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import cs544.group1.project.types.ReservationStatus;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Enumerated(EnumType.STRING)
	private ReservationStatus status;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date reservationDate;
	
	@ManyToOne
	private User consumer;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
    
    @ManyToOne
    private Appointment appointment;
    
    
    
    public Reservation() {
    	this.createdDate = new Date();
		this.updatedDate = new Date();
    }



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public ReservationStatus getStatus() {
		return status;
	}



	public void setStatus(ReservationStatus status) {
		this.status = status;
	}



	public Date getReservationDate() {
		return reservationDate;
	}



	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}



	public User getConsumer() {
		return consumer;
	}



	public void setConsumer(User consumer) {
		this.consumer = consumer;
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



	public Appointment getAppointment() {
		return appointment;
	}


	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	
	
	

}
