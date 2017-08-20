package com._520it.crm.service;
import java.util.List;
import com._520it.crm.domain.Cat;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

public interface ICatService {
	int deleteByPrimaryKey(Long id);
    int insert(Cat record);
    Cat selectByPrimaryKey(Long id);
    List<Cat> selectAll();
    int updateByPrimaryKey(Cat record);
	PageResult queryPage(QueryObject qo);
}
