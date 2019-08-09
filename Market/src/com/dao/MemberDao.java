package com.dao;

import java.util.List;

import com.entity.Member;

public interface MemberDao {

	//add
	int addMember(Member member) throws Exception;
	//update
	int updateMember(Member member) throws Exception;
	//delete
	int deleteMember(int id) throws Exception;
	//update account
	int updateAccount(Member member) throws Exception;
	//select one
	Member selectOne(int id) throws Exception;
	//select All
	List<Member> selectAll() throws Exception;
}
