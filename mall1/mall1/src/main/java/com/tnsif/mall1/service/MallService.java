package com.tnsif.mall1.service; // Changed package name

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnsif.mall1.entity.Mall; // Changed import
import com.tnsif.mall1.repository.MallRepository; // Changed import

import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class MallService { // Class name remains 'MallService'

    @Autowired
    private MallRepository repo; // Repository type remains 'MallRepository'

    // List all malls
    public List<Mall> listAll() { // Generic type remains 'Mall'
        return repo.findAll();
    }

    // Save a new mall
    public void save(Mall mall) { // Parameter type remains 'Mall'
        repo.save(mall);
    }

    // Get mall by ID
    public Mall get(Long id) { // Return type remains 'Mall'
        return repo.findById(id).orElseThrow(NoResultException::new);
    }

    // Delete mall by ID
    public void delete(Long id) {
        repo.deleteById(id);
    }

    // Update an existing mall
    public void update(Mall mall) { // Parameter type remains 'Mall'
        repo.save(mall);
    }
}
