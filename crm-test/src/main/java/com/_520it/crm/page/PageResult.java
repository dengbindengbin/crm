package com._520it.crm.page;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Setter@Getter@AllArgsConstructor
public class PageResult {
	private Long total;
	private List rows;
}
