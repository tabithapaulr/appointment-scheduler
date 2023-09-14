package com.medapp.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medapp.scheduler.model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

}
