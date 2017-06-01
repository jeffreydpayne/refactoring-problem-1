package com.jdp.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.jdp.domain.OrderPayment;
import com.jdp.presenter.FulfillmentPresenter;

/**
 * Sample test for the default case.
 * 
 * @author jeffreydpayne
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class CreditPresenterTest {
    
    @Autowired
    private FulfillmentPresenter presenter;
    
    @Test
    public void testDefaultHandling() throws Exception {
        
                
        OrderPayment payment = new OrderPayment();
        payment.setUncryptedCardNumber(TestCards.VANTIV_1.getPan());
        payment.setCardType(TestCards.VANTIV_1.getCardType());
        payment.setExpiryMonth(TestCards.VANTIV_1.getExpiryMonth());
        payment.setExpiryYear(TestCards.VANTIV_1.getExpiryYear());
        
        String result = presenter.getPaymentString(payment);
        
        assertThat(result).isNotNull();
        assertThat(result).contains(TestCards.VANTIV_1.getPan()); //assumes unmasked pan is authorized
        assertThat(result).contains(TestCards.VANTIV_1.getCardType());
        assertThat(result).contains(TestCards.VANTIV_1.getExpiryMonth() + "/" + TestCards.VANTIV_1.getExpiryYear());
        
        
        
    }

}
