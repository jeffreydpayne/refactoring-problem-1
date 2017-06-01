package com.jdp.presenter.types;

import com.jdp.domain.OrderPayment;
import com.jdp.domain.PaymentType;
import com.jdp.presenter.PaymentTypePresenter;

@Component
public class GoogleCheckoutPresenter implements PaymentTypePresenter {

    @Override
    public String getPaymentString(OrderPayment payment) {
        final String shipmentNumber = payment.getOrderShipment().getShipmentNumber();
        final String googleOrderSource = Order.ORDER_SOURCE_GOOGLE_CHECKOUT;
        final String email = payment.getEmail();
        return NLS.bind(FulfillmentMessages.RefundWizard_GoogleSourceDescription, 
                shipmentNumber + ":" + googleOrderSource, email);
    }

    @Override
    public PaymentType getPaymentType() {
        return PaymentType.GOOGLE_CHECKOUT;
    }

}
