package com.security.demo.Controller;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CheckoutController {

    @GetMapping("/checkout")
    public String checkout(Model model) throws StripeException {
        model.addAttribute("amount", 100); //in cents
        model.addAttribute("currency", "usd");
        model.addAttribute("source", "tok_visa");
        model.addAttribute("receipt_email","jenny.rosen@example.com");

        return "views/checkout";
    }
}
