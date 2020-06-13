package com.fsoft.SpringMVC.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
@Entity
public class AUTTOKIM {

	@Id
	@Column(name = "DPHKM_PART", columnDefinition = "char(18)")
	private String manufactureCode;

	@Column(name = "TOKIM_RYAK", columnDefinition = "char(10)")
	private String manufactureName;

	@OneToOne(mappedBy = "aUTTOKIM", orphanRemoval = true)
	private AUTDPHKM autdphkm;

	public AUTTOKIM() {
		super();
	}

	public String getManufactureCode() {
		return manufactureCode;
	}

	public void setManufactureCode(String manufactureCode) {
		this.manufactureCode = manufactureCode;
	}

	public String getManufactureName() {
		return manufactureName;
	}

	public void setManufactureName(String manufactureName) {
		this.manufactureName = manufactureName;
	}

	public AUTDPHKM getAutdphkm() {
		return autdphkm;
	}

	public void setAutdphkm(AUTDPHKM autdphkm) {
		this.autdphkm = autdphkm;
	}

}
