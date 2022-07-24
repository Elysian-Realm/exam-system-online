package com.onlinetest.Service.impl;

import com.onlinetest.Dao.UserMsgDao;
import com.onlinetest.Service.UserService;
import com.onlinetest.domainc.UserMsg;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserMsgDao userMsgDao;

    public void setUserMsgDao(UserMsgDao userMsgDao) {
        this.userMsgDao = userMsgDao;
    }


    @Override
    public int addUserMsg(UserMsg userMsg) {
        int rows=userMsgDao.InsertIntoUserMsg(userMsg);
        return rows;
    }

    @Override
    public UserMsg findUserMsg(String accountnumber, String password)
    {
        UserMsg userMsg=userMsgDao.SelectByAccAndPswd(accountnumber,password);
        return userMsg;
    }

    @Override
    public int deleteUserMsg(int id) {
        int rows=userMsgDao.deletebyid(id);
        return rows;
    }

    @Override
    public List<UserMsg> queryallstudent() {
        List<UserMsg> userMsgs=userMsgDao.selectallstudent();
        return userMsgs;
    }

    @Override
    public int changeLimit(String accountnumber,String type) {
        int rows=userMsgDao.updateTypebyacc(accountnumber,type);
        return rows;
    }

    @Override
    public UserMsg querybyacc(String accountnumber) {
        UserMsg userMsg=userMsgDao.selectbyacc(accountnumber);
        return userMsg;
    }

    @Override
    public List<UserMsg> queryalluser() {
        List<UserMsg> userMsgs=userMsgDao.selectalluser();
        return userMsgs;
    }

    @Override
    public int updateMsg(String accountnumber, String name, int _class) {
        int rows=userMsgDao.updatenameandclassbyacc(accountnumber, name, _class);
        return rows;
    }

    @Override
    public int updatepassword(String accountnumber, String password) {
        int rows=userMsgDao.updatepasswordbyacc(accountnumber, password);
        return rows;
    }
}
