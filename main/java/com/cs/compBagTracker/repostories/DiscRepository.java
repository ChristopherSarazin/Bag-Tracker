package com.cs.compBagTracker.repostories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cs.compBagTracker.models.Discs;



@Repository
public interface DiscRepository extends CrudRepository<Discs, Long> {
	
	List<Discs> findAll();

}
