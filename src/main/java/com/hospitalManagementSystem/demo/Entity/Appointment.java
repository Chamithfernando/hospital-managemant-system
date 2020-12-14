package com.hospitalManagementSystem.demo.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int appointmenterId;
    private String appointmenterName;
    private Date appointmentDate;

    public Appointment(int appointmenterId, String appointmenterName, Date appointmentDate) {
        this.appointmenterId = appointmenterId;
        this.appointmenterName = appointmenterName;
        this.appointmentDate = appointmentDate;
    }

    public Appointment() {
    }

    public int getAppointmenterId() {
        return appointmenterId;
    }

    public void setAppointmenterId(int appointmenterId) {
        this.appointmenterId = appointmenterId;
    }

    public String getAppointmenterName() {
        return appointmenterName;
    }

    public void setAppointmenterName(String appointmenterName) {
        this.appointmenterName = appointmenterName;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}
