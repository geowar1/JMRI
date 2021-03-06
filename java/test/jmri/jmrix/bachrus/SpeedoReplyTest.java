package jmri.jmrix.bachrus;

import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 * SpeedoReplyTest.java
 *
 * Test for the jmri.jmrix.bachrus.SpeedoReply class
 *
 * @author Paul Bender Copyright (C) 2016
 */
public class SpeedoReplyTest extends jmri.jmrix.AbstractMessageTestBase {

    @BeforeEach
    @Override
    public void setUp() {
        JUnitUtil.setUp();
        m = new SpeedoReply();
    }
   
    @Test
    public void atest() {
        SpeedoReply m  = new SpeedoReply(":400A1B4;");
        Assert.assertEquals("match", 3, m.match("0A1"));
        Assert.assertEquals("toString",":400A1B4;", m.toString());
        Assert.assertEquals("getSeries",4, m.getSeries());
        Assert.assertEquals("getCount",41396, m.getCount());
        Assert.assertEquals("skipPrefix",-1, m.skipPrefix(0));
        Assert.assertEquals("maxsize",32, m.maxSize());
    }
    
    @AfterEach
    public void tearDown() {
        m = null;
        JUnitUtil.tearDown();
    }

}
