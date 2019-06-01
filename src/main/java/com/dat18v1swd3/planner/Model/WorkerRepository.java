package com.dat18v1swd3.planner.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Integer> {

    Worker getById(Integer id);

    ArrayList<Worker> findAll();
}
