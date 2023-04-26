package com.example.demo01.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode
public class User {
    @ExcelProperty("UUID")
    @ExcelIgnore
    private String uuid;
    @ExcelProperty("编号")
    private String bh;
    @ExcelProperty("姓名")
    private String xm;
    @ExcelProperty("身份证")
    private String sfz;
    @ExcelProperty("手机号")
    private String phone;
    @ExcelProperty("创建时间")
    private String cjsj;
    @ExcelProperty("窗口")
    private String ckbh;
    @ExcelProperty("开始时间")
    private String kssj;
    @ExcelProperty("结束时间")
    private String jssj;
    @ExcelProperty("状态")
    private Integer status;
}
