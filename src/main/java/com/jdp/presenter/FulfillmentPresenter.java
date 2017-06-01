package com.jdp.presenter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.jdp.domain.OrderPayment;
import com.jdp.domain.PaymentType;
import com.jdp.presenter.types.CreditPresenter;

/**
 * This refactored implementation assumes the use of a dependency injection framework like Spring although it
 * could be done other ways depending on what architecture the application is using.
 * 
 * In essence, we define an interface for turning payment metadata into strings based on the payment type.
 * 
 * To add a new payment type, you merely create a new class that implements the PaymentTypePresenter interface 
 * and add a value to the PaymentType enum for the new payment type.
 * 
 * If we wanted to ensure that we never had to change any existing code to add a new payment type, including the 
 * enum, then we could get rid of the payment type enum and just use string literals.  I'd probably stick with enums.  
 * In my experience the chief practical benefit of favoring extension over modification is that it minimizes ugly merge
 * conflicts.  Adding values to enums rarely creates difficult merges.
 * 
 * When spring loads this class, it will automatically discover all implementations of the PaymentTypePresenter
 * interface in the classpath and we translate the collection of presenters into a map keyed by PaymentType.
 * 
 * Then all we have to do is look up the presenter for the PaymentType and invoke it.  If there is no payment type,
 * then in keeping with the spirit of the original class, we assume that the CreditPresenter is the default.
 * 
 * @author jeffreydpayne
 *
 */

@Component
public class FulfillmentPresenter {
    
    private Map<PaymentType, PaymentTypePresenter> presenterMap;

    
    @Autowired
    private CreditPresenter defaultPresenter;
    
    
    @Autowired
    public void setPresenters(Collection<PaymentTypePresenter> presenters) {
        
       presenterMap = new HashMap<>();
       
       presenters.stream().peek(p -> presenterMap.put(p.getPaymentType(), p));
        
    }
    
    
    /**
     * @param payment the payment.
     * @return string description of the payment.
     */
    public String getPaymentString(final OrderPayment payment) {
        
        if (payment == null) {
            return "";
        }
        
        PaymentTypePresenter presenter = presenterMap.get(payment.getPaymentMethod());
        
        if (presenter == null) {
            presenter = defaultPresenter;
        }
        
        return presenter.getPaymentString(payment);

    }

}
