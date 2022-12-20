import java.util.*;

public class Number_system
{
     public static Scanner ip  = new Scanner(System.in);

    public static boolean special_char(String num)
    {
        {
            int i=1;
            while(i<num.length())
            {
            if(!Character.isDigit(num.charAt(i)))
            {
                System.out.println("Enter valid string without any special character...");
                return false;
            }
            i++;
            }
            }
    
            if(!(num.charAt(0)=='-') || Character.isDigit(0))
            {
                System.out.println("Enter valid string without any special character...");
                return false;
            }
            
        return true;
    }
    public static void dec_bin () 
    {
        System.out.print("Enter Decimal Number ");
        ip.nextLine();
        String  num= ip.nextLine();
        // System.out.println(num);

        if(!special_char(num)) return;

        if(!num.contains("."))
        num= num.concat(".0");
        
      
        // String ss="10.10";
        int n=0;

        String[] split_num= num.split("[.]",2);
      
    //     for(int i=0;i<split_num.length;i++)
    //    System.out.println(split_num[i]);

        String num_1=split_num[0];
        String num_2=split_num[1];

        boolean neg_flag=false;
        if(num_1.charAt(0)=='-')
        neg_flag=true;

        // System.out.println(" num 1 is "+num_1);
        // System.out.println(" num 2 is "+num_2);

        for(int i=0;i<num_1.length();i++)
        {
            for(int j=0;j<10;j++)
            {   
                char[] c_num = new char[]{'0','1','2','3','4','5','6','7','8','9'};    
                if(c_num[j]==num_1.charAt(i))
                {   
                    n+=j*Math.pow(10, num_1.length()-1-i) ;;
                    break;
                }
            }
        }

        String ans="";
        // System.out.println(" n is "+n);
        
        while(true)
        {   
            if(n%2==0)
            {
                ans+='0';
            }
            else
            {
                ans+='1';
            }

            n/=2;

            if(n==0)
            break;

        }

        StringBuffer sbr = new StringBuffer(ans);
        sbr.reverse();

        // System.out.println(" Binary Number is "+sbr);

        double n2=0.0;

        // System.out.println("num2 length"+num_2.length());

        for(int i=num_2.length();i>0;i--)
        {
            for(int j=0;j<10;j++)
            {   
                char[] c_num = new char[]{'0','1','2','3','4','5','6','7','8','9'};    
                if(c_num[j]==num_2.charAt(i-1))
                {   
                    n2+=j*Math.pow(10, (i)*(-1)) ;
                    break;
                }
            }
        }

        String d_ans="";

        System.out.println(" n2 is "+n2);

        System.out.println();

        int place=5;

        for(int i=0;i<place;i++)
        {   
            n2=(n2*2);
            System.out.println();
            System.out.println(" n2*2 "+n2);

            int dec_ans= (int)n2;
            d_ans+=dec_ans;
            n2=Math.abs(dec_ans-n2);

            System.out.println(" int n2 "+dec_ans);
        }

        sbr.append(".");
        sbr.append(d_ans);

        if(neg_flag)
        {
            sbr.insert(0, '-');
        }

        System.out.println(" dec ans = "+sbr);
    }
       


    public static void bin_dec()
    {
        System.out.print("Enter Binary Number ");
        ip.nextLine();
        String  num= ip.nextLine();

        if(!special_char(num)) return;
        
            
        if(!num.contains("."))
        num= num.concat(".0");

        // System.out.println(num);
        // String ss="10.10";
        

        String[] split_num= num.split("[.]",2);
      
    //     for(int i=0;i<split_num.length;i++)
    //    System.out.println(split_num[i]);

        String num_1=split_num[0];
        String num_2=split_num[1];

        System.out.println(" num 1 is "+num_1);
        System.out.println(" num 2 is "+num_2);

        boolean neg_flag=false;
        if(num_1.charAt(0)=='-')
        neg_flag=true;

        double s=0.0;
        for(int i=0; i<num_1.length();i++)
        {   
            
            int c=0;

            if(num_1.charAt(num_1.length()-i-1)=='1') c=1;

           // System.out.println(Math.pow(2,i)*c);
           s+=(Math.pow(2,i)*c);

        }

        for(int i=num_2.length();i>0;i--)
        {
              
                   int c=0;
                if(num_2.charAt(i-1)=='1') 
                c=1;
                s+=c*Math.pow(2, (i)*(-1)) ;
                   
                
            
        }

        if(neg_flag) s*=(-1);

        System.out.println(" Decimal Number is "+s);
    }


    public static void main(String[] arg)
    { 
        
        while(true)
        {System.out.println();
        System.out.println("Number System");
        System.out.println();
        System.out.println(" 1) Decimal To Binary ");
        System.out.println(" 2) Binary To Decimal ");
        System.out.println(" 0) Exit ");
        System.out.println(" Enter Option");
            
        int n = ip.nextInt();
        switch(n)
        {
            case 1:dec_bin();
                    break;
            
            case 2:bin_dec();
                    break;

            case 0: System.out.println("Exiting...");
                    System.exit(0);       

            default: System.out.println("Enter valid choice.....");
        }
        
    }
    
    }
}