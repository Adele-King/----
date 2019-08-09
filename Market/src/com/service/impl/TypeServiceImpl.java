package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.dao.TypeDao;
import com.dao.impl.TypeDaoImpl;
import com.entity.Type;
import com.service.TypeService;

public class TypeServiceImpl implements TypeService{

	private TypeDao typeDao;
	
	@Override
	public Map<String, Object> addType(Type type) {
		
		Objects.requireNonNull(type);
		typeDao = new TypeDaoImpl();
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			int id = typeDao.addType(type);
			if (id == 0) {
				map.put("code", 500);
				map.put("msg", "����ʧ��");
				return map;
			}
			map.put("code", 200);
			map.put("msg", "�����ɹ�");
			map.put("data", id);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Map<String, Object> updatetype(Type type) {
		Objects.requireNonNull(type);
		typeDao = new TypeDaoImpl();
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			if (typeDao.updateType(type) == 0) {
				map.put("code", 500);
				map.put("msg", "�޸�ʧ��");
				return map;
			}
			map.put("code", 200);
			map.put("msg", "�޸ĳɹ�");
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<String, Object> deleteType(int[] id) {
		Objects.requireNonNull(id);
		typeDao = new TypeDaoImpl();
		Map<String,Object> map = new HashMap<String,Object>();
		if (id.length == 0) {
			map.put("msg", "û��ɾ��������");
			return map;
		}
		
		try {
			for (int ids : id) {
				typeDao.deleteType(ids);
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
	public Map<String, Object> selectOne(int id) {
		typeDao = new TypeDaoImpl();
		Map<String,Object> map = new HashMap<String,Object>();
		
		try {
			Type type = typeDao.selectOne(id);
			if (type == null) {
				map.put("code",500);
				map.put("msg", "��ѯʧ��");
				return map;
			}
			map.put("code", 200);
			map.put("msg", "��ѯ�ɹ�");
			map.put("data", type);
			return map;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Map<String, Object> selectAll() {
		typeDao = new TypeDaoImpl();
		Map<String,Object> map = new HashMap<String,Object>();
		
		try {
			List<Type> typeList = typeDao.selectAll();
			if (typeList.size() == 0) {
				map.put("code", 500);
				map.put("meg", "û���ҵ����ʵ�����");
				return map;
			}
			map.put("code", 200);
			map.put("msg", "��ѯ�ɹ�");
			map.put("data", typeList);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<String, Object> selectAllParent(int sign) {
		typeDao = new TypeDaoImpl();
		Map<String,Object> map = new HashMap<String,Object>();
		
		try {
			List<Type> type = typeDao.selectAllParent(sign);
			if (type == null) {
				map.put("code",500);
				map.put("msg", "��ѯʧ��");
				return map;
			}
			map.put("code", 200);
			map.put("msg", "��ѯ�ɹ�");
			map.put("data", type);
			return map;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Map<String, Object> selectAllChild(int sign, int father_id) {
		typeDao = new TypeDaoImpl();
		Map<String,Object> map = new HashMap<String,Object>();
		
		try {
			List<Type> type = typeDao.selectAllChild(sign,father_id);
			if (type == null) {
				map.put("code",500);
				map.put("msg", "��ѯʧ��");
				return map;
			}
			map.put("code", 200);
			map.put("msg", "��ѯ�ɹ�");
			map.put("data", type);
			return map;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
