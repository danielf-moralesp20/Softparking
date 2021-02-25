package dfm.softparking.business.runtime;

import java.util.HashMap;
import java.util.Map;

public class Collector {
	private static Collector singlenton;
	private Map<CollectorKey, Object> heap;
	
	public static enum CollectorKey {
		BUNDLED_LANG,
		AVAILABE_LANGUAGES,
		APPLICATION_PATH
	}
	
	private Collector() {
		heap = new HashMap<>();
	}
	
	public synchronized static Collector getCollector() {
		if(singlenton == null) singlenton = new Collector();
		
		return singlenton;
	}
	
	public Object get(CollectorKey key) {
		return heap.get(key);
	}
	
	public void set(CollectorKey key, Object value) {
		heap.put(key, value);
	}
}

