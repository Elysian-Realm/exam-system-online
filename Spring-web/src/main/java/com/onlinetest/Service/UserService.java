package com.onlinetest.Service;

import com.onlinetest.domainc.UserMsg;

import java.util.List;

public interface UserService {

    int addUserMsg(UserMsg userMsg);

    UserMsg findUserMsg(String accountnumber,String password);

    int deleteUserMsg(int id);

    UserMsg querybyacc(String accountnumber);

    List<UserMsg> queryallstudent();

    List<UserMsg> queryalluser();

    int changeLimit(String accountnumber,String type);

    int updateMsg(String accountnumber,String name,int _class);

    int updatepassword(String accountnumber,String password);

}
