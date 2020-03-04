package com.springboot.security.repository;
import com.springboot.security.model.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CarRepository extends CrudRepository<Car, Long> {

    public ArrayList<Car> findByCategory(String d);

}
