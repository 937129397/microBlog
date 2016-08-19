package com.zy.dao;

import java.util.List;
import java.util.Map;

public interface BaseDao<T> {

	/**
	 * 
	 * @param t
	 *            要保存的对象
	 * @param sqlId
	 *            mapper中的方法
	 */
	public void save(T t, String sqlId);

	/**
	 * 
	 * @param t
	 *            要更改的对象
	 * @param sqlId
	 *            mapper中的方法
	 */
	public void update(T t, String sqlId);

	/**
	 * 
	 * @param clazz
	 * @param sqlId
	 *            mapper中的方法
	 * @return 
	 */
	public int del(Class<T> clazz, String sqlId,Integer id);
	
	public int del(Class<T> clazz, String sqlId,List<Integer> ids);

	/**
	 * 
	 * @param clazz
	 * @param sqlId
	 *            mapper中的方法
	 * @return
	 */
	public List<T> findAll(Class<T> clazz, String sqlId);

	/**
	 * 
	 * @param t
	 * @param sqlId
	 *            mapper中的方法
	 * @return
	 */
	public T find(T t, String sqlId);

	/**
	 * 条件 分页 查询
	 * 
	 * @param clazz
	 * @param sqlId
	 *            mapper中的方法
	 * @param params
	 *            参数
	 * @param offset
	 *            页码
	 * @param sizePage
	 *            条/页
	 * @return
	 */
	public List<T> findList(Class<T> clazz, String sqlId,
			Map<String, Object> params, int offset, int sizePage);;

	/**
	 * 聚合查询
	 * 
	 * @param clazz
	 * @param sqlId
	 *            mapper中的方法
	 * @return
	 */
	public int getCount(Class<T> clazz, String sqlId);

	/**
	 * 条件聚合
	 * 
	 * @param clazz
	 * @param sqlId
	 *            mapper中的方法
	 * @param params
	 * @return
	 */
	public int getCount(Class<T> clazz, String sqlId, Map<String, Object> map);

}
