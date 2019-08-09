package com.service;

import java.util.Map;

import com.entity.Member;

public interface MemberService {

	Map<String, Object> addMember(Member member);
	Map<String, Object> updateMember(Member member);
	Map<String, Object> deleteMember(int[] id);
	Map<String, Object> updateAccount(Member member);
	Map<String, Object> selectOne(int id);
	Map<String, Object> selectAll();
}
