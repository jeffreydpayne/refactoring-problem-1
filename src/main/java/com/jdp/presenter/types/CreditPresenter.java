package com.jdp.presenter.types;

import java.util.ArrayList;
import java.util.List;

import com.jdp.domain.OrderPayment;
import com.jdp.domain.PaymentType;
import com.jdp.presenter.PaymentTypePresenter;

@Component
public class CreditPresenter implements PaymentTypePresenter {

    @Override
    public String getPaymentString(OrderPayment payment) {
        final List<String> bindings = new ArrayList<String>();
       // for other payments, card type, credit card number, expire date, expire year will be shown as payment source
        String creditCardNumber = null;
        if (AuthorizationService.getInstance().isAuthorized(FulfillmentPermissions.VIEW_FULL_CREDITCARD_NUMBER)) {
            creditCardNumber = payment.getUnencryptedCardNumber();
        }
        if (creditCardNumber == null) {
            creditCardNumber = payment.getMaskedCardNumber();
        }
        bindings.add(payment.getCardType());
        bindings.add(creditCardNumber);
        bindings.add(payment.getExpiryMonth());
        bindings.add(payment.getExpiryYear());
        final int numberOfObjectsToBind = 4;
        return NLS.bind(FulfillmentMessages.RefundWizard_CardDescription, bindings.toArray(new Object[numberOfObjectsToBind]));
    }

    @Override
    public PaymentType getPaymentType() {
        return PaymentType.CREDIT;
    }

}
