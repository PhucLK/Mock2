package com.fsoft.SpringMVC.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

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
@Repository
public interface AUTMFOPMRepository extends CrudRepository<AUTMFOPM, String> {

	/**
	 * @param shippingDepotCode
	 * @return AUTMFOPM that get from database by shippingDepotCode
	 */
	AUTMFOPM findByShippingDepotCode(String shippingDepotCode);
}
