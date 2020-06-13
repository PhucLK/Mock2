package com.fsoft.SpringMVC.service;

import java.util.List;

import com.fsoft.SpringMVC.entity.AUTMFOPM;

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
public interface AUTMFOPMService {

	/**
	 * @param shippingDepotCode
	 * @return AUTMFOPM that get from database by shippingDepotCode
	 */
	AUTMFOPM findByShippingDepotCode(String shippingDepotCode);
	
	/**
	 * @return List of AUTMFOPM
	 */
	List<AUTMFOPM> getAll();
}
