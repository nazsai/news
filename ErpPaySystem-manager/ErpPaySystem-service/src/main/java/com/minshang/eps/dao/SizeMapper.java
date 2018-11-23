package com.minshang.eps.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.minshang.eps.entity.Size;
import com.minshang.eps.util.PageParam;
import com.minshang.eps.util.PageResult;

public interface SizeMapper {
    int deleteByPrimaryKey(Integer sizeid);

    int insert(Size record);

    int insertSelective(Size record);

    Size selectByPrimaryKey(Integer sizeid);

    int updateByPrimaryKeySelective(Size record);

    int updateByPrimaryKey(Size record);
    
    int count(String sizename);
    
    List<Size> selectByPage(PageParam<Size> pageParam);
    
}