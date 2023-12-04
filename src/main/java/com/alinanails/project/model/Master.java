package com.alinanails.project.model;

import jakarta.persistence.*;

import java.util.List;

@Entity

public class Master {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true)
    private Long id;

    @Column(nullable = false)
    private String masterName;

    @Column(nullable = false)
    private String speciality;

    @OneToMany(mappedBy = "master",orphanRemoval = true,
    cascade = CascadeType.ALL)
    private List<Appointment> appointmentList;


    public Master(Long masterId, String masterName, String speciality) {
        this.id = masterId;
        this.masterName = masterName;
        this.speciality = speciality;
    }

    public Master() {
    }

    public Long getMasterId() {
        return id;
    }

    public void setMasterId(Long masterId) {
        this.id = masterId;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Master{" +
                "masterId=" + id +
                ", masterName='" + masterName + '\'' +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}
