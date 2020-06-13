package com.fsoft.SpringMVC.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsoft.SpringMVC.entity.AUTMFOPM;
import com.fsoft.SpringMVC.repository.AUTMFOPMRepository;
import com.fsoft.SpringMVC.service.AUTMFOPMService;

/**
 * @author PhucTV7
 *
 * Version 1.0
 *
 * @date 2020-Jun-11
 *
 * Copyright
 *
 */
@Service
public class AUTMFOPMServiceImpl implements AUTMFOPMService{

	@Autowired
	AUTMFOPMRepository aUTMFOPMRepository;
	
	@Override
	public AUTMFOPM findByShippingDepotCode(String shippingDepotCode) {
		return aUTMFOPMRepository.findByShippingDepotCode(shippingDepotCode);
	}

	@Override
	public List<AUTMFOPM> getAll() {
		return (List<AUTMFOPM>) aUTMFOPMRepository.findAll();
	}

}
