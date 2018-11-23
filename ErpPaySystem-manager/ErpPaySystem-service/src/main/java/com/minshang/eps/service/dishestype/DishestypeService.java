package com.minshang.eps.service.dishestype;

import java.util.List;

import com.minshang.eps.entity.Dishestype;
import com.minshang.eps.util.ReturnValueDomain;

public interface DishestypeService {
	
	ReturnValueDomain<String> insert(Dishestype record);
	
	ReturnValueDomain<String> deleteByPrimaryKey(Integer dishestypeid);
	
	ReturnValueDomain<String> updateByPrimaryKey(Dishestype record);
	
	ReturnValueDomain<List<Dishestype>> select(Dishestype record);
}
