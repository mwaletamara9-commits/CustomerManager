package org.example.customermanager;

public class Customer {
    private String name;
    private String province;
    private String phone;

    public Customer(String name, String province, String phone) {
        this.name = name;
        this.province = province;
        this.phone = phone;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getProvince() { return province; }
    public void setProvince(String province) { this.province = province; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
