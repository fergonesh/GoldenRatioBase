package goldenratio;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author pasha
 */
public class Main {
    
     public static void main(String[] args) {    
        printAdittion(22, 2);
        printSubstruction(100, 7);
        printMultiplication(5, 2);
        printDivision(6, 2);
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
