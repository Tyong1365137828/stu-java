package edu.hebeu.service.impl;

import edu.hebeu.service.IAccountService;

import java.util.*;

public class IAccountServiceImpl3 implements IAccountService {

    private String[] myStrings;
    private List myList;
    private Set mySet;
    private Map<String, String> myMap;
    private Properties myProperties;

    public String[] getMyStrings() {
        return myStrings;
    }

    public void setMyStrings(String[] myStrings) {
        this.myStrings = myStrings;
    }

    public Set getMySet() {
        return mySet;
    }

    public void setMySet(Set mySet) {
        this.mySet = mySet;
    }

    public List getMyList() {
        return myList;
    }

    public void setMyList(List myList) {
        this.myList = myList;
    }

    public Map<String, String> getMyMap() {
        return myMap;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public Properties getMyProperties() {
        return myProperties;
    }

    public void setMyProperties(Properties myProperties) {
        this.myProperties = myProperties;
    }

    public void addAccount() {
        System.out.println(Arrays.toString(myStrings));
        System.out.println(myList);
        System.out.println(mySet);
        System.out.println(myMap);
        System.out.println(myProperties);
    }

}
