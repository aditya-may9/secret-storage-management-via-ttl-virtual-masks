package com.identity.controller;

import com.identity.pojo.Merchant;
import com.identity.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/merchant")
public class MerchantAPI {

    @Autowired
    MerchantService merchantService;

    @RequestMapping("/test")
    public String test() {
        return "Merchant test";
    }

    @RequestMapping("/registerMerchantToCentralAuthority")
    public Merchant registerMerchantToCentralAuthority(@RequestParam(value = "identity") String identity,
                                                       @RequestParam(value = "name") String name,
                                                       @RequestParam(value = "address") String address,
                                                       @RequestParam(value = "email") String email,
                                                       @RequestParam(value = "password") String password,
                                                       @RequestParam(value = "description") String description) {
        return merchantService.registerMerchantToCentralAuthority(identity, name, address, email, password, description);
    }

    @RequestMapping("/unregisterMerchantFromCentralRepository")
    public Merchant unregisterMerchantFromCentralRepository(@RequestParam(value = "email") String email) {
        return merchantService.unregisterMerchantFromCentralRepository(email);
    }

    @RequestMapping("/updateMerchantData")
    public Merchant updateMerchantData(@RequestParam(value = "identity") String identity,
                                       @RequestParam(value = "name") String name,
                                       @RequestParam(value = "address") String address,
                                       @RequestParam(value = "email") String email,
                                       @RequestParam(value = "password") String password,
                                       @RequestParam(value = "description") String description) {
        return merchantService.updateMerchantData(identity, name, address, email, password, description);
    }

    @RequestMapping("/getMerchantData")
    public Merchant getMerchantData(@RequestParam(value = "email") String email) {
        return merchantService.getMerchantData(email);
    }

}