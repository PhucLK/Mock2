package com.fsoft.SpringMVC.entity;

import java.io.Serializable;
import java.util.Objects;

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
public class AUTDPHKM_ID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String sScode;

	private String deliveryLocationCode;

	private String carType;

	public AUTDPHKM_ID() {
		super();
	}

	public String getsScode() {
		return sScode;
	}

	public void setsScode(String sScode) {
		this.sScode = sScode;
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

	public AUTDPHKM_ID(String sS_code, String deliveryLocationCode, String carType) {
		super();
		this.sScode = sS_code;
		this.deliveryLocationCode = deliveryLocationCode;
		this.carType = carType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		AUTDPHKM_ID accountId = (AUTDPHKM_ID) o;
		return sScode.equals(accountId.getsScode()) && deliveryLocationCode.equals(accountId.getDeliveryLocationCode())
				&& carType.equals(accountId.getCarType());
	}

	@Override
	public int hashCode() {
		return Objects.hash(sScode, deliveryLocationCode, carType);
	}

}
