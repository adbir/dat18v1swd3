package com.dat18v1swd3.planner.Model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MedarbejderRepository extends CrudRepository<Medarbejder, Integer> {

    Medarbejder getById(Integer id);

}
