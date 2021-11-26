package com.cs.compBagTracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.compBagTracker.models.Discs;
import com.cs.compBagTracker.services.DiscService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class DiscController {

	@Autowired
	private DiscService discService;
	
	
	@GetMapping("/getDiscs")
	List<Discs> getDiscs() {return discService.getAllDiscs();}
	
	@PostMapping("/createDiscs")
	Discs createDisc(Discs disc) {
		return discService.createDiscs(disc);
	}
	
	@GetMapping("/oneDisc/{id}")
	public Discs view(@PathVariable("id")Long id) {
    	return discService.getDisc(id);
	}
	
	@DeleteMapping("/oneDisc/{id}/deleteDisc")
    public void deleteDisc(@PathVariable("id") Long id) {
    	 this.discService.deleteDiscs(id);
    }
	
	@PutMapping("/updateDisc/{id}")
	public void updateDisc(@ModelAttribute("disc")Discs disc, @PathVariable("id")Long id) {
		discService.updateDiscs(disc);
	}
	
	
	
}