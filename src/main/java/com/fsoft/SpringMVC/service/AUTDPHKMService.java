package com.fsoft.SpringMVC.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.fsoft.SpringMVC.entity.AUTDPHKM;

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
public interface AUTDPHKMService {

	/**
	 * @param autdphkm
	 * @return insert AUTDPHKM into database and return AUTDPHKM
	 */
	AUTDPHKM save(AUTDPHKM autdphkm);
	
	/**
	 * @param autdphkm
	 */
	void delete(AUTDPHKM autdphkm);

	/**
	 * @param page
	 * @param size
	 * @return A page is a sublist of a list of AUTDPHKM
	 */
	Page<AUTDPHKM> getAll(int page, int size);
	
	/**
	 * @param sScode 
	 * @return AUTDPHKM from database by sScode
	 */
	AUTDPHKM get(String sScode);
	
	/**
	 * @param shippingDepotCode
	 * @return AUTDPHKM from database by shippingDepotCode
	 */
	AUTDPHKM findByShippingDepotCode(String shippingDepotCode);
	
	/**
	 * @param text
	 * @return List of AUTDPHKM that get from database by sScode
	 */
	List<AUTDPHKM> searchBySScode(String text);
	
	/**
	 * @param text
	 * @return List of AUTDPHKM that get from database by carType
	 */
	List<AUTDPHKM> searchByCarType(String text);
	
	/**
	 * @param text
	 * @return List of AUTDPHKM that get from database by deliveryLocationCode
	 */
	List<AUTDPHKM> searchByDeliveryLocationCode(String text);

	/**
	 * @param text
	 * @return List of AUTDPHKM that get from database by manufactureCode
	 */
	List<AUTDPHKM> searchByManufactureCode(String text);

	/**
	 * @param text
	 * @return List of AUTDPHKM that get from database by maker
	 */
	List<AUTDPHKM> searchByMaker(String text);

	/**
	 * @param text
	 * @return List of AUTDPHKM that get from database by shippingDepotCode
	 */
	List<AUTDPHKM> searchByShippingDepotCode(String text);

	/**
	 * @return List of AUTDPHKM that get from database 
	 */
	List<AUTDPHKM> getAlls();
}
