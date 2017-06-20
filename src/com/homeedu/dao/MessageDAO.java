package com.homeedu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.stereotype.Service;

import com.homeedu.entity.Message;
import com.homeedu.entity.Teacher;

@Service
public class MessageDAO extends BaseDAO{

	/**
	 * 获取首页展示需要的8条最新发布信息
	 * @return
	 */
	public List<Message> getIndexShowMessages(){
		ResultSetHandler<List<Message>> rsh = new BeanListHandler<Message>(Message.class);
		StringBuilder sqlBuilder=new StringBuilder();
		sqlBuilder.append("SELECT * "
				+ " FROM message ORDER BY created_at desc");
		List<Message> result = new ArrayList<>();
		try {
			result = getQueryRunner().query(sqlBuilder.toString(), rsh);
			//System.out.print(result.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		List<Message> list = new ArrayList<>();
		//提取8个展示最新的消息
			for(int i=0;i<8;i++){
				list.add(result.get(i));
			}
	return list;
	}
	/**
	 * 在学员页面展示所有的发布信息
	 * @return
	 */
	public List<Message> getAllShowMessages(){
		ResultSetHandler<List<Message>> rsh = new BeanListHandler<Message>(Message.class);
		StringBuilder sqlBuilder=new StringBuilder();
		sqlBuilder.append("SELECT * "
				+ " FROM message ORDER BY created_at desc");
		List<Message> result = new ArrayList<>();
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
	
	public Message getMessageById(String id){
		ResultSetHandler<Message> rsh=new BeanHandler<Message>(Message.class);
		Message dbMessage;
		try{
				StringBuilder sqlBuilder=new StringBuilder();
			sqlBuilder.append("SELECT * FROM message WHERE id=?");

				dbMessage=getQueryRunner().query(sqlBuilder.toString(),rsh,id);		
				if(dbMessage==null){
					return null;
				}
				return dbMessage;
			}catch(SQLException e){
				System.out.println(e);
				return null;
			}
	}
	
	
	/**
	 * 新发布招聘信息
	 * @param msg
	 * @return
	 */
	public boolean addNewMessage(Message msg){
		msg.setId(getmaxId()+1);
		try {
			getQueryRunner().update("INSERT INTO message "
					+ "(id,surname,course1,course2,course3,student_gender,student_grade,student_status"
					+ ",teach_gender,teach_location,teach_time,salary,teach_request,created_at) VALUES " +
					"(?,?,?,?,?,?,?,?,?,?,?,?,?,?)", 
					msg.getId(),msg.getSurname(),msg.getCourse1(),msg.getCourse2(),msg.getCourse3(),
					msg.getStudent_gender(),msg.getStudent_grade(),msg.getStudent_status(),msg.getTeach_gender(),
					msg.getTeach_location(),msg.getTeach_time(),msg.getSalary(),msg.getTeach_request(),msg.getCreated_at());
			return true;
		} catch (SQLException e) {	
			System.out.println(e);
			return false;
		}
	}
	//获取列表最大id
	public Integer getmaxId(){
		Integer maxid;
		try{
			maxid=getQueryRunner().query("SELECT max(id) FROM message", new ScalarHandler<Integer>());
			if(maxid!=null){
				System.out.println("当前maxid为："+maxid+",新插入id为:"+(maxid+1));
				return maxid;
			}
			else{
				return 0;
			}
		}catch(SQLException e){
			System.out.println(e);
			return -1;
		}
	    }
}
