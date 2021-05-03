package com.konda.baskinnature.controller;

import com.konda.baskinnature.model.ErrorResponse;
import com.konda.baskinnature.model.Referee;
import com.konda.baskinnature.repository.RefereeRepository;
import com.konda.baskinnature.service.implementations.RefereeServiceImpl;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/referees")
@CrossOrigin("*")
public class RefereeController {
    @Autowired
    RefereeServiceImpl refereeService;

    @Autowired
    RefereeRepository refereeRepository;

    @PostMapping
    public ResponseEntity<Referee> addRefree(@RequestBody Referee referee) {
        refereeService.addRefree(referee);
        return ResponseEntity.ok(referee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Referee> updateRefree(@RequestBody Referee referee, @PathVariable String id) {
        return ResponseEntity.ok(refereeService.updateRefree(referee, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRefree(@PathVariable String id) {
        return ResponseEntity.ok(refereeService.deleteRefree(id));
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> getRefree(@PathVariable String code) {
        Optional<Referee> referee = refereeRepository.findById(code);
        if (referee.isPresent()) {
            return new ResponseEntity(referee, HttpStatus.ACCEPTED);
        } else {
            ErrorResponse response = new ErrorResponse();
            response.setMessage("Given Code " + code + " is not invalid coupon");
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Referee>> getRefrees() {
        return ResponseEntity.ok(refereeService.getRefrees());
    }
}
