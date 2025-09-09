package com.tnsif.mall1.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnsif.mall1.entity.Mall;
import com.tnsif.mall1.repository.MallRepository;

@Service
public class MallService {

    @Autowired
    private MallRepository mallRepository;

    // Get all malls
    public List<Mall> listAll() {
        return mallRepository.findAll();
    }

    // Save a new mall and return the saved object
    public Mall save(Mall mall) {
        return mallRepository.save(mall); // JPA save() returns saved entity
    }

    // Get a mall by ID
    public Mall get(Long id) {
        return mallRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Mall not found with id: " + id));
    }

    // Update an existing mall
    public Mall update(Mall mall) {
        // save() will update if the entity has an existing ID
        return mallRepository.save(mall);
    }

    // Delete a mall by ID
    public void delete(Long id) {
        if (!mallRepository.existsById(id)) {
            throw new NoSuchElementException("Mall not found with id: " + id);
        }
        mallRepository.deleteById(id);
    }
}
