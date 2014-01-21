/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:There are N gas stations along a circular route, 
 * where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] 
 * of gas to travel from station i to its next station (i+1).
 * You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * Note:
 * The solution is guaranteed to be unique.
 * @author chenbo
 */
public class GasStation 
{
    static boolean isValid(int[] gas, int[] cost, int start)
    {
        int totalGas = 0;
        int i = start;
        while(true)
        {
            totalGas += gas[i];
            if(totalGas < cost[i]) return false;
            totalGas -= cost[i];
            i++;
            if(i == gas.length) i = 0;
            if(i == start) return true;
        }
    }
    static int canCompleteCircuit(int[] gas, int[] cost)
    {
        for(int i = 0; i < gas.length; i++)
        {
            if(isValid(gas, cost, i)) return i;
        }
        return -1;
    }
    public static void main(String[] args)
    {
        int[] gas = {8,4,2,1,5};
        int[] cost = {20,4,1,3,1};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
