package com.alinanails.project.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id",unique = true)
    private Long appointmentId;

    @NotBlank
    @Column(name = "start_time",
            nullable = false)
    private LocalDateTime startTime;

    @NotBlank
    @Column(name = "stop_time",
            nullable = false)
    private LocalDateTime endTime;

    @NotBlank
    @Value("${is.payment.confirmed}")
    @Column(nullable = false)
    private Boolean isPaymentConfirmed;

    @ManyToOne
    @JoinColumn(name = "user_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "user_appointment_fk"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "master_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "master_appointment_fk"))
    private Master master;


    public Appointment(Long appointmentId, LocalDateTime startTime, LocalDateTime endTime, Boolean isPaymentConfirmed) {
        this.appointmentId = appointmentId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isPaymentConfirmed = isPaymentConfirmed;
    }

    public Appointment() {
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Boolean getPaymentConfirmed() {
        return isPaymentConfirmed;
    }

    public void setPaymentConfirmed(Boolean paymentConfirmed) {
        isPaymentConfirmed = paymentConfirmed;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}


