package com._520it.crm.service;
import java.util.List;
import com._520it.crm.domain.SystemLog;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

public interface ISystemLogService {
	int deleteByPrimaryKey(Long id);
    int insert(SystemLog record);
    SystemLog selectByPrimaryKey(Long id);
    List<SystemLog> selectAll();
    int updateByPrimaryKey(SystemLog record);
	PageResult queryPage(QueryObject qo);
}
