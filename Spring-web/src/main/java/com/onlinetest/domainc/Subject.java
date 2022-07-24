package com.onlinetest.domainc;

public class Subject {      //试题类

    int id;
    String major;//专业方向，
    String stem;//题干
    String type;//试题类型

    String answer;//答案

    public Subject(){};
    public Subject(int id, String major, String stem, String type, String answer) {
        this.id = id;
        this.major = major;
        this.stem = stem;
        this.type = type;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getStem() {
        return stem;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", major='" + major + '\'' +
                ", stem='" + stem + '\'' +
                ", type='" + type + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}

