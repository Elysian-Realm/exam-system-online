package com.onlinetest.domainc;

public class Teacher {

    int id;//ÀÏÊ¦id
    String name;//ĞÕÃû
    String accountnumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accountnumber='" + accountnumber + '\'' +
                '}';
    }
}
