package com.microblog.dao;

import java.util.List;
import java.util.Map;

public interface BaseDao<T>
{
	/**
	 * 
	 * @param t  :要保存的数据对象
	 * @param sqlId:   mapper中的方法名
	 * 
	 * "com.yc.dao.mapper."+ t.getClass().getSimpleName()  +"Mapper."+ sqlId
	 * com.yc.dao.mapper.AccountMapper.update
	 */
	public void save(T t, String sqlId);
	
	public void update(T t, String sqlId);
	
	public void del(Class<T> clazz, int id, String sqlId);
	
	public void del(   Class<T> clazz, List<Integer> ids, String sqlId);
	
	public void del(   Class<T> clazz,  String sqlId);
	
	public List<T> findAll(Class<T> clazz, String sqlId);
	
	public T find(T t, String sqlId);
	
	/**
	 * 根据条件分页查询
	 * @param clazz
	 * @param map:  参数       键为字段名    值参数值
	 * @param sqlId:  mapper里面的方法名
	 * @param offset   :    从第几条数据开始查
	 * @param sizePage:  每页几条
	 * @return
	 */
	public List<T> findList(Class<T> clazz, Map<String, Object> map, String sqlId, int offset, int sizePage);
	
	/**
	 *  聚合查询
	 * @param clazz    :  
	 * @param sqlId
	 * @return
	 */
	public int getCount(Class<T> clazz, String sqlId);
	
	/**
	 *  根据条件聚合查询
	 * @param clazz    :  
	 * @param sqlId
	 * @return
	 */
	public int getCount(Class<T> clazz, Map<String, Object> map, String sqlId);
}
