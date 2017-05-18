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
	 * 通过用户名UserId查找用户，这里为test实体
	 * @author Arron
	 * @param id
	 * @return
	 */
	public test getTestById(String userId){
		//查询结果只有一行的时候
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
	 * 增删改查数据库操作模板，但函数并没有被调用，这里只是写一下模板。
	 * 
	 * ！！！！！！！！关于SQL字符串大小写的问题，大家若是在是使用的时候除了问题，可以注意一下这方面。我现在对这个没有进行测试。但是这个很重要。
	 * 同时！实体类在声明定义时候的顺序！！！一定要和数据库列的顺序一模一样，设置get，set的函数的顺序也要一致，这是我之前踩得一个大坑。
	 * 具体可以看看我test类的声明定义顺序，一定和数据库的列的顺序一样。比如id，userid，name，password的先后，跟数据库定义一样。
	 * 
	 */
	public void testUpdate(){
		
		//同时修改多个值的时候的SQL操作案例，关键在于下面的List。
		//然后显示query查询出结果放入list中，再单独对list一个一个执行update函数
		
		ResultSetHandler<List<test>> rsh = new BeanListHandler<test>(test.class);
		try {
			StringBuilder sqlBuilder=new StringBuilder();
			sqlBuilder.append("SELECT NAME"
					+ " FROM test WHERE UserId LIKE '");
			sqlBuilder.append("2014").append("'");
			List<test> list = getQueryRunner().query(sqlBuilder.toString(), rsh);//查询样例
			
			String newName="xiaoming";//假如这是Controller中传来的参数
			String oldName="ming";
			for(int i=0;i<list.size();i++){
		    	try {
					getQueryRunner().update("UPDATE test SET name=? WHERE UserId=?", 
							new Object[]{newName,oldName});//更新样例
				} catch (SQLException e) {
					System.out.print(e);
				}
		    }
		} catch (SQLException e) {
			System.out.print(e);
	   }
	}
	//添加样例
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
	 * 通过id删除案例
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
