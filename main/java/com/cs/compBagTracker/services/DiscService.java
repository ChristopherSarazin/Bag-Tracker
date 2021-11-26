package com.cs.compBagTracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.compBagTracker.models.Discs;
import com.cs.compBagTracker.repostories.DiscRepository;

@Service
public class DiscService {
	
	@Autowired
	private DiscRepository discRepository;
	
	public List<Discs> getAllDiscs(){
		return discRepository.findAll();
	}
	
	public Discs getDisc(Long id) {
		Optional<Discs> optionalDisc = this.discRepository.findById(id);
		if(optionalDisc.isPresent()) {
			return optionalDisc.get();
		} else {
			return null;
		}
	}
	
	public Discs createDiscs(Discs discs) {
		return discRepository.save(discs);
	}
	
	public Discs updateDiscs(Discs discs) {
		return discRepository.save(discs);
	}
	
	public void deleteDiscs(Long id) {
		this.discRepository.deleteById(id);
	}
	
}