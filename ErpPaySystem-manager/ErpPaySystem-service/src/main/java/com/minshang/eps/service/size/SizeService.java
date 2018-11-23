package com.minshang.eps.service.size;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minshang.eps.entity.Size;
import com.minshang.eps.util.PageParam;
import com.minshang.eps.util.PageResult;
import com.minshang.eps.util.ReturnValueDomain;

@Service
@Transactional
public interface SizeService {
	
	/**
	 * 新增
	 * @param size
	 * @return
	 */
	ReturnValueDomain<String> insert(Size size);
	
	/**
	 * 删除
	 * @param sizeid
	 * @return
	 */
	ReturnValueDomain<String> delete(Integer sizeid);
	
	/**
	 * 修改
	 * @param size
	 * @return
	 */
	ReturnValueDomain<String> updateByPrimaryKey(Size size);
	
	/**
	 * 分页查询
	 * @param size
	 * @return
	 */
	ReturnValueDomain<PageResult<Size>> selectByPage(PageParam<Size> pageParam);
}
