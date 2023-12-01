package com.alinanails.project.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    @Column (nullable = false)
    private String serviceName;

    @Column(nullable = false)
    private String serviceDescription;

    @Column(nullable = false)
    private int durationInMinutes;

    @Column(nullable = false)
    private BigDecimal servicePrice;

   @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private List<Appointment> appointmentList;

    public Service(Long serviceId, String serviceName, String serviceDescription, int durationInMinutes, BigDecimal servicePrice) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.durationInMinutes = durationInMinutes;
        this.servicePrice = servicePrice;
    }

    public Service() {
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public BigDecimal getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(BigDecimal servicePrice) {
        this.servicePrice = servicePrice;
    }

    @Override
    public String toString() {
        return "SalonService{" +
                "serviceId=" + serviceId +
                ", serviceName='" + serviceName + '\'' +
                ", serviceDescription='" + serviceDescription + '\'' +
                ", durationInMinutes=" + durationInMinutes +
                ", servicePrice=" + servicePrice +
                '}';
    }
}
