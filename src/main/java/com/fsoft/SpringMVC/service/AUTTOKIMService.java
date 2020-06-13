package com.fsoft.SpringMVC.service;

import com.fsoft.SpringMVC.entity.AUTTOKIM;

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
public interface AUTTOKIMService {

	/**
	 * @param auttokim
	 * @return insert AUTTOKIM into database
	 */
	AUTTOKIM save(AUTTOKIM auttokim);
}
