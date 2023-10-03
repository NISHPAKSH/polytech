package com.ttc.polytechnicshiksha;

public class placement_Hero {



    String college_name, company_name,company_address;

    public placement_Hero(String collegename, String companyname, String companyaddress) {
        this.college_name = collegename;
        this.company_name = companyname;
        this.company_address = companyaddress;
    }

    public String getCompany_name() {
        return company_name;
    }

    public String getCollege_name() { return college_name;}

    public String getCompany_address() {
        return company_address;
    }
}
