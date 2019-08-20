/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


/**
 *
 * @author banzai
 */
public class Handay {
   
   String freeTime;
   public static void main(String[] args){
       int day = 1440;
       int[] fixedEvents = {480,300,150};
       int[] variedEvents = {};
       timeHandler time = new timeHandler();
       int okay = time.calcOccupied(fixedEvents, variedEvents);
       System.out.print(okay );
       int freetime = time.calcFree(okay, day);
       System.out.print(freetime );
       List ok = time.random(freetime, 4);
       System.out.println(ok);
}
   
private static class timeHandler{
    int calcOccupied(int[] fixedEvents , int[] variedEvents) {
       int fix = 0;
       int var = 0;
       for(int sum:fixedEvents){
           fix += sum;
       }
       for (int sum:variedEvents){
           var += sum;
       }
       int occupiedTime = fix+var;
      return occupiedTime;
   };
   int calcFree(int occupied, int day){
       
       return day - occupied;
   }
   int[] breakIntervals(int free, int space)
   {

       Random random = new Random();
       int [] intervals = new int[space];
       for (int i=0; i<intervals.length; i++)
       { 
           intervals[i] = random.nextInt(free);
       }
       return intervals;
   }
List random(int targetSum, int numberOfDraws) {
    Random r = new Random();
    List<Integer> load = new ArrayList<>();
    int sum = 0;
    for (int i = 0; i < numberOfDraws; i++) {
        int next = r.nextInt(targetSum) + 1;
        load.add(next);
        sum += next;
    }
    double scale = 1d * targetSum / sum;
    sum = 0;
    for (int i = 0; i < numberOfDraws; i++) {
        load.set(i, (int) (load.get(i) * scale));
        sum += load.get(i);
    }

    //take rounding issues into account
    while(sum++ < targetSum) {
        int i = r.nextInt(numberOfDraws);
        load.set(i, load.get(i) + 1);
    }
    
    return load;
}
}}