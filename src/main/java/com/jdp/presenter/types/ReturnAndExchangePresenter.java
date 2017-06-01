package com.jdp.presenter.types;

import com.jdp.domain.OrderPayment;
import com.jdp.domain.PaymentType;
import com.jdp.presenter.PaymentTypePresenter;

@Component
public class ReturnAndExchangePresenter implements PaymentTypePresenter {

    @Override
    public String getPaymentString(OrderPayment payment) {
        
        OrderShipment shipment = payment.getOrderShipment();            
        if (shipment != null && shipment.getOrder() != null) {
            Order order = shipment.getOrder();
            if (order.getStatus() == OrderStatus.AWAITING_EXCHANGE) {
                return FulfillmentMessages.Exchange_Pending_Payment_Details;  //bad java naming convention here - not sure if you wanted this changed
            } else if (order.getStatus() != OrderStatus.AWAITING_EXCHANGE
                    && order.getStatus() != OrderStatus.CANCELLED) {    
                return FulfillmentMessages.Exchange_Completed_Payment_Details;
            }
        }
        return "";
    }

    @Override
    public PaymentType getPaymentType() {
        return PaymentType.RETURN_AND_EXCHANGE;
    }

}
