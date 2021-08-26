/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.dipstick.euclidean;

import dev.dipstick.euclidean.exceptions.StackOverFlowException;
import dev.dipstick.euclidean.exceptions.StackUnderFlowException;
import java.util.ArrayList;
import java.util.Queue;

/**
 *
 * @author PaTcHeS
 */
public class Memory
{
    
    private static ArrayList<Integer> memory;
    private static Queue<Integer>     stack;
    private static int                memorySize;
    private static int                stackSize;
    private static int                stackRemaining;
    
    public Memory()
    {
        this.memory.ensureCapacity(4096);
        this.memorySize     = 4096;
        this.stackSize      = 1024;
        this.stackRemaining = 1024;
    }
    
    public Memory(int memorySize, int stackSize)
    {
        memory.ensureCapacity(memorySize);
        this.memorySize     = memorySize;
        this.stackSize      = stackSize;
        this.stackRemaining = stackSize;
    }
    
    public void push(int value) throws StackOverFlowException
    {
        if (this.stackRemaining > 0)
        {
            try
            {
                this.stackRemaining--;
                this.stack.add(value);
            }
            catch(Exception e)
            {
                throw new StackOverFlowException(e.getMessage());
            }
        }
        else
        {
            throw new StackOverFlowException("Stack Over Flow.");
        }
    }
    
    public int pop() throws StackUnderFlowException
    {
        try
        {
            return stack.remove();
        }
        catch (Exception e)
        {
            throw new StackUnderFlowException("Stack Under Flow.");
        }
    }
    
    
    
}
