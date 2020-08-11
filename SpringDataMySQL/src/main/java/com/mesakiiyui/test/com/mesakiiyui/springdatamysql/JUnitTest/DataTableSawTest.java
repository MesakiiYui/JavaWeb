package com.mesakiiyui.test.com.mesakiiyui.springdatamysql.JUnitTest;


import org.junit.Test;
import tech.tablesaw.api.ColumnType;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.NumberColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.numbers.NumberColumnFormatter;

/**
 * https://juejin.im/post/5dafb39d51882502591ff883
 */
public class DataTableSawTest {
    @Test
    public void testTableSaw6() {
        String[] students = {"小明", "李雷", "小二"};
        double[] scores = {90.1, 84.3, 99.7};
        Table table = Table.create("学生分数统计表").addColumns(
                StringColumn.create("姓名", students),
                DoubleColumn.create("分数", scores));
        System.out.println(table.print());
    }
    @Test
    public void testTableSaw10() throws Exception{
        Table table = Table.read().csv("/data/bush.csv");
        Table whoPercents = table.xTabPercents("who");
        whoPercents.columnsOfType(ColumnType.DOUBLE)
                .forEach(x -> ((NumberColumn) x).setPrintFormatter(
                        NumberColumnFormatter.percent(0)));
        System.out.println(whoPercents.toString());
    }


}
