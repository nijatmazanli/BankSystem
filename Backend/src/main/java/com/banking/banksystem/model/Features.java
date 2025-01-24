package com.banking.banksystem.model;

import java.util.ArrayList;

public class Features {
    ArrayList<String> featureNames;
    ArrayList<Integer> featurePrices;
    ArrayList<String> featureDescriptions;

    public Features(ArrayList<String> featureNames) {
        this.featureNames = featureNames;
    }

    public Features(ArrayList<String> featureDescriptions, ArrayList<String> featureNames) {
        this.featureDescriptions = featureDescriptions;
        this.featureNames = featureNames;
    }

    public Features(ArrayList<String> featureNames, ArrayList<Integer> featurePrices, ArrayList<String> featureDescriptions) {
        this.featureNames = featureNames;
        this.featurePrices = featurePrices;
        this.featureDescriptions = featureDescriptions;
    }

    public ArrayList<String> getFeatureNames() {
        return featureNames;
    }

    public void setFeatureNames(ArrayList<String> featureNames) {
        this.featureNames = featureNames;
    }

    public ArrayList<Integer> getFeaturePrices() {
        return featurePrices;
    }

    public void setFeaturePrices(ArrayList<Integer> featurePrices) {
        this.featurePrices = featurePrices;
    }

    public ArrayList<String> getFeatureDescriptions() {
        return featureDescriptions;
    }

    public void setFeatureDescriptions(ArrayList<String> featureDescriptions) {
        this.featureDescriptions = featureDescriptions;
    }
}
