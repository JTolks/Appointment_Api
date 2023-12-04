package com.alinanails.project.service;

import com.alinanails.project.model.Appointment;
import com.alinanails.project.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment createNewAppointment(Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    public String sayHelloToNewAppointment(){
        return "Hello new to new Appointment";
    }
}
