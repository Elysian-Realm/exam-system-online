import com.onlinetest.Service.UserService;
import com.onlinetest.Service.subjectService;
import com.onlinetest.domainc.Subject;
import com.onlinetest.domainc.UserMsg;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class maintest {
    public static void main(String[] args) {
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);

        UserService userService= (UserService) ctx.getBean("userService");
        subjectService subjectService= (subjectService) ctx.getBean("subjectService");

/*        //添加学生
        UserMsg userMsg=new UserMsg(0,"kzy",2,"9282","12","学生");
        System.out.println(userMsg);
        int row= userService.addUserMsg(userMsg);
        System.out.println(row);*/


/*        //随机抽取试题
       List<Subject> subjects=subjectService.MakeTest("毛概",1);
        System.out.println(subjects);*/


/*        //查询试题
        Subject subject=subjectService.querySubject(25);
        System.out.println(subject);*/

/*        //查询所有学生
        List<UserMsg> userMsgs=userService.queryallstudent();
        System.out.println(userMsgs);*/

/*        //更改为教师type
        int rows=userService.changeLimit("928");
        System.out.println(rows);*/

/*        //通过账号查询
        UserMsg userMsg=userService.querybyacc("928");
        System.out.println(userMsg);*/

/*        List<Subject> subjects=subjectService.selectall();
        for(Subject s:subjects)
        {
            System.out.println(s);
        }*/

/*        //添加试题
        Subject subject=new Subject();
        subject.setAnswer("AD");
        subject.setMajor("sss");
        subject.setStem("123456stem");
        subject.setType("选择题");
        int rows=subjectService.addsubject(subject);
        System.out.println(rows);*/

/*
        //删除试题
        int rows=subjectService.deletesubjectbyid(3);
        System.out.println(rows);
*/

/*        //查询所有用户
        List<UserMsg> userMsgs=userService.queryalluser();
        System.out.println(userMsgs);*/

/*        //根据id修改试题信息
        int rows=subjectService.changeSubject(5,"计组","题干123abc","多选题","ACD");
        System.out.println(rows);*/

/*        List<Subject> subjects=subjectService.MakeTestbytype("计网","填空题",2);
        System.out.println(subjects);*/

/*            List<Subject> subjects=subjectService.MakeTest("计网",2);
            System.out.println(subjects);*/

/*        List<Subject> subjects=subjectService.selectall();
        System.out.println(subjects);*/

/*        List<Subject> sub=subjectService.SelectRand(3);
        System.out.println(sub);*/

//        int rows=userService.updatepassword("928783466","kzy123");
//        System.out.println(rows);
    }
}
