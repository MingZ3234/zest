package com.github.bookong.zest.testcase.sql;

import com.github.bookong.zest.exception.ZestException;
import com.github.bookong.zest.executor.SqlExecutor;
import com.github.bookong.zest.support.rule.AbstractRule;
import com.github.bookong.zest.testcase.AbstractRowData;
import com.github.bookong.zest.testcase.Source;
import com.github.bookong.zest.testcase.ZestData;
import com.github.bookong.zest.util.Messages;
import com.github.bookong.zest.util.ZestDateUtil;
import com.github.bookong.zest.util.ZestJsonUtil;
import org.junit.Assert;

import java.sql.Connection;
import java.sql.Types;
import java.util.*;

/**
 * @author Jiang Xu
 */
public class Row extends AbstractRowData {

    private Map<String, Object> dataMap = new LinkedHashMap<>();

    public Row(SqlExecutor sqlExecutor, Map<String, Integer> sqlTypes, String tableName, String xmlContent){
        Map xmlDataMap = ZestJsonUtil.fromJson(xmlContent, HashMap.class);
        for (Object key : xmlDataMap.keySet()) {
            String columnName = String.valueOf(key);
            Integer sqlType = sqlTypes.get(columnName);
            if (sqlType == null) {
                throw new ZestException(Messages.parseDataTableRowExist(columnName, tableName));
            }

            getDataMap().put(columnName, parseValue(sqlExecutor, sqlType, tableName, columnName, xmlDataMap.get(key)));
        }
    }

    public void verify(SqlExecutor executor, Connection conn, ZestData zestData, Source source, Table table, int rowIdx,
                       Map<String, Object> actualRow) {
        try {
            executor.verifyRow(conn, zestData, source, table, rowIdx, actualRow);
        } catch (UnsupportedOperationException e) {
            verify(zestData, source, table, rowIdx, actualRow);
        }
    }

    private void verify(ZestData zestData, Source source, Table table, int rowIdx, Map<String, Object> actualRow) {
        try {
            for (Map.Entry<String, Object> entry : actualRow.entrySet()) {
                String columnName = entry.getKey();
                Object actual = entry.getValue();

                Object expected = getDataMap().get(columnName);
                AbstractRule rule = table.getRuleMap().get(columnName);

                if (expected != null) {
                    if (rule != null) {
                        logger.info(Messages.verifyRowRuleNonuse(rule.getPath(), rowIdx));
                    }

                    if (expected instanceof Date) {
                        Assert.assertTrue(Messages.verifyRowDataDate(columnName), actual instanceof Date);
                        Date expectedDateInZest = ZestDateUtil.getDateInZest(zestData, (Date) expected);
                        String expectedValue = ZestDateUtil.formatDateNormal(expectedDateInZest);
                        String actualValue = ZestDateUtil.formatDateNormal((Date) actual);
                        Assert.assertEquals(Messages.verifyRowData(columnName, expectedValue), expectedValue,
                                            actualValue);

                    } else {
                        String expectedValue = String.valueOf(expected);
                        String actualValue = String.valueOf(actual);
                        Assert.assertEquals(Messages.verifyRowData(columnName, expectedValue), expectedValue,
                                            actualValue);
                    }

                } else {
                    // expected == null
                    if (rule != null) {
                        rule.verify(zestData, source, table, rowIdx, rule.getPath(), actualRow.get(rule.getPath()));
                    } else {
                        Assert.assertNull(Messages.verifyRowDataNull(columnName), actual);
                    }
                }
            }

        } catch (Exception e) {
            throw new ZestException(Messages.verifyRowError(source.getId(), table.getName(), rowIdx), e);
        }
    }

    private Object parseValue(SqlExecutor sqlExecutor, Integer fieldSqlType, String tableName, String columnName,
                              Object value) {
        if (value == null) {
            return null;
        }

        try {
            return sqlExecutor.parseRowValue(tableName, columnName, fieldSqlType, value);
        } catch (UnsupportedOperationException e) {
            switch (fieldSqlType) {
                case Types.DATE:
                case Types.TIME:
                case Types.TIMESTAMP:
                    return ZestDateUtil.parseDate(String.valueOf(value));
                default:
                    return value;
            }
        }
    }

    public Map<String, Object> getDataMap() {
        return dataMap;
    }
}
