package com.banking.banksystem.dto.response;

import java.util.ArrayList;

public class FeatureResponse {
    public ArrayList<String> names;
    public ArrayList<String> description;
    public ArrayList<Integer> featurePrice;

    public FeatureResponse(ArrayList<String> names) {
        this.names = names;
    }

    public FeatureResponse(ArrayList<String> names, ArrayList<String> description) {
        this.names = names;
        this.description = description;
    }

    public FeatureResponse(ArrayList<String> names, ArrayList<Integer> featurePrice, ArrayList<String> description) {
        this.names = names;
        this.featurePrice = featurePrice;
        this.description = description;
    }
}
