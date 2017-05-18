package com.eventzone.cosc412.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "Payment")
public class Payment {
	
	@Id
    @GeneratedValue
	@Column(name = "PAYMENT_ID")
	Long paymentID;
	

	@Column(name = "USER_INFO_ID")
	Long userInfoId;
	
    public Long getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(Long userInfoId) {
		this.userInfoId = userInfoId;
	}

	@Column(name = "SCHOOL_ID")
	Long schoolID;
	
	public Long getSchoolID() {
		return schoolID;
	}

	public void setSchoolID(Long schoolID) {
		this.schoolID = schoolID;
	}

	@Column(name = "FACILITY_ID")
    Long facilityID;
    
    @Column(name = "CARD_HOLDER_NAME")
    String cardHolderName;
    
    @Column(name = "ZIP_CODE")
    String zipCode;
    
    @Column(name = "TOTAL_PRICE")
    Double totalPrice;
    
    @Column(name = "EXP_DATE")
    String expDate;
    
    @Column(name = "PaymentInfo")
    String paymentInfo;

	public Long getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(Long paymentID) {
		this.paymentID = paymentID;
	}

	public Long getFacilityID() {
		return facilityID;
	}

	public void setFacilityID(Long facilityID) {
		this.facilityID = facilityID;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
    
}
