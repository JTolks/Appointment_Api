package com.alinanails.project.controller;

import com.alinanails.project.model.Appointment;
import com.alinanails.project.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
    @RequestMapping("/api/v1/appointments")
    public class AppointmentController {
        @Autowired
        private AppointmentService appointmentService;

        @GetMapping
        public List<Appointment> getAllAppointments() {
            return appointmentService.getAllAppointments();
        }

        @GetMapping("/{id}")
        public Appointment getAppointmentById(@PathVariable Long id) {
            return appointmentService.getAppointmentById(id);
        }

        @PostMapping
        public Appointment createAppointment(@RequestBody Appointment appointment) {
            return appointmentService.createAppointment(appointment);
        }

        @PutMapping("/{id}")
        public Optional<Appointment> updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
            return appointmentService.modifyAppointment(id, appointment);
        }

        @DeleteMapping("/{id}")
        public void modifyAppointment(@PathVariable Long id) {
            appointmentService.deleteAppointment(id);
        }
    }

