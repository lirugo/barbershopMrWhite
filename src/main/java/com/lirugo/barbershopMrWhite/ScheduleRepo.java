package com.lirugo.barbershopMrWhite;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepo extends JpaRepository<Schedule, Integer> {
    List<Schedule> findAllByBarberIdOrderByDayDesc(Integer barberId);
}
