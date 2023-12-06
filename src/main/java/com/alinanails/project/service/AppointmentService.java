package com.alinanails.project.service;

import com.alinanails.project.model.Appointment;
import com.alinanails.project.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private  AppointmentRepository appointmentRepository;

    public String sayHelloToNewAppointment(){
        return "Hello to new Appointment";
    }

    public Appointment createAppointment(Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(Long id){
        return appointmentRepository.findById(id).orElseThrow(()->new IllegalStateException("Not such appointment FOUND"));
    }

    public void deleteAppointment(Long id){
        appointmentRepository.deleteById(id);
    }

    public Optional<Appointment> modifyAppointment(Long id, Appointment appointment){
        return appointmentRepository.findById(id).filter(app -> app.getAppointmentId().equals(appointment.getAppointmentId()))
                .map(appointment1 -> {
                    appointment1.setStartTime(appointment.getStartTime());
                    appointment1.setEndTime(appointment.getEndTime());
                    return appointmentRepository.save(appointment1);
                });
    }

}
