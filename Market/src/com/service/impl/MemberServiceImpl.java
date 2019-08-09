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
				map.put("msg", "���ʧ�ܣ�");
				return map;
			}
			map.put("code", 500);
			map.put("msg", "��ӳɹ���");
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
				map.put("msg", "�޸�ʧ�ܣ�");
				return map;
			}
			map.put("code", 200);
			map.put("msg", "�޸ĳɹ���");
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
			map.put("msg", "û��Ҫɾ��������");
			return map;
		}
		try {
			for (int ids : id) {
				memberDao.deleteMember(ids);
			}
			map.put("code", 200);
			map.put("msg", "ɾ���ɹ�");
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
				map.put("msg", "�޸�ʧ�ܣ�");
				return map;
			}
			map.put("code", 200);
			map.put("msg", "�޸ĳɹ���");
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
				map.put("msg", "��ѯʧ�ܣ�");
				return map;
			}
			map.put("code", 200);
			map.put("msg", "��ѯ�ɹ���");
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
				map.put("msg", "û���ҵ����ʵ����ݣ�");
				return map;
			}
			map.put("code", 200);
			map.put("msg", "��ѯ�ɹ���");
			map.put("data", memberList);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
