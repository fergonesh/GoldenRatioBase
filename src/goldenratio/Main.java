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
         // System.out.println(Test.getSubstruction());
          double d =10d;
          
          //System.out.println(testgr.getGoldenNumFromDecimal(1000000));
        
          int a =4;int b=5;
          System.out.println("a ="+a+" b="+b);
          System.out.println("a="+new GoldenRatio().getGoldenNumFromDecimal(a));
          System.out.println("b="+new GoldenRatio().getGoldenNumFromDecimal(b));
          System.out.println("Addition by gold: "+getAdittion(a, b));
          System.out.println("Addition by dec: "+ new GoldenRatio().getGoldenNumFromDecimal(9));
          System.out.println("Substraction by gold: "+getSubstruction(a, b));
          System.out.println("Substraction by dec : "+new GoldenRatio().getGoldenNumFromDecimal(1) );
          StringBuilder spq = new StringBuilder("10100.0101");
          System.out.println("From gold to decimal: "+new GoldenRatio().getDecimalNumFromGolden(getArrayList(spq)));
          //1101.1101=10010.0101
          //1101.1101 = 10001.1101=10010.0101
          //1.618033989
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
        
//        private static ArrayList<String> getAdittion(StringBuilder f, StringBuilder s){
//            return 
//        }
        
        private static ArrayList<String> getAdittion(int f,int s){
            return new GoldenRatioOperation(new GoldenRatio().getGoldenNumFromDecimal(f),new GoldenRatio().getGoldenNumFromDecimal(s)).getAddition();
        }
        
        private static ArrayList<String> getSubstruction(int f,int s){
            return new GoldenRatioOperation(new GoldenRatio().getGoldenNumFromDecimal(f),new GoldenRatio().getGoldenNumFromDecimal(s)).getSubstruction();
        }
    
}
