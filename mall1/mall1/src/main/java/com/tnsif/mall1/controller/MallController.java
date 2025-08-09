package com.tnsif.mall1.controller; // Changed package name

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import com.tnsif.mall1.entity.Mall; // Changed import
import com.tnsif.mall1.service.MallService; // Changed import

import jakarta.persistence.NoResultException;

@RestController
public class MallController { // Class name remains 'MallController'

    @Autowired
    private MallService mallService; // Service type remains 'MallService'

    // Get all malls
    @GetMapping("/mall1service") // Changed endpoint path
    public List<Mall> list() { // Generic type remains 'Mall'
        return mallService.listAll();
    }

    // Add a new mall
    @PostMapping("/mall1service") // Changed endpoint path
    public void add(@RequestBody Mall mall) { // Parameter type remains 'Mall'
        mallService.save(mall);
    }

    // Get mall by ID
    @GetMapping("/mall1service/{id}") // Changed endpoint path
    public ResponseEntity<Mall> get(@PathVariable Long id) { // Generic type remains 'Mall'
        try {
            Mall mall = mallService.get(id); // Type remains 'Mall'
            return new ResponseEntity<Mall>(mall, HttpStatus.OK); // Generic type remains 'Mall'
        } catch (NoResultException e) {
            return new ResponseEntity<Mall>(HttpStatus.NOT_FOUND); // Generic type remains 'Mall'
        }
    }

    // Delete mall by ID
    @DeleteMapping("/mall1service/{id}") // Changed endpoint path
    public void delete(@PathVariable Long id) {
        mallService.delete(id);
    }

    // Update an existing mall
    @PutMapping("/mall1service/{id}") // Changed endpoint path
    public ResponseEntity<Mall> update(@PathVariable Long id, @RequestBody Mall updateMall) { // Generic type and parameter type remain 'Mall'
        try {
            Mall existingMall = mallService.get(id); // Type remains 'Mall'

            // Update fields
            existingMall.setMallName(updateMall.getMallName());
            existingMall.setLocation(updateMall.getLocation());
            existingMall.setTotalShops(updateMall.getTotalShops());
            existingMall.setAreaSqFt(updateMall.getAreaSqFt());

            mallService.update(existingMall);
            return new ResponseEntity<Mall>(existingMall, HttpStatus.OK); // Generic type remains 'Mall'
        } catch (NoResultException e) {
            return new ResponseEntity<Mall>(HttpStatus.NOT_FOUND); // Generic type remains 'Mall'
        }
    }
}
