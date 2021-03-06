package goldenratio;

import java.util.ArrayList;

/**
 *
 * @author pasha
 */
public class GoldenRatio {
    
    private ArrayList<String> num;
    private final static double PHI = (Math.sqrt(5)+1)/2;
    
    public GoldenRatio(ArrayList a)
    {
        this.num = new ArrayList<>(a);
    }
    
    public GoldenRatio(){
    }

    public void setNum(ArrayList<String> num) {
        this.num = num;
    }
    
    

    public ArrayList<String> getGoldenNumFromDecimal(double dec)
    {
       //check sign
        boolean sign =true;
        if (dec<0){
            sign =false;
            dec=-dec;
        }
        
        ArrayList<String> reslist = new ArrayList<>();
        double rec2 = Math.log(dec)/Math.log(PHI);
        int rec = (int)rec2; 
        
        for(int i =rec;i>=0;i--)
        {
            double check = Math.pow(PHI, i);
            if(dec>=Math.pow(PHI, i))
            {
                reslist.add("1");
                dec-=Math.pow(PHI, i);
            }
            else
            {
                reslist.add("0");
            }

        }
        reslist.add(".");
        rec=1;
        double ge =0.01;
        while(dec>ge)
        {
            
            double check = round(1./Math.pow(PHI,rec),rec); 
            if(dec>=check)
            {
               reslist.add("1");
               dec-=1/Math.pow(PHI,rec);
            }
            else
            {
                reslist.add("0");
            }
            rec++;
            ge*=0.01;
        }
         if(new FibonachiCheck().checkGoldenNumber(reslist)) {
        } else {
            System.out.println("Error in getGoldenNumberFromDecimal");
        }
         getMinimalForm(reslist);
         getoutZero(reslist);
         if (!sign){
             reslist.add(0,"-");
         }
        return reslist;
    }
    
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
}
    public double getDecimalNumFromGolden(ArrayList<String> gold)
    {

        double res=0;
        int plusOrminus = 1;
        if(gold.contains("-"))
        {
            gold.remove("-");
            plusOrminus = -1;
        }
           
        for(int i=0; i<=gold.indexOf(".") ;i++)
        {
            if("1".equals(gold.get(i)))
            {
                int pow = gold.indexOf(".")-i-1;
                res+=Math.pow(PHI, pow);
            }                
        }
        for(int i=gold.indexOf("."); i<gold.size(); i++)
        {
            if("1".equals(gold.get(i)))
            {
                int pow = gold.indexOf(".")-i;
                res+=Math.pow(PHI, pow);
            } 
        }
        
        return round((res*plusOrminus),5);
    }

    public ArrayList<String> getNum() {
        return num;
    }
    
     public ArrayList<String> getMinimalForm(ArrayList<String> num)
    {
        if (num.size()<4){
            return num;
        }
        int pointPos=0;
        if (num.contains("."))
        {
            pointPos = num.indexOf(".")+1;
            num.remove(".");
            
        }
        if("1".equals(num.get(0)) && "1".equals(num.get(1)))
        {
            num.set(0,"0");
            num.set(1,"0");
            num.add(0, "1");
            if (pointPos!=0)
                pointPos++;
        }
        for(int i=1;i<num.size()-1;i++)
        {
            if("1".equals(num.get(i)) && "1".equals(num.get(i+1)))
            {
                num.set(i-1, "1");
                num.set(i,"0");
                num.set(i+1,"0");
                i++;
                
            }   
        }

        for(int i =0;i<num.size()-1;i++)
        {
            if("1".equals(num.get(i)) && "1".equals(num.get(i+1)))
            {
                getMinimalForm(num); 
                break;
            }
        }
        
        if(pointPos!=0)
            num.add(pointPos-1,".");
        return num;  
    }
    
    public ArrayList<String> getMaximumFrom(ArrayList<String> num)
    {
        int pointPos=0;
        if (num.contains("."))
        {
            pointPos = num.indexOf(".")+1;
            num.remove(".");
            
        }
        for(int i=0;i<num.size()-2;i++)
        {
            if("1".equals(num.get(i)) && "0".equals(num.get(i+1)) && "0".equals(num.get(i+2)))
            {
                num.set(i,"0");
                num.set(i+1,"1");
                num.set(i+2,"1");               
                i++;
            }
        }
        if (pointPos!=0)
        {
            num.add(pointPos-1,".");
        }
        return num;
    }
  
    public int getPoint(ArrayList<String> list)
    {
        int res = list.indexOf(".");
        return res;
    }
    
    private ArrayList<String> getListWithNoPoint(ArrayList<String> list)
    {
        list.remove(".");
        return list;
    }
            
     //true if a>=b and false if a<b;
    public boolean getComparison(ArrayList<String> a,ArrayList<String> b)
    {
        boolean res = true;
        if(a.size()>b.size())
            res = true;
        else if (a.size()<b.size())
            res =false;
        else if (a.size()==b.size())
        {
            for(int i=0;i<a.size();i++)
                if (a.get(i)!=b.get(i) )
                {
                    res = Integer.parseInt(a.get(i))>Integer.parseInt(b.get(i)) ? true : false;
                    break;
                }
        }
        return res;
    }
    
       //lead to needed size
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
    
    //get out zero from begining and ending
    public ArrayList<String> getoutZero(ArrayList<String> list){
        
        if(".".equals(list.get(list.size()-1))){
            list.add("0");
            list.add("0");
        }
        
        while("0".equals(list.get(0)) && !(".".equals(list.get(1))))
            list.remove(0);
        
        while("0".equals(list.get(list.size()-1)) && !(".".equals(list.get(list.size()-3))) && !".".equals(list.get(list.size()-3)))
            list.remove(list.size()-1);

        return list;
    }
}
