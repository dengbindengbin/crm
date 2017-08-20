package com._520it.crm.domain;

import genertor.ObjectProp;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by 1 on 2017/7/13.
 */
@Setter
@Getter
@ObjectProp("系统日志")
public class SystemLog {
    private Long id;
    @ObjectProp("操作时间")
    private Date opTime;
    @ObjectProp("操作人")
    private Employee opUser;
    @ObjectProp("操作内容")
    private String function;
    @ObjectProp("操作参数")
    private String params;
    @ObjectProp("操作IP")
    private String opIp ;
}
