package com.starxfighter.dojoninjas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.starxfighter.dojoninjas.models.Dojo;
import com.starxfighter.dojoninjas.models.Ninja;
import com.starxfighter.dojoninjas.repos.DojoRepository;
import com.starxfighter.dojoninjas.repos.NinjaRepository;

@Service
public class DojoNinjaService {
	private final DojoRepository dojoRepo;
	private final NinjaRepository ninjaRepo;
	
	public DojoNinjaService(DojoRepository dojoRepo, NinjaRepository ninjaRepo) {
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}
	
	public List<Dojo> allDojo(){
		return dojoRepo.findAll();
	}
	
	public List<Ninja> allNinja(){
		return ninjaRepo.findAll();
	}
	
	public Dojo createDojo(Dojo d) {
		return dojoRepo.save(d);
	}
	
	public Ninja createNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
//end
}
