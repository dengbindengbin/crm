package com._520it.crm.domain;

import genertor.ObjectProp;
import lombok.Getter;
import lombok.Setter;

@Setter@Getter@ObjectProp("权限")
public class Permission {
	private Long id;
	@ObjectProp("名称")
	private String name;
	@ObjectProp("表达式")
	private String resource;
}
