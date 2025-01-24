package com.banking.banksystem.controller;


import com.banking.banksystem.dto.response.FeatureResponse;
import com.banking.banksystem.model.Features;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/")
public class ApiControls {

    private static final Logger log = LoggerFactory.getLogger(ApiControls.class);

    @PostMapping("/features/onlineBank")
    public FeatureResponse getOnlineBankingFeatures(@RequestBody String item) {
        ArrayList<String> onlineBankFeatureNames = new ArrayList<String>();
        ArrayList<String> onlineBankFeatureDesc = new ArrayList<String>();

        onlineBankFeatureNames.add("Secure Login");
        onlineBankFeatureDesc.add("Enhance your account security with two-factor authentication, ensuring only you can access your online banking.");
        onlineBankFeatureNames.add("24/7 Account Access");
        onlineBankFeatureDesc.add("Manage your accounts anytime, anywhere with our user-friendly online banking portal.");
        onlineBankFeatureNames.add("Real-Time Notifications");
        onlineBankFeatureDesc.add("Receive instant notifications for every transaction to stay informed about your account activity.");

        Features newFeaturesPriceless = new Features(onlineBankFeatureNames, onlineBankFeatureDesc);
        newFeaturesPriceless.setFeatureNames(onlineBankFeatureNames);
        newFeaturesPriceless.setFeatureDescriptions(onlineBankFeatureDesc);

        log.info("onlineBankFeatureNames:{} \n onlineBankFeatureDesc:{}", onlineBankFeatureNames, onlineBankFeatureDesc);

        return new FeatureResponse(newFeaturesPriceless.getFeatureNames(), newFeaturesPriceless.getFeatureDescriptions());

    }

    @PostMapping("/features/cashBackCard")
    public FeatureResponse getCashbackCardFeatures(@RequestBody String item) {
        ArrayList<String> cashbackCardFeatureNames = new ArrayList<String>();
        ArrayList<String> cashbackCardFeatureDesc = new ArrayList<String>();

        cashbackCardFeatureNames.add("Unlimited Cashback");
        cashbackCardFeatureDesc.add("Earn unlimited cashback on all purchases with no expiration on rewards.");
        cashbackCardFeatureNames.add("Rotating Cashback Categories");
        cashbackCardFeatureDesc.add("Enjoy higher cashback percentages on rotating categories such as groceries, dining, and travel.");
        cashbackCardFeatureNames.add("Flexible Redemption Options");
        cashbackCardFeatureDesc.add("Redeem your cashback rewards for statement credits, gift cards, or direct deposits to your bank account.");


        Features newFeaturesPriceless = new Features(cashbackCardFeatureNames, cashbackCardFeatureDesc);
        newFeaturesPriceless.setFeatureNames(cashbackCardFeatureNames);
        newFeaturesPriceless.setFeatureDescriptions(cashbackCardFeatureDesc);


        log.info("cashbackCardFeatureNames:{} \n cashbackCardFeatureDesc:{}", cashbackCardFeatureNames, cashbackCardFeatureDesc);

        return new FeatureResponse(newFeaturesPriceless.getFeatureNames(), newFeaturesPriceless.getFeatureDescriptions());

    }

    @PostMapping("/features/creditcard")
    public FeatureResponse getCreditCardFeatures(@RequestBody String item) {
        ArrayList<String> creditCardFeatureNames = new ArrayList<String>();
        ArrayList<String> creditCardFeatureDesc = new ArrayList<String>();

        creditCardFeatureNames.add("Build Your Credit");
        creditCardFeatureDesc.add("Establish or improve your credit score with responsible card use and timely payments.");
        creditCardFeatureNames.add("Travel Insurance Coverage");
        creditCardFeatureDesc.add("Enjoy travel insurance coverage, including trip cancellations and lost luggage protection, when you book with your credit card.");
        creditCardFeatureNames.add("Extended Warranty");
        creditCardFeatureDesc.add("Get extended warranty protection on eligible purchases made with your credit card, ensuring peace of mind.");


        Features newFeaturesPriceless = new Features(creditCardFeatureNames, creditCardFeatureDesc);
        newFeaturesPriceless.setFeatureNames(creditCardFeatureNames);
        newFeaturesPriceless.setFeatureDescriptions(creditCardFeatureDesc);


        log.info("creditCardFeatureNames:{} \n creditCardFeatureDesc:{}", creditCardFeatureNames, creditCardFeatureDesc);

        return new FeatureResponse(newFeaturesPriceless.getFeatureNames(), newFeaturesPriceless.getFeatureDescriptions());

    }
}

