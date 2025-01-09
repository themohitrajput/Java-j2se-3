package com.ecommerce.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
import com.ecommerce.entity.EProductEntity;


@Controller
public class EProductController {

        @Autowired
         
            @RequestMapping(value = "/productList", method = RequestMethod.GET)
            public String listProducts(ModelMap map)
            {
                map.addAttribute("eproduct", new EProductEntity());
				return null;
         
                
            }
}
