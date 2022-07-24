package com.onlinetest.Service;

import com.onlinetest.domainc.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface subjectService {

    int addsubject(Subject subject);

    Subject querySubject(int id);

    int deletesubjectbyid(int id);

    int changeSubject(int id,String major, String stem, String type, String answer);

    List<Subject> MakeTest(String major,int num);

    List<Subject> selectall();

    List<Subject> MakeTestbytype(String major,String type,int num);

    List<Subject> SelectRand(int num);



}
