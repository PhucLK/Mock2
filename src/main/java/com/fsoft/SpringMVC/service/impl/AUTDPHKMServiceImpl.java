package com.fsoft.SpringMVC.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fsoft.SpringMVC.entity.AUTDPHKM;
import com.fsoft.SpringMVC.repository.AUTDPHKMRepository;
import com.fsoft.SpringMVC.service.AUTDPHKMService;

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
public class AUTDPHKMServiceImpl implements AUTDPHKMService {

	@Autowired
	AUTDPHKMRepository aUTDPHKMRepository;

	@Override
	public Page<AUTDPHKM> getAll(int page, int size) {
		Pageable pageable = new PageRequest(page, size);
		return aUTDPHKMRepository.findAll(pageable);
	}
	
	@Override
	public List<AUTDPHKM> getAlls() {
		return (List<AUTDPHKM>) aUTDPHKMRepository.findAll();
	}

	@Override
	public AUTDPHKM save(AUTDPHKM autdphkm) {
		return aUTDPHKMRepository.save(autdphkm);
	}

	@Override
	public void delete(AUTDPHKM autdphkm) {
		aUTDPHKMRepository.delete(autdphkm);
	}

	@Override
	public AUTDPHKM get(String sScode) {
		return aUTDPHKMRepository.findBySScode(sScode);
	}

	@Override
	public List<AUTDPHKM> searchBySScode(String text) {
		return (List<AUTDPHKM>) aUTDPHKMRepository.findAllBySScodeLikeIgnoreCase("%" + text + "%");
	}

	@Override
	public List<AUTDPHKM> searchByCarType(String text) {
		return (List<AUTDPHKM>) aUTDPHKMRepository.findByCarTypeLikeIgnoreCase("%" + text + "%");
	}

	@Override
	public List<AUTDPHKM> searchByDeliveryLocationCode(String text) {
		return (List<AUTDPHKM>) aUTDPHKMRepository.findByDeliveryLocationCodeLikeIgnoreCase("%" + text + "%");
	}

	@Override
	public List<AUTDPHKM> searchByManufactureCode(String text) {
		return (List<AUTDPHKM>) aUTDPHKMRepository.findByAUTTOKIM_ManufactureCodeLikeIgnoreCase("%" + text + "%");
	}

	@Override
	public List<AUTDPHKM> searchByMaker(String text) {
		return (List<AUTDPHKM>) aUTDPHKMRepository.findByAUTMFOPM_MakerLikeIgnoreCase("%" + text + "%");
	}

	@Override
	public List<AUTDPHKM> searchByShippingDepotCode(String text) {
		return (List<AUTDPHKM>) aUTDPHKMRepository.findByAUTMFOPM_ShippingDepotCodeLikeIgnoreCase("%" + text + "%");
	}

	@Override
	public AUTDPHKM findByShippingDepotCode(String shippingDepotCode) {
		return aUTDPHKMRepository.findByAUTMFOPM_ShippingDepotCode(shippingDepotCode);
	}

}
