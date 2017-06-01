package com.jdp.presenter.types;

import com.jdp.domain.OrderPayment;
import com.jdp.domain.PaymentType;
import com.jdp.presenter.PaymentTypePresenter;

@Component
public class PaypalExpressPresenter implements PaymentTypePresenter {

    @Override
    public String getPaymentString(OrderPayment payment) {
        return payment.getEmail();
    }

    @Override
    public PaymentType getPaymentType() {
        return PaymentType.PAYPAL_EXPRESS;
    }

}
