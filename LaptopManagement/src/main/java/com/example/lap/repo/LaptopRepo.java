package com.example.lap.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.lap.entity.Laptop;

public interface LaptopRepo extends CrudRepository<Laptop, String>{

}
