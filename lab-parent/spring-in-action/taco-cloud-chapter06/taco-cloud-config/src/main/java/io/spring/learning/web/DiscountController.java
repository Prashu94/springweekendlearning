package io.spring.learning.web;

import io.spring.learning.DiscountCodeProps;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/discounts")
public class DiscountController {

    private DiscountCodeProps discountProps;

    public DiscountController(DiscountCodeProps discountProps){
        this.discountProps = discountProps;
    }

    @GetMapping
    public String displayDiscountCodes(Model model){
        Map<String, Integer> codes = discountProps.getCodes();
        model.addAttribute("codes", codes);
        return "discountList";
    }

}
