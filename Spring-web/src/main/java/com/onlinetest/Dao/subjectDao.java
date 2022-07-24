package com.onlinetest.Dao;

import com.onlinetest.domainc.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface subjectDao {
    int insertsubject(Subject subject);     //��������
    int deletesubjectbyid(int id);              //ͨ��idɾ������
    Subject selectbyid(int id);                 //ͨ��id��ѯ����
    List<Subject> selectbyrandom(@Param("major") String major,@Param("num")int num);  //�����ȡ����

    List<Subject> selectbyrandombynum(@Param("num")int num);  //�����ȡ����

    List<Subject> selectbyrandom_type(@Param("major") String major,@Param("type")String type,@Param("num")int num);  //�����ȡ����,ָ������

    int updateSubjectbyid(@Param("id")int id,@Param("major")String major,@Param("stem")String stem,@Param("type")String type,@Param("answer")String answer);
    //ceshi
    List<Subject> selectall();
}
