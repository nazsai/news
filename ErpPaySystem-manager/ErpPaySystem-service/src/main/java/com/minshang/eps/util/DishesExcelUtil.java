package com.minshang.eps.util;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minshang.eps.dao.DishesMapper;
import com.minshang.eps.entity.Dishes;

@Service
public class DishesExcelUtil extends ExcelUtil {
	
	private final Logger Log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DishesMapper dishesMapper;

	@Override
	public void optRow(int sheetIndex, int curRow, List<String> rowList){
		if(!islegal) {
			return;
		}
		if(0==curRow) {
			if(rowList.size()!=15) {
				errMes = "文件格式错误";
				islegal = false;
			}
			return;
		}
		Dishes dishes = new Dishes();
		for (int i = 0; i < rowList.size(); i++) {
			dishes.setDishesname(rowList.get(0));
			dishes.setDishestypeid(Integer.valueOf(rowList.get(1)));
			dishes.setPrice(Double.valueOf(rowList.get(2)));
			dishes.setMemberprice(Double.valueOf(rowList.get(3)));
			dishes.setUnit(Integer.valueOf(rowList.get(4)));
			dishes.setSpellremember(rowList.get(5));
			dishes.setNumremember(rowList.get(6));
			dishes.setState(Byte.valueOf(rowList.get(7)));
			dishes.setWeigth(Byte.valueOf(rowList.get(8)));
			dishes.setRecommend(Byte.valueOf(rowList.get(9)));
			dishes.setHot(Byte.valueOf(rowList.get(10)));
			dishes.setNowprice(Byte.valueOf(rowList.get(11)));
			dishes.setPushmoney(Byte.valueOf(rowList.get(12)));
			dishes.setPushtype(Byte.valueOf(rowList.get(13)));
			dishes.setFixmoney(Double.valueOf(rowList.get(14)));
		}
		try {
			dishesMapper.insert(dishes);
		} catch (Exception e) {
			Log.error("插入错误",e);
		}
	}
	
	/*public void init() {
		String path = "D:\\Documents\\工作簿1.xlsx";
		try {
			this.readOneSheet(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

}
