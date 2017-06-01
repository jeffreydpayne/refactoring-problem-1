package com.jdp.presenter.types;

import com.jdp.domain.OrderPayment;
import com.jdp.domain.PaymentType;
import com.jdp.presenter.PaymentTypePresenter;

@Component
public class GiftCertificatePresenter implements PaymentTypePresenter {

    @Override
    public String getPaymentString(OrderPayment payment) {
        
        StringBuilder result = new StringBuilder();
        result.append(FulfillmentMessages.PaymentType_GiftCertificate);
        result.append(" ");
        
        if (AuthorizationService.getInstance().isAuthorized(FulfillmentPermissions.VIEW_FULL_CREDITCARD_NUMBER)) {
            result.append(payment.getGiftCertificate().displayGiftCertificateCode());
        } else {
            result.append(payment.getGiftCertificate().displayMaskedGiftCertificateCode());
        }
        
        return result.toString();
        
    }

    @Override
    public PaymentType getPaymentType() {
        return PaymentType.GIFT_CERTIFICATE;
    }

}
