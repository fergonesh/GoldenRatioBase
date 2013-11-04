/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package goldenratio;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author pasha
 */
public class Main {
    
     public static void main(String[] args) {
     
//         ArrayList<String> list = new ArrayList<>();
//         
//         list.add("0");
//        // list.add(".");
//         list.add("1");
//         list.add("1");
//         int a = list.indexOf(".");
//         //100100.001001
//          String[] fpoint = {"1","0","1","0","0",".","0","1","0","1"};//10
//         String[] spoint = {"1","0","0","1","0","0",".","0","0","1","0","0","1"}; //14
//         String[] zp = {"1",".","1","1"};
          StringBuilder fpoint = new StringBuilder("0.1010");
          StringBuilder spoint = new StringBuilder("0.1001");
          
          StringBuilder fp = new StringBuilder("1000.1001");
          StringBuilder sp = new StringBuilder("10.01");
          GoldenRatioOperation Test = new GoldenRatioOperation( getArrayList(fpoint),getArrayList(spoint));
          GoldenRatio testgr = new GoldenRatio();
          System.out.println(Test.getSubstruction());
          double d =10d;
          //System.out.println(testgr.getGoldenNumFromDecimal(1000000));
        
         
    
       
     }
     
        private static ArrayList<String> getArrayList(String[] str)
    {
       return  new ArrayList(Arrays.asList(str));
    }
        
        private static ArrayList<String> getArrayList(StringBuilder str){
            ArrayList<String> list = new ArrayList<>();
            for(int i=0;i<str.length();i++){
                list.add(String.valueOf(str.charAt(i)));
            }
            return list;
        }
    
}
