package ec.com.andres.entities;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import ec.com.andres.cache.DataBaseCache;

public class EntityCrud<T> {

	public int id;
	private T entity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public T save() {
		DataBaseCache<T> dataBaseCache = DataBaseCache.getDataBaseCache();
		dataBaseCache.getList(entity.getClass()).add(entity);
		return this.entity;
	}

	public T remove() {
		DataBaseCache<T> dataBaseCache = DataBaseCache.getDataBaseCache();
		dataBaseCache.getList(entity.getClass()).remove(entity);
		return this.entity;
	}

	public T findById(int i){
		DataBaseCache<T> dataBaseCache = DataBaseCache.getDataBaseCache();
		try {
			for (Object e : dataBaseCache.getList(entity.getClass())) {
				Method getId;
				getId = e.getClass().getMethod("getId");
				int idEntity = (Integer) getId.invoke(e);
				if (idEntity == id) {
					return (T) e;
				}
			}
		} catch (NoSuchMethodException | SecurityException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
	public T findByAtrribute(String attribute, String value){
		DataBaseCache<T> dataBaseCache = DataBaseCache.getDataBaseCache();
		try {
			for (Object e : dataBaseCache.getList(entity.getClass())) {
				attribute = attribute.substring(0, 1).toUpperCase() + attribute.substring(1);
				Method getAttribute;
				getAttribute = e.getClass().getMethod("get"+attribute);
				Object result =  getAttribute.invoke(e);
				if (result.toString() == value) {
					return (T) e;
				}
			}
		} catch (NoSuchMethodException | SecurityException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	public List<T> getAll() {
		return new ArrayList();
	}

}
