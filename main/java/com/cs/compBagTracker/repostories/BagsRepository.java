package com.cs.compBagTracker.repostories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cs.compBagTracker.models.Bags;

@Repository
public interface BagsRepository extends CrudRepository<Bags, Long> {

	List<Bags> findAll();
	
}
