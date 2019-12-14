package com.example.employeerecycler;

public class EmpModel  {
    private String name;
    private  String jobProfile;
    private String companyName;
    private String addresss;

    public EmpModel(String name, String jobProfile, String companyName, String addresss) {
        this.name = name;
        this.jobProfile = jobProfile;
        this.companyName = companyName;
        this.addresss = addresss;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobProfile() {
        return jobProfile;
    }

    public void setJobProfile(String jobProfile) {
        this.jobProfile = jobProfile;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddresss() {
        return addresss;
    }

    public void setAddresss(String addresss) {
        this.addresss = addresss;
    }
}
