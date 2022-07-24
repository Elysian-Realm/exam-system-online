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

/*        //���ѧ��
        UserMsg userMsg=new UserMsg(0,"kzy",2,"9282","12","ѧ��");
        System.out.println(userMsg);
        int row= userService.addUserMsg(userMsg);
        System.out.println(row);*/


/*        //�����ȡ����
       List<Subject> subjects=subjectService.MakeTest("ë��",1);
        System.out.println(subjects);*/


/*        //��ѯ����
        Subject subject=subjectService.querySubject(25);
        System.out.println(subject);*/

/*        //��ѯ����ѧ��
        List<UserMsg> userMsgs=userService.queryallstudent();
        System.out.println(userMsgs);*/

/*        //����Ϊ��ʦtype
        int rows=userService.changeLimit("928");
        System.out.println(rows);*/

/*        //ͨ���˺Ų�ѯ
        UserMsg userMsg=userService.querybyacc("928");
        System.out.println(userMsg);*/

/*        List<Subject> subjects=subjectService.selectall();
        for(Subject s:subjects)
        {
            System.out.println(s);
        }*/

/*        //�������
        Subject subject=new Subject();
        subject.setAnswer("AD");
        subject.setMajor("sss");
        subject.setStem("123456stem");
        subject.setType("ѡ����");
        int rows=subjectService.addsubject(subject);
        System.out.println(rows);*/

/*
        //ɾ������
        int rows=subjectService.deletesubjectbyid(3);
        System.out.println(rows);
*/

/*        //��ѯ�����û�
        List<UserMsg> userMsgs=userService.queryalluser();
        System.out.println(userMsgs);*/

/*        //����id�޸�������Ϣ
        int rows=subjectService.changeSubject(5,"����","���123abc","��ѡ��","ACD");
        System.out.println(rows);*/

/*        List<Subject> subjects=subjectService.MakeTestbytype("����","�����",2);
        System.out.println(subjects);*/

/*            List<Subject> subjects=subjectService.MakeTest("����",2);
            System.out.println(subjects);*/

/*        List<Subject> subjects=subjectService.selectall();
        System.out.println(subjects);*/

/*        List<Subject> sub=subjectService.SelectRand(3);
        System.out.println(sub);*/

//        int rows=userService.updatepassword("928783466","kzy123");
//        System.out.println(rows);
    }
}
