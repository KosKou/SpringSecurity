package com.security.demo.REST;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CheckoutRestController {

    @GetMapping("/process")
    public Object checkout() throws StripeException {
        Stripe.apiKey = "sk_test_vzODNB0cHOJ90KUJ2bGfWBCv";

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("amount", 100);
        params.put("currency", "usd");
        params.put("source", "tok_visa");
        params.put("receipt_email", "jenny.rosen@example.com");
        Charge charge = Charge.create(params);

        return charge.toJson();
    }
}
