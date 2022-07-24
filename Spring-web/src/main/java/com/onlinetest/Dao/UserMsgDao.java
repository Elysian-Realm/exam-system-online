package com.onlinetest.Dao;

import com.onlinetest.domainc.UserMsg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMsgDao {

    int InsertIntoUserMsg(UserMsg userMsg);

    UserMsg SelectByAccAndPswd(@Param("accountnumber") String accountnumber, @Param("password") String password);
    int deletebyid(int id);

    UserMsg selectbyacc(String accountnumber);
    List<UserMsg> selectallstudent();

    List<UserMsg> selectalluser();
    int updateTypebyacc(@Param("accountnumber") String accountnumber,@Param("type")String type);

    int updatepasswordbyacc(@Param("accountnumber") String accountnumber,@Param("password")String password);
    int updatenameandclassbyacc(@Param("accountnumber") String accountnumber,@Param("name")String name, @Param("_class")int _class);

}
