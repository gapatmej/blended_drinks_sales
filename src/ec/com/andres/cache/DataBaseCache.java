package ec.com.andres.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBaseCache<T> {
	private Map<String, List<T>> listMap = new HashMap<>();
	private static DataBaseCache entityCache;
	
	private DataBaseCache() {
	}
	
	public synchronized static DataBaseCache getDataBaseCache() {
		if(entityCache == null) {
			entityCache = new DataBaseCache<Object>();
		}
		return entityCache;
	}
	
	public List<T> getList(Class<? extends Object> clazz) {
		
		if(listMap.get(clazz.getName()) == null) {
			listMap.put(clazz.getName(), new ArrayList<>() );
		}
		
		return listMap.get(clazz.getName());
	}
}
