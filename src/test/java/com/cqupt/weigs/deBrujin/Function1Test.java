package com.cqupt.weigs.deBrujin;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Function1 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 */
public class Function1Test {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: RandomDNA()
     */
    @Test
    public void testRandomDNA() throws Exception {
        Function1 function1 = new Function1();
        String randomDNA = function1.RandomDNA();
        function1.randomSelect(randomDNA);
    }


} 
