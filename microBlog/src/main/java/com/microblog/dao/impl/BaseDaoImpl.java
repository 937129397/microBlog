package com.microblog.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.microblog.dao.BaseDao;


@Repository(value="baseDaoImpl")
public class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T> {
	
	private final String MAPPERPATH="com.yc.dao.mapper.";
	
	public void save(T t, String sqlId) {
		//                           com.yc.dao.mapper.AccountMapper.update
		super.getSqlSession().insert(  MAPPERPATH+  t.getClass().getSimpleName() + "Mapper." + sqlId, t);
	}

	public T find(T t, String sqlId) {
		t = super.getSqlSession().selectOne(
				 MAPPERPATH+  t.getClass().getSimpleName() + "Mapper." + sqlId, t);
		return t;
	}

	public List<T> findList(Class<T> t, Map<String, Object> map,
			String sqlId, int offset, int sizePage) {
		List<T> ts = null;
		ts = super.getSqlSession().selectList( MAPPERPATH+  t.getSimpleName() + "Mapper." + sqlId,
				map, new RowBounds(offset, sizePage));

		return ts;
	}

	public int getCount(Class<T> t, String sqlId) {
		int count = 0;
		count = super.getSqlSession().selectOne( MAPPERPATH+  t.getSimpleName() + "Mapper." + sqlId);
		return count;
	}

	public List<T> findAll(Class<T> t, String sqlId) {
		List<T> ts = null;
		ts = super.getSqlSession().selectList( MAPPERPATH+  t.getSimpleName() + "Mapper." + sqlId);
		return ts;
	}

	public void update(T t, String sqlId) {
		super.getSqlSession().insert( MAPPERPATH+  t.getClass().getSimpleName()+ "Mapper." + sqlId, t);
	}

	public int getCount(Class<T> t, Map<String, Object> map, String sqlId) {
		int count = 0;
		count = super.getSqlSession().selectOne( MAPPERPATH+  t.getSimpleName() + "Mapper." + sqlId,
				map);
		return count;
	}

	public void del(Class<T> t, int id, String sqlId) {
		super.getSqlSession().delete( MAPPERPATH+  t.getSimpleName() + "Mapper." + sqlId, id);
	}
	
	//重写了父类  SqlSessionDaoSupport 方法实现注入   sqlSessionTemplate
	//为什么要重写?   如果不重写的话，则需要  xml配置spring
	@Resource(name="sqlSession")
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	public void del(Class<T> t, List<Integer> ids, String sqlId) {
		super.getSqlSession().delete( MAPPERPATH+  t.getSimpleName() + "Mapper." + sqlId, ids);
	}

	public void del(Class<T> t, String sqlId) {
		super.getSqlSession().delete( MAPPERPATH+  t.getSimpleName() + "Mapper." + sqlId);
	}
}
