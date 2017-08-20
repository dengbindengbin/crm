package com._520it.crm.mapper;

import com._520it.crm.domain.SystemLog;
import com._520it.crm.query.QueryObject;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemLogMapper {
    int deleteByPrimaryKey(Long id);
    int insert(SystemLog record);
    SystemLog selectByPrimaryKey(Long id);
    List<SystemLog> selectAll();
    int updateByPrimaryKey(SystemLog record);
	Long queryPageCount(QueryObject qo);
	List<SystemLog> queryPageData(QueryObject qo);
}