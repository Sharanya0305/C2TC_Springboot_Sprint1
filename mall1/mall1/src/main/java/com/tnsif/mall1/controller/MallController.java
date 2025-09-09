package com.tnsif.mall1.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tnsif.mall1.entity.Mall;
import com.tnsif.mall1.service.MallService;

@RestController
@RequestMapping("/mall1service") // Base path
public class MallController {

    @Autowired
    private MallService mallService;

    // Get all malls
    @GetMapping
    public ResponseEntity<List<Mall>> listAllMalls() {
        List<Mall> malls = mallService.listAll();
        if (malls.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(malls, HttpStatus.OK);
    }

    // Add a new mall
    @PostMapping
    public ResponseEntity<Mall> addMall(@RequestBody Mall mall) {
        Mall savedMall = mallService.save(mall);
        return new ResponseEntity<>(savedMall, HttpStatus.CREATED);
    }

    // Get mall by ID
    @GetMapping("/{id}")
    public ResponseEntity<Mall> getMallById(@PathVariable Long id) {
        try {
            Mall mall = mallService.get(id);
            return new ResponseEntity<>(mall, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete mall by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMall(@PathVariable Long id) {
        try {
            mallService.delete(id);
            return new ResponseEntity<>("Mall deleted successfully", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Mall not found", HttpStatus.NOT_FOUND);
        }
    }

    // Update an existing mall
    @PutMapping("/{id}")
    public ResponseEntity<Mall> updateMall(@PathVariable Long id, @RequestBody Mall updateMall) {
        try {
            Mall existingMall = mallService.get(id);

            existingMall.setMallName(updateMall.getMallName());
            existingMall.setLocation(updateMall.getLocation());
            existingMall.setTotalShops(updateMall.getTotalShops());
            existingMall.setAreaSqFt(updateMall.getAreaSqFt());

            mallService.update(existingMall);
            return new ResponseEntity<>(existingMall, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
