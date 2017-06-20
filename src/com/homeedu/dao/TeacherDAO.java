package com.homeedu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Service;

import com.homeedu.entity.Message;
import com.homeedu.entity.Teacher;
import com.homeedu.entity.test;


@Service
public class TeacherDAO extends BaseDAO{

	/**
	 * 主页显示的teacher
	 * @return
	 */
	public List<Teacher> getIndexShowTeachers(){
		ResultSetHandler<List<Teacher>> rsh = new BeanListHandler<Teacher>(Teacher.class);
		StringBuilder sqlBuilder=new StringBuilder();
		sqlBuilder.append("SELECT * "
				+ " FROM teacher ORDER BY created_at desc");
		List<Teacher> result = new ArrayList<>();
		try {
			result = getQueryRunner().query(sqlBuilder.toString(), rsh);
			//System.out.print(result.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	return result;
	}
	
	 /**
	  * @author wang
	  * @param tea
	  * @return
	  */
	public boolean addNewTeacher(Teacher newTea){
		
		//add a new teacher
		try {
			getQueryRunner().update("INSERT INTO teacher "
					+ "(id,name,password,gender,birth_year,birth_month,sno,telephone,school,major,GPA,portrait,introduction,level,course1,course2,course3,course4,course5,location,teach_time,ordernum,created_at,updated_at) VALUES " +
					"(?,?,?,?,?,?,?,?,?,?,"
					+"?,?,?,?,?,?,?,?,?,?,"
					+"?,?,?,?)", 
					newTea.getId(),newTea.getName(),newTea.getPassword(),newTea.getGender(),
					newTea.getBirth_year(),newTea.getBirth_month(),newTea.getSno(),newTea.getTelephone(),newTea.getSchool(),newTea.getMajor(),newTea.getGPA(),newTea.getPortrait(),
					newTea.getIntroduction(),newTea.getLevel(),newTea.getCourse1(),newTea.getCourse2(),newTea.getCourse3(),newTea.getCourse4(),newTea.getCourse5(),newTea.getLocation(),newTea.getTeach_time(),
					newTea.getOrdernum(),newTea.getCreated_at(),newTea.getUpdated_at());
			return true;
		} catch (SQLException e) {
			
			System.out.println(e);
			return false;
		}
	}
	/**
	 * 注册用，看id是否已存在
	 * @param id
	 * @return
	 */
	public boolean isIdExits(String id){
		ResultSetHandler<Teacher> rsh=new BeanHandler<Teacher>(Teacher.class);
		Teacher dbTeacher=null;
		try{
				StringBuilder sqlBuilder=new StringBuilder();
			sqlBuilder.append("SELECT * FROM teacher WHERE id=?");

				dbTeacher=getQueryRunner().query(sqlBuilder.toString(),rsh,id);		
				if(dbTeacher==null){
					return false;
				}
				return true;
			}catch(SQLException e){
				System.out.println(e);
				return false;
			}
	}
	
	public Teacher getTeacherById(String id){
		ResultSetHandler<Teacher> rsh=new BeanHandler<Teacher>(Teacher.class);
		Teacher dbTeacher=null;
		try{
				StringBuilder sqlBuilder=new StringBuilder();
			sqlBuilder.append("SELECT * FROM teacher WHERE id=?");

				dbTeacher=getQueryRunner().query(sqlBuilder.toString(),rsh,id);		
				if(dbTeacher==null){
					return null;
				}
				return dbTeacher;
			}catch(SQLException e){
				System.out.println(e);
				return null;
			}
	}
	
}
