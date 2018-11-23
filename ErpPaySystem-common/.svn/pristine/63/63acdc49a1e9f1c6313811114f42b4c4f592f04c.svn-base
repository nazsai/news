package com.minshang.eps.util;

import java.util.Collection;
import java.util.Map;

public class NonUtil {
	public static boolean isNon(Object object){
	    boolean isnon = false;
	    if (object == null) {
	      return true;
	    }
	    if ((object instanceof String)) {
	      String str = (String)object;
	      if (str.trim().length() == 0)
	        isnon = true;
	    } else if ((object instanceof Collection)) {
	      @SuppressWarnings("rawtypes")
		Collection collection = (Collection)object;
	      if (collection.size() == 0)
	        isnon = true;
	    } else if ((object instanceof Map)) {
	      @SuppressWarnings("rawtypes")
		Map map = (Map)object;
	      if (map.size() == 0) {
	        isnon = true;
	      }
	    }
	    return isnon;
	  }

	  public static boolean isNotNon(Object object) {
	    return !isNon(object);
	  }
}
