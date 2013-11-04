/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package goldenratio;

import java.util.ArrayList;

/**
 *
 * @author pasha
 */
public class GoldenRatioOperation {
    
    private GoldenRatio first;
    private GoldenRatio second;
    
    public GoldenRatioOperation()
    {
        
    }
    public GoldenRatioOperation(GoldenRatio a,GoldenRatio b)
    {
        this.first = a;
        this.second = (GoldenRatio)b;
    }
      public GoldenRatioOperation(ArrayList<String> a,ArrayList<String> b)
    {
        this.first = new GoldenRatio(a);
        this.second = new GoldenRatio(b);
    }

    public GoldenRatio getFirst() {
        return first;
    }

    public void setFirst(GoldenRatio first) {
        this.first = first;
    }

    public GoldenRatio getSecond() {
        return second;
    }

    public void setSecond(GoldenRatio second) {
        this.second = second;
    }
    
    
    public void normalizeGoldenNumber()
    {
        ArrayList<String> a = new ArrayList<>(this.first.getNum());
        ArrayList<String> b = new ArrayList<>(this.second.getNum());
          if(!a.contains(".") && !b.contains("."))
        {
            //TODO normalize
            if(a.size()>b.size())
                a = new ArrayList<>(addZeroInPosition(a,a.size()-b.size() , true));
            else if(a.size()<b.size())
                b = new ArrayList<>(addZeroInPosition(b,b.size()-a.size() , true));
           this.first.setNum(a);           
             this.second.setNum(b);
            
            return;
        }
        else
        {
            ArrayList<String> lefta = new ArrayList<>(a.subList(0, a.indexOf(".")));
            ArrayList<String> leftb = new ArrayList<>(b.subList(0, b.indexOf(".")));
            if (lefta.size()>leftb.size())
            {
                leftb = new ArrayList<>(addZeroInPosition(leftb,lefta.size()-leftb.size() , true));
            }
            else if(lefta.size()<leftb.size())
            {
                lefta = new ArrayList<>(addZeroInPosition(lefta,leftb.size()-lefta.size() , true));
            }
            
            ArrayList<String> righta = new ArrayList<>(a.subList(a.indexOf(".")+1,a.size()));
            ArrayList<String> rightb = new ArrayList<>(b.subList(b.indexOf(".")+1,b.size()));
            if (righta.size()>rightb.size())
            {
                rightb = new ArrayList<>(addZeroInPosition(rightb,righta.size()-rightb.size() , false));
            }
            else if(righta.size()<rightb.size())
            {
                righta = new ArrayList<>(addZeroInPosition(righta,rightb.size()-righta.size() , false));
            }
            
            
            ArrayList<String> firstNum = new ArrayList<>(lefta);
            firstNum.add(".");
            firstNum.addAll(righta);
            this.first.setNum(firstNum);
            
            ArrayList<String> secondNum = new ArrayList<>(leftb);
            secondNum.add(".");
            secondNum.addAll(rightb);
            this.second.setNum(secondNum);
//            this.firstNum.addAll(righta);
//            this.secondNum = new ArrayList<>(leftb);
//            this.secondNum.addAll(rightb);
//            this.pointPosition = a.indexOf(".")>=b.indexOf(".") ? a.indexOf(".") : b.indexOf(".");
        }
    }
    private ArrayList addZeroInPosition(ArrayList list,int zeroQuantity,boolean begin)
    {
        if(begin)
        {
            for(int i=0;i<zeroQuantity;i++)
            {
                list.add(0, "0");
            }
        }
        else
        {
            for(int i=0;i<zeroQuantity; i++)
            {
                list.add(list.size(), "0");
            }
        }
        return list;
    }
    
        public boolean getComparison(ArrayList<String> a,ArrayList<String> b)
    {
        boolean res = false;
        if (a.size()!=b.size())
            System.out.println("Cannot Comparison 2 number with diff size");
        else
        {
            
            a.remove(".");
            b.remove(".");
            if(a.size()>b.size())
                res = true;
            else if (a.size()<b.size())
                res =false;
            else if (a.size()==b.size())
            {
                for(int i=0;i<a.size();i++)
                    if (!a.get(i).equals(b.get(i)) )
                    {
                        res = Integer.parseInt(a.get(i))>=Integer.parseInt(b.get(i)) ? true : false;
                        break;
                    }
            }
        }
        return res;
        
    }
    public ArrayList getAddition()
    {
        normalizeGoldenNumber();
        ArrayList<String> firstnum = new ArrayList<>(this.first.getNum());
        ArrayList<String> secondnum = new ArrayList<>(this.second.getNum());
        int pointPosition = firstnum.indexOf(".");
        firstnum.remove(".");
        secondnum.remove(".");
//      big/small is  number with more/less digit,respectively. 
        ArrayList<String> big = new ArrayList<>(getComparison(firstnum, secondnum)?firstnum : secondnum);
        ArrayList<String> small = new ArrayList<>(getComparison(firstnum, secondnum) ? secondnum : firstnum);
        
        int lessSize = small.size();
        int moreSize = big.size();
//      add zero to beggining of less number
//        for(int i=0;i<moreSize-lessSize;i++)
//        {
//            small.add(0, "0");
//        }

        while(small.contains("1"))
        {
            for(int i=0;i<moreSize;i++)
            {
                if("0".equals(big.get(i)) && "1".equals(small.get(i)) )
                {
                    big.set(i, "1");
                    small.set(i, "0");  
                }     
            }
             small = new ArrayList<>(new GoldenRatio().getMaximumFrom(small));
             big = new ArrayList<>(new GoldenRatio().getMinimalForm(big));
             if (big.size()!=moreSize)
             {
                 pointPosition+=big.size()-moreSize;
                 moreSize=big.size();
             }
        }
        big = new ArrayList<>(new GoldenRatio().getMinimalForm(big));
         if (big.size()!=moreSize)
             {
                 pointPosition+=big.size()-moreSize;
                 moreSize=big.size();
             }
        if (pointPosition>0)
            big.add(pointPosition, ".");
        return big; 
    }
    
     public ArrayList getSubstruction()
    {
        normalizeGoldenNumber();
        ArrayList<String> firstnum = new ArrayList<>(this.first.getNum());
        ArrayList<String> secondnum = new ArrayList<>(this.second.getNum());
        int pointPosition = firstnum.indexOf(".");
        firstnum.remove(".");
        secondnum.remove(".");
//      big/small is  number with more/less digit,respectively. 
//        ArrayList<Integer> big = new ArrayList<>(this.firstNum.size()>=this.secondNum.size()?this.firstNum:this.secondNum);
//        ArrayList<Integer> small = new ArrayList<>(this.firstNum.size()>=this.secondNum.size()?this.secondNum:this.firstNum);
        boolean sign = true;
        if(!getComparison(firstnum, secondnum))
            sign = false;
           
        ArrayList<String> big = new ArrayList<>(getComparison(firstnum,secondnum)?firstnum:secondnum);
        ArrayList<String> small = new ArrayList<>(getComparison(firstnum,secondnum)?secondnum:firstnum);
        int lessSize = small.size();
        int moreSize = big.size();
//        System.out.println("small :"+small);
//        System.out.println("big   :"+big);
//        if( "0".equals(big.get(moreSize-1)) && "1".equals(big.get(moreSize-2)) && "1".equals(small.get(lessSize-1)) ){
//           big.add("0");
//           small.add("0");
//        }

        
        while(small.contains("1"))
        {
            for(int i=0;i<moreSize;i++)
            {
                if("1".equals(small.get(i)) && "1".equals(big.get(i)) )
                {
                    big.set(i, "0");
                    small.set(i, "0");  
                }     
            }
            //test
            GoldenRatio GR = new GoldenRatio();
            
            //
             small = new ArrayList<>(GR.getMaximumFrom(small));
             big = new ArrayList<>(GR.getMaximumFrom(big));

        }  
        if (pointPosition!=0)
            big.add(pointPosition, ".");
        big =new GoldenRatio().getoutZero(big);
         big = new GoldenRatio().getMinimalForm(big);
        if(!sign)
            big.add(0,"-");
        
        if(new FibonachiCheck().checkGoldenNumber(big)) {
        } else {
            System.out.println("Error in Substruction");
        }
       // return (new GoldenRatio().getMinimalForm(big)) ;
     
       
        return big;
    }
     
/*     static ArrayList<String> multiplyadd(StringBuilder s1, StringBuilder s2) {
   // String result = "";
         ArrayList<String> result = new ArrayList<>();
     GoldenRatioOperation GL = new GoldenRatioOperation();
     GoldenRatio reg = new GoldenRatio();
     GoldenRatio seq = new GoldenRatio();
    StringBuilder zeroSuffix = new StringBuilder();
    for (int i = s2.length() - 1; i >= 0; i--) {
        if (s2.charAt(i) == '1') {
            StringBuilder secondAddition = s1.append("  ");
            StringBuilder secAddStrBuilder = new StringBuilder(secondAddition);
            ArrayList<String> secAddList = new ArrayList<>(getListFromStringBuilder(secAddStrBuilder));
            //result = new ArrayList<>(new GoldenRatioOperation(result,secAddList).getAddition());
            GL.setFirst(reg); GL.setSecond(seq);
            GL.getFirst().setNum(result);
            GL.getSecond().setNum(secAddList);
           // GL = new GoldenRatioOperation(result,secAddList);
            
            result = GL.getAddition();
           // result = add(result, s1 + zeroSuffix);
        }
        zeroSuffix.append("0");
    }
    return result;
}
  */ 
     public ArrayList<String> multiplyadd(ArrayList<String> fir, ArrayList<String> sec){
         ArrayList<String> res = new ArrayList<>();
         res.add("0");res.add("0");res.add("0");
         
         ArrayList<String> zerotoEnd = new ArrayList<>();
         for (int i = sec.size() - 1; i >= 0; i--){
             if("1".equals(sec.get(i))){
                 ArrayList<String> secadd = new ArrayList<>(fir);
                 secadd.addAll(zerotoEnd);
                 GoldenRatioOperation gl = new GoldenRatioOperation(res,secadd);
                 gl.normalizeGoldenNumber();
                 res = new ArrayList<>(gl.getAddition());                
             }
             zerotoEnd.add("0");
         }
         
         return res;
     }
     public ArrayList<String> getMultiplication()
     {
         normalizeGoldenNumber();
         ArrayList<String> fir = new ArrayList<>(this.first.getNum());
         ArrayList<String> sec = new ArrayList<>(this.second.getNum());
         
         int mantissa = fir.indexOf(".");
        // fir.remove(".");
        // sec.remove(".");
         //ArrayList<String> result = new ArrayList<>(multiplyadd(fir.toString(),sec.toString()));
         ArrayList<String> result = new ArrayList<>();
         
         
            ArrayList<String> res = new ArrayList<>();
         res.add("0");res.add(".");res.add("0");res.add("0");
         
         ArrayList<String> zerotoEnd = new ArrayList<>();
         for (int i = sec.size() - 1; i >= 0; i--){
             if("1".equals(sec.get(i))){
                 ArrayList<String> secadd = new ArrayList<>(fir);
                 secadd.addAll(zerotoEnd);
                 GoldenRatioOperation gl = new GoldenRatioOperation(res,secadd);
                 gl.normalizeGoldenNumber();
                 res = new ArrayList<>(gl.getAddition());                
             }
             zerotoEnd.add("0");
         }
         
          res =new GoldenRatio().getoutZero(res);
         res = new GoldenRatio().getMinimalForm(res);
        
        if(new FibonachiCheck().checkGoldenNumber(res)) {
        } else {
            System.out.println("Error in Substruction");
        }
         
         return res;
//         result = multiplyadd(fir,sec);
//         return result;                                
     }
  
     //TODO Dont work
     public ArrayList<String> getDivision()
     {
           normalizeGoldenNumber();
         ArrayList<String> first = new ArrayList<>(this.first.getNum());
         ArrayList<String> second = new ArrayList<>(this.second.getNum());
         
         int mantissa = first.indexOf(".");
         first.remove(".");
         second.remove(".");
   
         StringBuilder str1 = new StringBuilder(first.toString());
         int binaryfirst = Integer.parseInt(str1.toString(),2);
         StringBuilder str2 = new StringBuilder(second.toString());
         int binarysecond = Integer.parseInt(str2.toString(),2);
         
         int res = binaryfirst*binarysecond;
         
         StringBuilder strres = new StringBuilder(Integer.toBinaryString(res));
         
         
         ArrayList<String> reslist = new ArrayList<>(getListFromStringBuilder(strres)); 
         mantissa*=2;
         reslist.add(reslist.size()-mantissa-1, ".");
         return reslist;
     }
     
     private static ArrayList<String> getListFromStringBuilder(StringBuilder str)
     {
         ArrayList<String> reslist = new ArrayList<>();
         for(int i=0;i<str.length();i++)
         {  
             reslist.add(String.valueOf(str.charAt(i)));
         }
         return reslist;
     }
     
}
