package com.github.bookong.zest.rule;

import com.github.bookong.zest.support.xml.XmlNode;
import com.github.bookong.zest.testcase.ZestData;
import com.github.bookong.zest.util.Messages;
import org.junit.Assert;
import org.w3c.dom.Node;

import java.util.regex.Pattern;

/**
 * @author Jiang Xu
 */
public class RegExpRule extends AbstractRule {

    private String regExp;

    public RegExpRule(String field, boolean nullable, String regExp){
        super(field, nullable, true);
        this.regExp = regExp;
    }

    public RegExpRule(Node node, String field, boolean nullable){
        super(field, nullable, false);
        XmlNode xmlNode = new XmlNode(node);
        xmlNode.checkSupportedAttrs();
        xmlNode.mustNoChildren();

        this.regExp = xmlNode.getNodeValue();
    }

    @Override
    public void verify(ZestData zestData, Object actual) {
        if (actual == null) {
            if (!isNullable()) {
                Assert.fail(Messages.verifyRuleNotNull(getField()));
            }
        } else {
            String actualValue = String.valueOf(actual);
            Assert.assertTrue(Messages.verifyRuleRegExp(getField(), getRegExp(), actualValue),
                              Pattern.matches(getRegExp(), String.valueOf(actual)));
        }
    }

    public String getRegExp() {
        return regExp;
    }
}
