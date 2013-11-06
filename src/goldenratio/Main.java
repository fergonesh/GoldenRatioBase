package goldenratio;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author pasha
 */
public class Main {
    
     public static void main(String[] args) {    
//          String[] fpoint = {"1","0","1","0","0",".","0","1","0","1"};//10
//         String[] spoint = {"1","0","0","1","0","0",".","0","0","1","0","0","1"}; //14
//         String[] zp = {"1",".","1","1"};
          StringBuilder fpoint = new StringBuilder("0.1010");
          StringBuilder spoint = new StringBuilder("0.1001");
          
          StringBuilder fp = new StringBuilder("1.00");
          StringBuilder sp = new StringBuilder("10100.0101");
          GoldenRatioOperation Test = new GoldenRatioOperation( getArrayList(fp),getArrayList(sp));
         // System.out.println(Test.getSubstruction());
        //  System.out.println(Test.getDivision());
          GoldenRatio testgr = new GoldenRatio();
          //System.out.println(testgr.getGoldenNumFromDecimal(22));
         // System.out.println(Test.getSubstruction());
          double d =10d;
          String fps = "10.01";
          String sps = "10100.0101";
          String qps = "1000.1001";
          //System.out.println(testgr.getGoldenNumFromDecimal(1000000));
          //printDivision(fps, sps);
          int a =4;int b=5;
          printAdittion(30, 15);
          
          new GoldenRatio().getGoldenNumFromDecimal(40);
          StringBuilder str = new StringBuilder("10101000.10000001");
          System.out.println(new GoldenRatio().getDecimalNumFromGolden(getArrayList(str)));
          
         // System.out.println();
//          printSubstruction(sps, fps);
          printSubstruction(100, 7);
 //         printMultiplication(fps, qps);
 //         printMultiplication(5, 2);
 //         printDivision(6, 2);
          //printMultiplication(2, 3);
//            printDivision(9,3);
//          System.out.println("a ="+a+" b="+b);
//          System.out.println("a="+new GoldenRatio().getGoldenNumFromDecimal(a));
//          System.out.println("b="+new GoldenRatio().getGoldenNumFromDecimal(b));
//          System.out.println("Addition by gold: "+getAdittion(a, b));
//          System.out.println("Addition by dec: "+ new GoldenRatio().getGoldenNumFromDecimal(a+b));
//          System.out.println("Substraction by gold: "+getSubstruction(a, b));
//          System.out.println("Substraction by dec : "+new GoldenRatio().getGoldenNumFromDecimal(a-b) );
//          System.out.println("Multiplication by gold: "+getMultiplication(a, b) );
//          System.out.println("Multiplication by dec : "+new GoldenRatio().getGoldenNumFromDecimal(20));
//          //System.out.println("get dec of multires : "+new GoldenRatio().getDecimalNumFromGolden(null));
//          StringBuilder spq = new StringBuilder("1000010.010001");
//          System.out.println("From gold to decimal: "+new GoldenRatio().getDecimalNumFromGolden(getArrayList(spq)));
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
        
        
        private static void printAdittion(int f,int s){
            ArrayList<String> fir = new ArrayList<>(new GoldenRatio().getGoldenNumFromDecimal(f));
           ArrayList<String> sec = new ArrayList<>(new GoldenRatio().getGoldenNumFromDecimal(s));
           
            ArrayList<String> res = new ArrayList<>(new GoldenRatioOperation(fir,sec).getAddition());
            System.out.println("first num: "+fir.toString());
            System.out.println("second num: "+sec.toString());
            System.out.println("Addition: "+res.toString());
        }
        
        private static void printSubstruction(int f,int s){
            ArrayList<String> res = new ArrayList<>(new GoldenRatioOperation(new GoldenRatio().getGoldenNumFromDecimal(f),new GoldenRatio().getGoldenNumFromDecimal(s)).getSubstruction());
           System.out.println("Substruction: "+res.toString());
       }
        private static void printMultiplication(int f,int s){
           ArrayList<String> fir = new ArrayList<>(new GoldenRatio().getGoldenNumFromDecimal(f));
           ArrayList<String> sec = new ArrayList<>(new GoldenRatio().getGoldenNumFromDecimal(s));
            ArrayList<String> res = new ArrayList<>(new GoldenRatioOperation(fir,sec).getMultiplication());
            System.out.println("first num : "+fir.toString());
            System.out.println("second num : "+sec.toString());
            System.out.println("Multiplication : "+res.toString());
        }        

       private static void printDivision(int f, int s){
           ArrayList<String> fir = new ArrayList<>(new GoldenRatio().getGoldenNumFromDecimal(f));
           ArrayList<String> sec = new ArrayList<>(new GoldenRatio().getGoldenNumFromDecimal(s));
           ArrayList<ArrayList<String>> res= new ArrayList<>(new GoldenRatioOperation(fir,sec).getDivision());
           System.out.println("quotient : "+res.get(0).toString());
           System.out.println("reminder : "+res.get(1).toString());
       }
       
       private static void getAdittion(String f,String s){
            StringBuilder fir = new StringBuilder(f);
           StringBuilder sec = new StringBuilder(s);
           ArrayList<String> firls = new ArrayList<>(getArrayList(fir));
           ArrayList<String> secls = new ArrayList<>(getArrayList(sec));
           new FibonachiCheck().checkGoldenNumber(firls);
           new FibonachiCheck().checkGoldenNumber(secls);           
           ArrayList<String> res = new ArrayList<>(new GoldenRatioOperation(firls,secls).getAddition());
           System.out.println("Adittion : "+res.get(0).toString());
          
        }
       
              private static void printSubstruction(String f,String s){
            StringBuilder fir = new StringBuilder(f);
           StringBuilder sec = new StringBuilder(s);
           ArrayList<String> firls = new ArrayList<>(getArrayList(fir));
           ArrayList<String> secls = new ArrayList<>(getArrayList(sec));
           new FibonachiCheck().checkGoldenNumber(firls);
           new FibonachiCheck().checkGoldenNumber(secls);           
           ArrayList<String> res = new ArrayList<>(new GoldenRatioOperation(firls,secls).getSubstruction());
           System.out.println("Substruction : "+res.toString());
          
        }
              
     private static void printMultiplication(String f,String s){
            StringBuilder fir = new StringBuilder(f);
           StringBuilder sec = new StringBuilder(s);
           ArrayList<String> firls = new ArrayList<>(getArrayList(fir));
           ArrayList<String> secls = new ArrayList<>(getArrayList(sec));
           new FibonachiCheck().checkGoldenNumber(firls);
           new FibonachiCheck().checkGoldenNumber(secls);           
           ArrayList<String> res = new ArrayList<>(new GoldenRatioOperation(firls,secls).getMultiplication());
           System.out.println("Multiplication : "+res.toString());
          
        }
       
       private static void printDivision(String f,String s){
           StringBuilder fir = new StringBuilder(f);
           StringBuilder sec = new StringBuilder(s);
           ArrayList<String> firls = new ArrayList<>(getArrayList(fir));
           ArrayList<String> secls = new ArrayList<>(getArrayList(sec));
           new FibonachiCheck().checkGoldenNumber(firls);
           new FibonachiCheck().checkGoldenNumber(secls);           
           ArrayList<ArrayList<String>> res = new ArrayList<>(new GoldenRatioOperation(firls,secls).getDivision());
           System.out.println("quotient : "+res.get(0).toString());
           System.out.println("reminder : "+res.get(1).toString());
       }
    
}
