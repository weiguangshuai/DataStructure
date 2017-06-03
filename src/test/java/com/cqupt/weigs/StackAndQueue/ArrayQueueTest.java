package com.cqupt.weigs.StackAndQueue;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * ArrayQueue Tester.
 *
 * @author <Authors name>
 * @version 1.0
 */
public class ArrayQueueTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: size()
     */
    @Test
    public void testSize() throws Exception {
        ArrayQueue<String> arrayQueue = new ArrayQueue<>();
        arrayQueue.offer("nihao");
        arrayQueue.offer("wobuhao");
        System.out.println(arrayQueue);
        System.out.println(arrayQueue.poll());
        System.out.println(arrayQueue);
    }

    /**
     * Method: offer(T element)
     */
    @Test
    public void testOffer() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: ensureCapacity(int minCapacity)
     */
    @Test
    public void testEnsureCapacity() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: poll()
     */
    @Test
    public void testPoll() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: peek()
     */
    @Test
    public void testPeek() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: isEmpty()
     */
    @Test
    public void testIsEmpty() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: clear()
     */
    @Test
    public void testClear() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: toString()
     */
    @Test
    public void testToString() throws Exception {
//TODO: Test goes here... 
    }


} 
