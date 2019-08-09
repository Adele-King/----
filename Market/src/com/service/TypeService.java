package com.service;

import java.util.Map;

import com.entity.Type;

public interface TypeService {

	Map<String,Object> addType(Type type);
	Map<String,Object> updatetype(Type type);
	Map<String,Object> deleteType(int[] id);
	Map<String,Object> selectOne(int id);
	
	Map<String,Object> selectAllParent(int sign);
	Map<String,Object> selectAllChild(int sign, int father_id);
	
	Map<String,Object> selectAll();
}
