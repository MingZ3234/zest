package com.github.bookong.zest.testcase.data.param;

import com.github.bookong.zest.testcase.ZestData;
import com.github.bookong.zest.testcase.data.AbstractZestDataTest;
import com.github.bookong.zest.testcase.param.Param;
import com.github.bookong.zest.util.Messages;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jiang Xu
 */
public class ZestDataTest extends AbstractZestDataTest {

    @Override
    protected void initZestData(String filename, ZestData zestData) {
    }

    @Test
    public void testLoad01() {
        testLoadError("01.xml", Messages.parseParamError(), //
                      Messages.parseCommonChildrenList("Param", "ParamField"));
    }

    @Test
    public void testLoad02() {
        testLoadError("02.xml", Messages.parseParamError(), //
                      Messages.parseCommonAttrEmpty( "Name"));
    }

    @Test
    public void testLoad03() {
        testLoadError("03.xml", Messages.parseParamError(), //
                      Messages.parseCommonAttrDuplicate("Name", "strValue"));
    }

    @Test
    public void testLoad04() {
        testLoadError("04.xml", Messages.parseParamError(), //
                      Messages.parseParamNone("none"));
    }

    @Test
    public void testLoad05() {
        testLoadError("05.xml", Messages.parseParamError(), //
                      Messages.parseParamObjLoad("intValue"), //
                      "For input string: \"str value\"");
    }

    @Test
    public void testLoad06() {
        testLoadError("06.xml", Messages.parseParamError(), //
                      Messages.parseParamObjLoad("date1"), //
                      Messages.parseDate("str value"));
    }

    @Test
    public void testLoad07() {
        testLoadError("07.xml", Messages.parseParamError(), //
                      Messages.parseParamObjLoad("nonsupportMapObj"), //
                      Messages.parseParamNonsupportMap());
    }

    @Test
    public void testLoad08() {
        logger.info("Normal data");
        ZestData zestData = load("08.xml");
        Param param = (Param) zestData.getParam();
        Assert.assertEquals(1, param.getIntValue());
        Assert.assertEquals(2, param.getIntObjValue().intValue());
        Assert.assertEquals(3, param.getLongValue());
        Assert.assertEquals(4, param.getLongObjValue().longValue());
        Assert.assertTrue(param.isBoolValue());
        Assert.assertTrue(param.getBoolObjValue());
        Assert.assertEquals(5.5, param.getDoubleValue(), 0.1);
        Assert.assertEquals(6.5, param.getDoubleObjValue(), 0.1);
        Assert.assertEquals(7.5, param.getFloatValue(), 0.1);
        Assert.assertEquals(8.5, param.getFloatObjValue(), 0.1);
        Assert.assertEquals("hello", param.getStrValue());
        Assert.assertEquals("2020-08-10 13:14:15", DateFormatUtils.format(param.getDate1(), //
                                                                          "yyyy-MM-dd HH:mm:ss"));
        Assert.assertEquals("2020-08-10 13:14:00", DateFormatUtils.format(param.getDate2(), //
                                                                          "yyyy-MM-dd HH:mm:ss"));
        Assert.assertEquals("2020-08-10 13:00:00", DateFormatUtils.format(param.getDate3(), //
                                                                          "yyyy-MM-dd HH:mm:ss"));
        Assert.assertEquals("2020-08-10 00:00:00", DateFormatUtils.format(param.getDate4(), //
                                                                          "yyyy-MM-dd HH:mm:ss"));

        Assert.assertEquals(2, param.getListObj().size());
        Assert.assertEquals("1: param1 str", param.getListObj().get(0).getStr());
        Assert.assertEquals("1: param2 str", param.getListObj().get(0).getObj2().getStr());

        Assert.assertEquals("2: param1 str", param.getListObj().get(1).getStr());
        Assert.assertEquals("2: param2 str", param.getListObj().get(1).getObj2().getStr());

        Assert.assertEquals("param1 str", param.getObj().getStr());
        Assert.assertEquals("param2 str", param.getObj().getObj2().getStr());
    }

    @Test
    public void testLoad09() {
        testLoadError("09.xml", Messages.parseParamError(), //
                Messages.parseCommonAttrUnknown("Param", "U"));
    }
}