package com.dao;

import java.util.List;

import com.entity.Type;


public interface TypeDao {

	//add
	int addType(Type type) throws Exception; 
	//update
	int updateType(Type type) throws Exception;
	//delete
	int deleteType(int id) throws Exception;
	//select one
	Type selectOne(int id) throws Exception;
	//select Parent
	List<Type> selectAllParent(int sign) throws Exception;
	//select Child
	List<Type> selectAllChild(int sign,int father_id) throws Exception;
	//select All
	List<Type> selectAll() throws Exception;
}
