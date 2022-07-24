package com.onlinetest.domainc;

public class UserMsg {
    int id;
    String name;
    int _class;
    String accountnumber;
    String password;

    String type;

    public UserMsg()
    {

    }

    public UserMsg(int id,String name, int _class, String accountnumber, String password, String type)
    {
        this.id=0;
        this.name=name;
        this._class=_class;
        this.accountnumber=accountnumber;
        this.password=password;
        this.type=type;

    }

    public int get_class() {
        return _class;
    }

    public void set_class(int _class) {
        this._class = _class;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserMsg{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", _class=" + _class +
                ", accountnumber='" + accountnumber + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
