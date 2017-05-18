package com.homeedu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.homeedu.entity.test;

@Repository
public class TestUserDAO extends BaseDAO{

	/**
	 * ͨ���û���UserId�����û�������Ϊtestʵ��
	 * @author Arron
	 * @param id
	 * @return
	 */
	public test getTestById(String userId){
		//��ѯ���ֻ��һ�е�ʱ��
		ResultSetHandler<test> rsh=new BeanHandler<test>(test.class);
		test one=null;
		try{
				StringBuilder sqlBuilder=new StringBuilder();
			sqlBuilder.append("SELECT * FROM TEST WHERE USERID=?");

				one=getQueryRunner().query(sqlBuilder.toString(),rsh,userId);
				if(one==null){
					return null;
				}
				return one;
			}catch(SQLException e){
				return null;
			}
		}
	/**
	 * ��ɾ�Ĳ����ݿ����ģ�壬��������û�б����ã�����ֻ��дһ��ģ�塣
	 * 
	 * ��������������������SQL�ַ�����Сд�����⣬�����������ʹ�õ�ʱ��������⣬����ע��һ���ⷽ�档�����ڶ����û�н��в��ԡ������������Ҫ��
	 * ͬʱ��ʵ��������������ʱ���˳�򣡣���һ��Ҫ�����ݿ��е�˳��һģһ��������get��set�ĺ�����˳��ҲҪһ�£�������֮ǰ�ȵ�һ����ӡ�
	 * ������Կ�����test�����������˳��һ�������ݿ���е�˳��һ��������id��userid��name��password���Ⱥ󣬸����ݿⶨ��һ����
	 * 
	 */
	public void testUpdate(){
		
		//ͬʱ�޸Ķ��ֵ��ʱ���SQL�����������ؼ����������List��
		//Ȼ����ʾquery��ѯ���������list�У��ٵ�����listһ��һ��ִ��update����
		
		ResultSetHandler<List<test>> rsh = new BeanListHandler<test>(test.class);
		try {
			StringBuilder sqlBuilder=new StringBuilder();
			sqlBuilder.append("SELECT NAME"
					+ " FROM test WHERE UserId LIKE '");
			sqlBuilder.append("2014").append("'");
			List<test> list = getQueryRunner().query(sqlBuilder.toString(), rsh);//��ѯ����
			
			String newName="xiaoming";//��������Controller�д����Ĳ���
			String oldName="ming";
			for(int i=0;i<list.size();i++){
		    	try {
					getQueryRunner().update("UPDATE test SET name=? WHERE UserId=?", 
							new Object[]{newName,oldName});//��������
				} catch (SQLException e) {
					System.out.print(e);
				}
		    }
		} catch (SQLException e) {
			System.out.print(e);
	   }
	}
	//�������
		public void addCat() {
			Integer id=3;
			String userId="1111";
			String name="hello";
			String password="1234";
			try {
				getQueryRunner().update("INSERT INTO test "
						+ "(ID,USERID,NAME,PASSWORD) VALUES " +
						"(?,?,?,?)", 
						new Object[]{id,userId,name,password});
			} catch (SQLException e) {
				//
			}
		}
	/**
	 * ͨ��idɾ������
	 */
	public void deleteByUserId(Integer id){
		if(id!=null){
			try {
				getQueryRunner().update("DELETE FROM test WHERE ID=?",new Object[]{id});
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
