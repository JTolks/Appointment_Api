package com.alinanails.project.repository;

import com.alinanails.project.model.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment,Long> {
}
