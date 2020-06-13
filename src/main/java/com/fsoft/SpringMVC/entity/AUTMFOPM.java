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
public class AUTMFOPM {

	@Id
	@Column(name = "DPHKM_DEPO", columnDefinition = "char(2)")
	private String shippingDepotCode;

	@Column(name = "MFOPM_NAME", columnDefinition = "char(20)")
	private String shippingDepotName;

	@Column(name = "DPHKM_KKCD", columnDefinition = "char(2)")
	private String maker;

	@Column(name = "DPHKM_KKCDN", columnDefinition = "char(2)")
	private String makerName;

	@OneToOne(mappedBy = "aUTMFOPM")
	private AUTDPHKM autdphkm;

	public AUTMFOPM() {
		super();
	}

	public String getShippingDepotCode() {
		return shippingDepotCode;
	}

	public void setShippingDepotCode(String shippingDepotCode) {
		this.shippingDepotCode = shippingDepotCode;
	}

	public String getShippingDepotName() {
		return shippingDepotName;
	}

	public void setShippingDepotName(String shippingDepotName) {
		this.shippingDepotName = shippingDepotName;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getMakerName() {
		return makerName;
	}

	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}

	public AUTDPHKM getAutdphkm() {
		return autdphkm;
	}

	public void setAutdphkm(AUTDPHKM autdphkm) {
		this.autdphkm = autdphkm;
	}

}
