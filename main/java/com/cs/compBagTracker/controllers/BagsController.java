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

import com.cs.compBagTracker.models.Bags;
import com.cs.compBagTracker.models.Discs;
import com.cs.compBagTracker.services.BagService;
import com.cs.compBagTracker.services.DiscService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class BagsController {

	@Autowired
	private BagService bagService;
	
	@Autowired
	private DiscService discService;
	

	
	@GetMapping("/getBags")
	public List<Bags> getBags(){
		
		return bagService.getAllBags();
	}
	
	@PostMapping("/createBag")
	Bags createBag(Bags bags) {
		return bagService.createBag(bags);
	}
	
	@GetMapping("/getBags/{id}")
	Bags view(@PathVariable Long id) {
    	return bagService.getBag(id);
	}
	
	@DeleteMapping("/getBags/{id}/deleteBag")
    public void deleteBag(@PathVariable("id") Long id) {
    	 this.bagService.deleteBag(id);
    }
	
	@PutMapping(value="/updateBag/{id}")
	public void updateBag(@ModelAttribute("bag")Bags bag, @PathVariable("id")Long id) {
		bagService.updatedBag(bag);
	}
	
	
	@PutMapping("/getBags/{bagId}/discs/{discId}")
	Bags putInBag(
			@PathVariable Long bagId,
			@PathVariable Long discId
		) {
			Bags bag = bagService.getBag(bagId);
			Discs disc = discService.getDisc(discId);
			bag.discsInBag(disc);
			return bagService.updatedBag(bag);
		
	}
	
	@CrossOrigin(origins = "http://localhost:3000/oneBag/{bagId}/discs")
	@PutMapping("getBags/{bagId}/removeDisc/{discId}")
	Bags removeFromBag(
			@PathVariable Long bagId,
			@PathVariable Long discId
		) {
		Bags bag = bagService.getBag(bagId);
		Discs disc = discService.getDisc(discId);
		bag.removeDiscsFromBag(disc);
		return bagService.updatedBag(bag);
	}
	
	
	@GetMapping("getBags/{bagId}/discs")
	List<Discs> getDiscsToAddToBag() {
		return discService.getAllDiscs();
	}
	
}