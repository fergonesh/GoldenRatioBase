
package goldenratio;

import java.util.ArrayList;

/**
 *
 * @author pasha
 */
public class FibonachiCheck {
    
    public FibonachiCheck(){
        
    }
    
    public int getPosFibNumByIndex(int index){
        if (index <0)
            return -1;
        if (index ==0)
            return 0;
        if (index == 1 || index ==2)
            return 1;
        
        int num1 = 1;
        int num2 = 1;
        int res=0;
        for(int i=3; i<=index;i++)
        {
            res = num1+num2;
            num2 = num1;
            num1 = res;
        }
        return res;
    }
    
    public int getNegFibNumByIndex(int index){
        if (index <0)
            return -1;
        if (index ==0)
            return 0;
         if (index == 2)
            return -1;
        if (index == 1)
            return 1;        
        
        int num1 = 1;
        int num2 = 1;
        int res=0;
        for(int i=1; i<=index-2;i++)
        {
            res = num1+num2;
            num2 = num1;
            num1 = res;
        }
        if (index%2==0)
            return -res;
        else
            return res;        
    }
    
    public boolean checkGoldenNumber(ArrayList<String> list){
        boolean res = false;
        int sum = 0;
        for(int i =0;i<list.indexOf(".");i++)
        {
            if("1".equals(list.get(i)))
                sum+=getPosFibNumByIndex(list.indexOf(".")-i-1);
        }
        for(int i =list.indexOf(".")+1;i<list.size();i++){
            if("1".equals(list.get(i)))
                sum+=getNegFibNumByIndex(i-list.indexOf("."));
        }
        if (sum == 0)
            res =true;
        return res;
        
    }
}
