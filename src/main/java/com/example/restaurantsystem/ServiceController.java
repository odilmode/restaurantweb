package com.example.restaurantsystem;



import com.example.restaurantsystem.Service;
import com.example.restaurantsystem.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping
    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Service> getServiceById(@PathVariable String id) {
        return serviceRepository.findById(id);
    }

    @PostMapping
    public Service createService(@RequestBody Service service) {
        return serviceRepository.save(service);
    }

    @PutMapping("/{id}")
    public Service updateService(@PathVariable String id, @RequestBody Service service) {
        service.setId(id);
        return serviceRepository.save(service);
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable String id) {
        serviceRepository.deleteById(id);
    }
}
