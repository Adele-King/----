package com.dao.impl;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;

import com.dao.TypeDao;
import com.entity.Type;
import com.util.DBHelper;

public class TypeDaoImpl implements TypeDao {
	@Override
	public int addType(Type type) throws Exception {
		// 1.获得数据库连接对象
		Connection conn = DBHelper.getConn(true);
		//2.准备sql
		String sql = "insert into type (name,father_id,sign,createDate) values (?,?,?,now())";
		//3.执行sql语句
		int result = new QueryRunner().update(conn,sql,//
				type.getName(),//
				type.getFather_id(),//
				type.getSign());//
		DBHelper.closeResources(conn);
		return result;
	}

	@Override
	public int updateType(Type type) throws Exception {
		// 1.获得数据库连接对象
		Connection conn = DBHelper.getConn(true);
		//2.准备sql
		String sql = "update type set name = ?, father_id = ?, sign = ?, updateDate = now() where id = ?";
		//3.执行sql语句
		int result = new QueryRunner().update(conn, sql,//
				type.getName(),//
				type.getFather_id(),//
				type.getSign(),
				type.getId());//
		DBHelper.closeResources(conn);
		return result;
	}

	@Override
	public int deleteType(int id) throws Exception {
	
		return new QueryRunner().update(DBHelper.getConn(true),//
				"delete from type where id =7");///////////
	}

	@Override
	public Type selectOne(int id) throws Exception {
		// 1.获得数据库连接对象
		Connection conn = DBHelper.getConn(true);
		//2.准备sql
		String sql = "select * from type where id = ?";
	
		return new QueryRunner().query(conn, sql, new BeanHandler<>(Type.class), id);
	}
	
	
	@Override
	public List<Type> selectAll() throws Exception {
		Map<Object, Map<String, Object>> map = new QueryRunner().query(DBHelper.getConn(true), 
				"select * from type", new KeyedHandler<>());
		map.forEach((k,v)->{
			System.out.println("k:"+k+",v:"+v);
		});
		return new QueryRunner().query(DBHelper.getConn(true), "select * from type",
				new BeanListHandler<>(Type.class));
	}

	@Override
	public List<Type> selectAllChild(int sign, int father_id) throws Exception {
		Map<Object, Map<String, Object>> map = new QueryRunner().query(DBHelper.getConn(true), 
				"select t.id,t.name from type t, type y where t.sign = 0 and y.id = t.father_id", new KeyedHandler<>());
		map.forEach((k,v)->{
			System.out.println("k:"+k+",v:"+v);
		});
		return new QueryRunner().query(DBHelper.getConn(true), "select t.id,t.name from type t, type y where t.sign = 0 and y.id = t.father_id",
				new BeanListHandler<>(Type.class));
	}

	@Override
	public List<Type> selectAllParent(int sign) throws Exception {
		Map<Object, Map<String, Object>> map = new QueryRunner().query(DBHelper.getConn(true), 
				"select id,name from type where sign = 1", new KeyedHandler<>());
		map.forEach((k,v)->{
			System.out.println("k:"+k+",v:"+v);
		});
		return new QueryRunner().query(DBHelper.getConn(true), "select id,name from type where sign = 1",
				new BeanListHandler<>(Type.class));
	}

}
