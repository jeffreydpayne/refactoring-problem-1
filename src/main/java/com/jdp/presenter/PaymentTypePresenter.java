package com.jdp.presenter;

import com.jdp.domain.OrderPayment;
import com.jdp.domain.PaymentType;

public interface PaymentTypePresenter {
    
    String getPaymentString(final OrderPayment payment);
    PaymentType getPaymentType();

}
