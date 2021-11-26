package com.cs.compBagTracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.compBagTracker.models.Bags;
import com.cs.compBagTracker.repostories.BagsRepository;

@Service
public class BagService {

	@Autowired
	private BagsRepository bagsRepository;
	
	public List<Bags> getAllBags(){
		return bagsRepository.findAll();
	}
	
	public Bags getBag(Long id) {
		Optional<Bags> optionalBag = this.bagsRepository.findById(id);
		if(optionalBag.isPresent()) {
			return optionalBag.get();
		}
		else {
			return null;
		}
	}
	
	public Bags createBag(Bags bags) {
		return bagsRepository.save(bags);
	}
	
	public Bags updatedBag(Bags bags) {
		return bagsRepository.save(bags);
	}
	
	public void deleteBag(Long id) {
		this.bagsRepository.deleteById(id);
	}
	
	
}
