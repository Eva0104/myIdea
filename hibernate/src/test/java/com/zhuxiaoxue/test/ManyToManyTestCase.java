package com.zhuxiaoxue.test;

import com.zhuxiaoxue.pojo.Student;
import com.zhuxiaoxue.pojo.Teacher;
import com.zhuxiaoxue.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class ManyToManyTestCase {

    @Test
    public void testSave(){

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Teacher teacher1 = new Teacher();
        teacher1.setTeaname("t1");

        Teacher teacher2 = new Teacher();
        teacher2.setTeaname("t2");

        Student student1 = new Student();
        student1.setStuname("s1");

        Student student2 = new Student();
        student2.setStuname("s2");

        Set<Teacher> teacherSet = new HashSet<Teacher>();
        teacherSet.add(teacher1);
        teacherSet.add(teacher2);

        student1.setTeacherSet(teacherSet);
        student2.setTeacherSet(teacherSet);

        session.save(student1);
        session.save(student2);
        session.save(teacher1);
        session.save(teacher2);

        session.getTransaction().commit();
    }

    @Test
    public void testFindTeacher(){

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Teacher teacher = (Teacher) session.get(Teacher.class,17);
        System.out.println(teacher.getTeaname());

        Set<Student> studentSet = teacher.getStudentSet();
        for(Student student : studentSet){
            System.out.println(student.getStuname());
        }
        session.getTransaction().commit();
    }
}
