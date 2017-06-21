package com.homeedu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.stereotype.Service;

import com.homeedu.entity.Teacher;



@Service
public class TeacherDAO extends BaseDAO{

	
	public boolean updatePartOfTeacher(Teacher ter){
		try {
			getQueryRunner().update("UPDATE teacher SET school=?,major=?,gpa=?"
					+ ",introduction=?,course1=? WHERE id=?", 
					new Object[]{ter.getSchool(),ter.getMajor(),ter.getGPA()
							,ter.getIntroduction(),ter.getCourse1(),ter.getId()});
			
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	/**
	 * 获取教员预约的id
	 * @param teacherId
	 * @return
	 */
	public List<Integer> getBookId(String teacherId){
		List<Integer> list=new ArrayList<Integer>();
		Integer id1=0,id2=0,id3=0;
		try{
			id1=getQueryRunner().query("SELECT bookMessage1 FROM teacher WHERE id=?", new ScalarHandler<Integer>(),teacherId);
			if(id1!=null){
				System.out.print(id1);

			}
			id2=getQueryRunner().query("SELECT bookMessage2 FROM teacher WHERE id=?", new ScalarHandler<Integer>(),teacherId);
			if(id2!=null){
				System.out.print(id1);
				
			}
			id3=getQueryRunner().query("SELECT bookMessage3 FROM teacher WHERE id=?", new ScalarHandler<Integer>(),teacherId);
			if(id3!=null){
				System.out.print(id1);
				
			}			
			list.add(id1);list.add(id2);list.add(id3);
		}catch(SQLException e){
			System.out.println(e);
			return null;
		}
		return list;
		
	
	}
	
	/**
	 * 更新教员的预约
	 * @param msgId
	 * @return
	 */
	public boolean updateTeacherBook(Integer msgId){
		try {
			getQueryRunner().update("update teacher SET bookMessage1=null WHERE bookMessage1=?", 
					new Object[]{msgId });
			getQueryRunner().update("update teacher SET bookMessage2=null WHERE bookMessage2=? ", 
					new Object[]{msgId });
			getQueryRunner().update("update teacher SET bookMessage3=null WHERE bookMessage3=?", 
					new Object[]{msgId });
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	
	 /**
	  * 更新教员的预约项，通过传来的具体位置
	  * @param msgId
	  * @param teacherId
	  * @return
	  */
	public boolean updateTeacherBooking1Id(Integer msgId,String teacherId){
		try {
			getQueryRunner().update("UPDATE teacher SET bookMessage1=? WHERE id=?", 
					new Object[]{msgId ,teacherId});
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	public boolean updateTeacherBooking2Id(Integer msgId,String teacherId){
		try {
			getQueryRunner().update("UPDATE teacher SET bookMessage2=? WHERE id=?", 
					new Object[]{msgId ,teacherId});
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	public boolean updateTeacherBooking3Id(Integer msgId,String teacherId){
		try {
			getQueryRunner().update("UPDATE teacher SET bookMessage3=? WHERE id=?", 
					new Object[]{msgId ,teacherId});
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	
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
					+ "(id,name,password,gender,birth_year,birth_month,sno,telephone,school,major,GPA,portrait,introduction,level,course1,course2,course3,course4,course5,location,"
					+ "teach_time,ordernum,created_at,updated_at,teach_type) VALUES " +
					"(?,?,?,?,?,?,?,?,?,?,"
					+"?,?,?,?,?,?,?,?,?,?,"
					+"?,?,?,?,?)", 
					newTea.getId(),newTea.getName(),newTea.getPassword(),newTea.getGender(),
					newTea.getBirth_year(),newTea.getBirth_month(),newTea.getSno(),newTea.getTelephone(),newTea.getSchool(),newTea.getMajor(),newTea.getGPA(),newTea.getPortrait(),
					newTea.getIntroduction(),newTea.getLevel(),newTea.getCourse1(),newTea.getCourse2(),newTea.getCourse3(),newTea.getCourse4(),newTea.getCourse5(),newTea.getLocation(),newTea.getTeach_time(),
					newTea.getOrdernum(),newTea.getCreated_at(),newTea.getUpdated_at(),newTea.getTeach_type());
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
