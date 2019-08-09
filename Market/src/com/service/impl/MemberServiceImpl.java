package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.dao.MemberDao;
import com.dao.impl.MemberDaoImpl;
import com.entity.Member;
import com.service.MemberService;

public class MemberServiceImpl implements MemberService{

	private MemberDao memberDao;
	
	@Override
	public Map<String, Object> addMember(Member member) {
		
		Objects.requireNonNull(member);
		memberDao = new MemberDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			int id = memberDao.addMember(member);
			if (id == 0) {
				map.put("code", 500);
				map.put("msg", "添加失败！");
				return map;
			}
			map.put("code", 500);
			map.put("msg", "添加成功！");
			map.put("data", id);
			return map;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Map<String, Object> updateMember(Member member) {
		Objects.requireNonNull(member);
		memberDao = new MemberDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (memberDao.updateMember(member) == 0) {
				map.put("code", 500);
				map.put("msg", "修改失败！");
				return map;
			}
			map.put("code", 200);
			map.put("msg", "修改成功！");
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<String, Object> deleteMember(int[] id) {
		Objects.requireNonNull(id);
		memberDao = new MemberDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		if(id.length == 0) {
			map.put("msg", "没有要删除的内容");
			return map;
		}
		try {
			for (int ids : id) {
				memberDao.deleteMember(ids);
			}
			map.put("code", 200);
			map.put("msg", "删除成功");
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<String, Object> updateAccount(Member member) {
		Objects.requireNonNull(member);
		memberDao = new MemberDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (memberDao.updateAccount(member) == 0) {
				map.put("code", 500);
				map.put("msg", "修改失败！");
				return map;
			}
			map.put("code", 200);
			map.put("msg", "修改成功！");
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<String, Object> selectOne(int id) {
		memberDao = new MemberDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Member member = memberDao.selectOne(id);
			if (member == null) {
				map.put("code", 500);
				map.put("msg", "查询失败！");
				return map;
			}
			map.put("code", 200);
			map.put("msg", "查询成功！");
			map.put("data", member);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<String, Object> selectAll() {
		memberDao = new MemberDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Member> memberList = memberDao.selectAll();
			
			if (memberList.size() == 0) {
				map.put("code", 500);
				map.put("msg", "没有找到合适的数据！");
				return map;
			}
			map.put("code", 200);
			map.put("msg", "查询成功！");
			map.put("data", memberList);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
