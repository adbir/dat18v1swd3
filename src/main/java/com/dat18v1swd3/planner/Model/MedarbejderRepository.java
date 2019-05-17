package com.dat18v1swd3.planner.Model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedarbejderRepository extends CrudRepository<Medarbejder, Integer> {

    Medarbejder getById(Integer id);
}
