package com.heroku.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.heroku.demo.entity.Record;
import com.heroku.demo.repository.RecordRepository;

@RestController
@RequestMapping("/records")
public class ApiController {
	
	private RecordRepository repository;

    @Autowired
    public ApiController(RecordRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
	public List<Record> records() {
		return repository.findAll();
	}
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> record(@RequestBody Record record) {
    	repository.save(record);
    	return new ResponseEntity<String>("Record created successfully", HttpStatus.OK);
    }
}
