package com.onlinetest.Service.impl;

import com.onlinetest.Dao.subjectDao;
import com.onlinetest.Service.subjectService;
import com.onlinetest.domainc.Subject;

import java.util.List;

public class subjectServiceImpl implements subjectService {
    subjectDao subjectDao;

    public void setSubjectDao(com.onlinetest.Dao.subjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    @Override
    public int addsubject(Subject subject) {
        int rows;
        rows= subjectDao.insertsubject(subject);
        return rows;
    }

    @Override
    public Subject querySubject(int id) {
        Subject subject=subjectDao.selectbyid(id);
        return subject;
    }

    @Override
    public int deletesubjectbyid(int id)
    {
        int rows=0;
        Subject subject=subjectDao.selectbyid(id);
        if(subject!=null)
        {
            rows = subjectDao.deletesubjectbyid(id);

        }
        return rows;
    }

    @Override
    public List<Subject> MakeTest(String major,int num) {
        List<Subject> subjects=subjectDao.selectbyrandom(major,num);

        return subjects;
    }

    @Override
    public List<Subject> selectall() {
        List<Subject> subjects=subjectDao.selectall();
        return subjects;
    }

    @Override
    public int changeSubject(int id, String major, String stem, String type, String answer) {
        int rows= subjectDao.updateSubjectbyid(id,major,stem,type,answer);
        return rows;
    }

    @Override
    public List<Subject> MakeTestbytype(String major, String type, int num) {
        List<Subject> subjects=subjectDao.selectbyrandom_type(major, type, num);
        return subjects;
    }

    @Override
    public List<Subject> SelectRand(int num) {
        List<Subject> subjects=subjectDao.selectbyrandombynum(num);
        return subjects;
    }
}
