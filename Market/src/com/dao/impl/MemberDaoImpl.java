package com.dao.impl;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;

import com.dao.MemberDao;
import com.entity.Member;
import com.util.DBHelper;

public class MemberDaoImpl implements MemberDao{

	@Override
	public int addMember(Member member) throws Exception {
		//1.获得数据库连接对象
		Connection conn = DBHelper.getConn(true);
		//2.准备sql语句
		String sql = "insert into member(name, pass, score, account, phone,createDate) values(?,?,?,?,?,now())";
		//3.执行sql语句
		int result = new QueryRunner().update(conn, sql,//
				member.getName(),//
				member.getPass(),//
				member.getScore(),//
				member.getAccount(),//
				member.getPhone());//
		DBHelper.closeResources(conn);
		return result;
	}

	@Override
	public int updateMember(Member member) throws Exception {
		//1.获得数据库连接对象
		Connection conn = DBHelper.getConn(true);
		//2.准备sql语句
		String sql = "update member set name = ?, pass = ?, score = ?, account = ?, phone = ?, updateDate = now() where id = ?";
		//3.执行sql语句
		int result = new QueryRunner().update(conn,sql,//
				member.getName(),//
				member.getPass(),//
				member.getScore(),//
				member.getAccount(),//
				member.getPhone(),//
				member.getId());//
		DBHelper.closeResources(conn);
		return result;
	}

	@Override
	public int deleteMember(int id) throws Exception {
		/**
		 * return new QueryRunner().update(DBHelper.getConn(true),sql语句  )
		 *
		 */
		return new QueryRunner().update(DBHelper.getConn(true),
				"delete from member where id = " +id);
	}

	@Override
	public int updateAccount(Member member) throws Exception {
		//1.获得数据库连接对象
		Connection conn = DBHelper.getConn(true);
		//2.准备sql语句
		String sql = "update member set account = ?, updateDate = now() where id = ?";
		//3.执行sql语句
		int result = new QueryRunner().update(conn,sql,//
				member.getAccount(),//
				member.getId());//
		DBHelper.closeResources(conn);
		return result;
	}

	@Override
	public Member selectOne(int id) throws Exception {
		//1.获得数据库连接对象
		Connection conn = DBHelper.getConn(true);
		//2.准备sql语句
		String sql = "select * from member where id = ?";
		return new QueryRunner().query(conn, sql, new BeanHandler<>(Member.class), id);
	}

	@Override
	public List<Member> selectAll() throws Exception {
		Map<Objects, Map<String,Object>> map = new QueryRunner().query(DBHelper.getConn(true),
				"select * from member", new KeyedHandler<>());
		map.forEach((k,v)->{
			System.out.println("k:"+k+",v"+v);
		});
		return new QueryRunner().query(DBHelper.getConn(true), "select * from member", 
				new BeanListHandler<>(Member.class));
	}

}
