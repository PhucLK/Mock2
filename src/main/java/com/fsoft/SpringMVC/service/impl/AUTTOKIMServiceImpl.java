package com.fsoft.SpringMVC.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsoft.SpringMVC.entity.AUTTOKIM;
import com.fsoft.SpringMVC.repository.AUTTOKIMRepository;
import com.fsoft.SpringMVC.service.AUTTOKIMService;

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
public class AUTTOKIMServiceImpl implements AUTTOKIMService{

	
	@Autowired
	AUTTOKIMRepository aUTTOKIMRepository;

	@Override
	public AUTTOKIM save(AUTTOKIM auttokim) {
		// TODO Auto-generated method stub
		return aUTTOKIMRepository.save(auttokim);
	}

	
}
