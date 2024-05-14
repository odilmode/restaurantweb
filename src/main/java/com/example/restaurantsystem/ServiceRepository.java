package com.example.restaurantsystem;



import com.example.restaurantsystem.Service;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends MongoRepository<Service, String> {
}
