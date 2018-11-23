package com.minshang.eps.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageUtil {
		
		public static Map<String,Object> parseData(List<?> list,Integer totalNum,String resultdesc) {
			
			Map<String,Object> resultMap = new HashMap<>();
					
			resultMap.put("code", 0);

			resultMap.put("msg", resultdesc);

			resultMap.put("count", totalNum);

			resultMap.put("data", list);
			
			return resultMap;
		}
	}


