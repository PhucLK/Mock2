package com.fsoft.SpringMVC.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

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
@Repository
public interface AUTDPHKMRepository extends CrudRepository<AUTDPHKM, String> {

	/**
	 * @param pageable
	 * @return A page is a sublist of a list of AUTDPHKM
	 */
	Page<AUTDPHKM> findAll(Pageable pageable);
	
	/**
	 * @param sScode
	 * @return AUTDPHKM that get from database by sScode
	 */
	AUTDPHKM findBySScode(String sScode);
	
	/**
	 * @param shippingDepotCode
	 * @return List of AUTDPHKM that get from database by shippingDepotCode
	 */
	AUTDPHKM findByAUTMFOPM_ShippingDepotCode(String shippingDepotCode);
	
	/**
	 * @param sScode
	 * @return List of AUTDPHKM that get from database by shippingDepotCode
	 */
	List<AUTDPHKM> findAllBySScodeLikeIgnoreCase(String sScode);
	
	/**
	 * @param carType
	 * @return List of AUTDPHKM that get from database by carType
	 */
	List<AUTDPHKM> findByCarTypeLikeIgnoreCase(String carType);
	
	/**
	 * @param sScode
	 * @return List of AUTDPHKM that get from database by sScode
	 */
	List<AUTDPHKM> findByDeliveryLocationCodeLikeIgnoreCase(String sScode);

	/**
	 * @param manufactureCode
	 * @return List of AUTDPHKM that get from database by manufactureCode
	 */
	List<AUTDPHKM> findByAUTTOKIM_ManufactureCodeLikeIgnoreCase(String manufactureCode);

	/**
	 * @param maker
	 * @return List of AUTDPHKM that get from database by maker
	 */
	List<AUTDPHKM> findByAUTMFOPM_MakerLikeIgnoreCase(String maker);

	/**
	 * @param shippingDepotCode
	 * @return List of AUTDPHKM that get from database by shippingDepotCode
	 */
	List<AUTDPHKM> findByAUTMFOPM_ShippingDepotCodeLikeIgnoreCase(String shippingDepotCode);
}
