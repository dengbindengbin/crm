package com._520it.crm.domain;

import genertor.ObjectProp;
import lombok.Getter;
import lombok.Setter;

@Setter@Getter@ObjectProp("小猫管理")
public class Cat {
	private Long id;
	@ObjectProp("姓名")
	private String name;
	@ObjectProp("年龄")
	private Integer age;
}
