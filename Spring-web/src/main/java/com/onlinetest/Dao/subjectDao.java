package com.onlinetest.Dao;

import com.onlinetest.domainc.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface subjectDao {
    int insertsubject(Subject subject);     //插入试题
    int deletesubjectbyid(int id);              //通过id删除试题
    Subject selectbyid(int id);                 //通过id查询试题
    List<Subject> selectbyrandom(@Param("major") String major,@Param("num")int num);  //随机抽取试题

    List<Subject> selectbyrandombynum(@Param("num")int num);  //随机抽取试题

    List<Subject> selectbyrandom_type(@Param("major") String major,@Param("type")String type,@Param("num")int num);  //随机抽取试题,指定题型

    int updateSubjectbyid(@Param("id")int id,@Param("major")String major,@Param("stem")String stem,@Param("type")String type,@Param("answer")String answer);
    //ceshi
    List<Subject> selectall();
}
