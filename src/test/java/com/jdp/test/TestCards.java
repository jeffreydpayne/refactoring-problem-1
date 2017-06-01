package com.jdp.test;


/**
 * Enumerates a few common test cards provided by some of the major 
 * merchant processors.
 * 
 * @author jeffreydpayne
 *
 */

public enum TestCards {
    
    VANTIV_1("49952810000006", 12, 2025, "123"),
    CAYAN("4012000033330026", 12, 2019, "123"),
    OPEN_EDGE_VISA("4217651111111119", 12, 2015, "123");

    
    private String pan;
    private Integer expiryMonth;
    private Integer expiryYear;
    private String cvv;
    
    private TestCards(String pan, Integer expiryMonth, Integer expiryYear, String cvv) {
        
        this.pan = pan;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        this.cvv = cvv;
        
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public Integer getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(Integer expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public Integer getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(Integer expiryYear) {
        this.expiryYear = expiryYear;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
    
    
}
