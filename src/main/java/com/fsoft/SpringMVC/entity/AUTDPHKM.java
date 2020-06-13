package com.fsoft.SpringMVC.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

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
@IdClass(AUTDPHKM_ID.class)
public class AUTDPHKM {

	@Id
	@Column(name = "DPHKM_SSCD", columnDefinition = "char(1)")
	private String sScode;

	@Column(name = "DPHKM_SSCDN", columnDefinition = "char(8)")
	private String sSName;

	@Id
	@Column(name = "DPHKM_FORM", columnDefinition = "char(8)")
	private String deliveryLocationCode;

	@Id
	@Column(name = "DPHKM_SYCD", columnDefinition = "char(1)")
	private String carType;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "DPHKM_PART")
	private AUTTOKIM aUTTOKIM;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "DPHKM_DEPO")
	private AUTMFOPM aUTMFOPM;

	@Transient
	private String OP;

	public AUTDPHKM() {
		super();
	}

	public String getsScode() {
		return sScode;
	}

	public void setsScode(String sScode) {
		this.sScode = sScode;
	}

	public String getsSName() {
		return sSName;
	}

	public void setsSName(String sSName) {
		this.sSName = sSName;
	}

	public String getDeliveryLocationCode() {
		return deliveryLocationCode;
	}

	public void setDeliveryLocationCode(String deliveryLocationCode) {
		this.deliveryLocationCode = deliveryLocationCode;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public AUTTOKIM getaUTTOKIM() {
		return aUTTOKIM;
	}

	public void setaUTTOKIM(AUTTOKIM aUTTOKIM) {
		this.aUTTOKIM = aUTTOKIM;
	}

	public AUTMFOPM getaUTMFOPM() {
		return aUTMFOPM;
	}

	public void setaUTMFOPM(AUTMFOPM aUTMFOPM) {
		this.aUTMFOPM = aUTMFOPM;
	}

	public String getOP() {
		return OP;
	}

	public void setOP(String oP) {
		OP = oP;
	}

}
