package com.infinite.test;

import com.infinite.entity.Student;
import com.infinite.util.HibernateUtil;
import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.jdbc.AbstractReturningWork;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.result.Output;
import org.hibernate.result.ResultSetOutput;


import javax.persistence.ParameterMode;
import java.sql.*;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {
      /*  Student student=new Student(1,"Pavan","Hyd");
        Session session= HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        Boolean flag=false;
        Integer id=null;
        try{
            id= (Integer) session.save(student);
           flag=true;
        } catch (Exception e){
            System.out.println(e);
        }finally {
            if(flag){
                System.out.println("Student Stored with id::"+id);
                tx.commit();
                HibernateUtil.closeSession(session);
                HibernateUtil.closeSessionFactory();
            } else{
                tx.rollback();
                System.out.println("Internal Problem");
            }
        }*/

        //System.out.println(checkCredentials("Pavan", "Pavan"));
        // System.out.println(getStudentsByName("Pav"));
        System.out.println(getWeekDay(new java.util.Date("2020/12/12")));

    }

    public static String checkCredentials(String username, String password) {
        Session ses = HibernateUtil.getSession();
        ProcedureCall call = ses.createStoredProcedureCall("AUTHENTICATE");
        call.registerParameter(1, String.class, ParameterMode.IN).bindValue(username);
        call.registerParameter(2, String.class, ParameterMode.IN).bindValue(password);
        call.registerParameter(3, Integer.class, ParameterMode.OUT);
        Integer retVal = ((Integer) call.getOutputParameterValue(3));
        return retVal > 0 ? "Valid Credentials" : "Invalid Credentials";
    }


    public static List<Student> getStudentsByName(String sname) {
        Session session = null;
        session = HibernateUtil.getSession();
        List<Student> list = null;
        Output output = null;
        ResultSetOutput resultSetOutput = null;
        ProcedureCall call = session.createStoredProcedureCall("GET_STUDENTS_BY_NAME", Student.class);
        call.registerParameter(1, String.class, ParameterMode.IN).bindValue(sname);
        call.registerParameter(2, Class.class, ParameterMode.REF_CURSOR);
        output = call.getOutputs().getCurrent();
        resultSetOutput = (ResultSetOutput) output;
        return resultSetOutput.getResultList();
    }


    public static String getWeekDay(java.util.Date date) throws SQLException {
        Session session = HibernateUtil.getSession();
        String weekDay = session.doReturningWork(new AbstractReturningWork<String>() {
            @Override
            public String execute(Connection connection) throws SQLException {
                CallableStatement callableStatement = connection.prepareCall("{?=call GET_WEEKDAY(?)}");
                callableStatement.registerOutParameter(1, Types.VARCHAR);
                callableStatement.setDate(2, new Date(date.getTime()));
                callableStatement.execute();
                return callableStatement.getString(1);
            }
        });
        return weekDay;
    }

}
