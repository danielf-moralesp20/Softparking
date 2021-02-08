package dfm.softparking.business.runtime;

import java.util.HashMap;
import java.util.Map;

public class Collector {
	private static Collector singlenton;
	private Map<Integer, Object> heap;
	
	public static final int BUNDLED_LANG = 1;
	public static final int LOCALE = 2;
	
	private Collector() {
		heap = new HashMap<Integer, Object>();
	}
	
	public static Collector getCollector() {
		if(singlenton == null) singlenton = new Collector();
		
		return singlenton;
	}
	
	public Object get(int key) {
		return heap.get(key);
	}
	
	public void set(int key, Object value) {
		heap.put(key, value);
	}
}
