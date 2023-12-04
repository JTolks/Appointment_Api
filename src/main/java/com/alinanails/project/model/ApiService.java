package com.alinanails.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class ApiService {

    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    @NotBlank
    @Column (nullable = false,unique = true)
    private String serviceName;

    @NotBlank
    @Column(nullable = false)
    private String serviceDescription;

    @NotBlank
    @Column(nullable = false)
    private int durationInMinutes;

    @NotBlank
    @Column(nullable = false)
    private BigDecimal servicePrice;

   @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private List<Appointment> appointmentList;

    public ApiService(Long serviceId, String serviceName, String serviceDescription, int durationInMinutes, BigDecimal servicePrice) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.durationInMinutes = durationInMinutes;
        this.servicePrice = servicePrice;
    }

    public ApiService() {
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
