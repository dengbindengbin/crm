package com._520it.crm.service;

import javafx.scene.input.DataFormat;
import jxl.Sheet;
import jxl.Workbook;
import jxl.biff.DisplayFormat;
import jxl.write.*;
import org.junit.Test;

import java.io.File;
import java.util.zip.DataFormatException;

/**
 * Created by 1 on 2017/7/13.
 */
public class ExcelTest {

    @Test
    public void testOut() throws Exception {
        //创建一个工作表  使用Workbook
        WritableWorkbook workbook = Workbook.createWorkbook(new File("out.xls"));
        //创建工作本：  调用方法 createSheet
        WritableSheet sheet = workbook.createSheet("第一个工作本", 1);
        //设置具体列的高度以及具体列的宽度
        sheet.setColumnView(1, 40);
        sheet.setRowView(0, 400);
        //合并单元格
        sheet.mergeCells(0, 0, 6, 8);
        //添加单元格    调用方法Label
        Label label = new Label(0, 0, "第一个单元格");
        //将单元格水平居中
        //添加日期的单元格
       /* DataFormat df = new DataFormat("yyyy-MM-dd HH:mm:ss");
        WritableCellFormat cellFormat = new WritableCellFormat(df);
        cellFormat.setAlignment(Alignment.CENTRE);*/
        //设置单元格的垂直居中
        //将单元格加入到工作本中  调用方法addCell
        sheet.addCell(label);
        //将文件写出，并关闭资源
        workbook.write();
        workbook.close();
    }

    //数据的导入
    @Test
    public void testIn() throws Exception {
      //读取Excel文件  使用getWorkbook 方法
        Workbook workbook = Workbook.getWorkbook(new File("int.xls"));
        //获取到工作本
        Sheet sheet = workbook.getSheet(0);
        //获取到单元格的行数。列数
        int rows = sheet.getRows();
        int columns = sheet.getColumns();
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j < columns; j++) {
                //获取到一个单元格中的内容
                System.out.println(sheet.getCell(j,i).getContents()+"\t");
            }
            System.out.println();
        }
        workbook.close();

    }
}
