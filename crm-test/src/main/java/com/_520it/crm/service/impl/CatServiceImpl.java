package com._520it.crm.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Cat;
import com._520it.crm.mapper.CatMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.ICatService;
@Service
public class CatServiceImpl implements ICatService {
	@Autowired
	private CatMapper catMapper;
	
	public int deleteByPrimaryKey(Long id) {
		return catMapper.deleteByPrimaryKey(id);
	}

	public int insert(Cat record) {
		return catMapper.insert(record);
	}

	public Cat selectByPrimaryKey(Long id) {
		return catMapper.selectByPrimaryKey(id);
	}

	public List<Cat> selectAll() {
		return catMapper.selectAll();
	}

	public int updateByPrimaryKey(Cat record) {
		return catMapper.updateByPrimaryKey(record);
	}

	@Override
	public PageResult queryPage(QueryObject qo) {
		Long count = catMapper.queryPageCount(qo);
		if(count<=0){
			return new PageResult(0L, Collections.EMPTY_LIST);
		}
		List<Cat> result = catMapper.queryPageData(qo);
		PageResult pageResult = new PageResult(count,result);
		return pageResult;
	}
}
