import java.text.DecimalFormat;
import java.util.Arrays;

public class Problem2 {
    public static void main(String[] args) {
        // Don't edit anything here
        double[] a1 = new double[] { 10.001, 11.591, 0.011, 5.991, 16.121, 0.131, 100.981, 1.001 };
        double[] a2 = new double[] { 1.99, 1.99, 0.99, 1.99, 0.99, 1.99, 0.99, 0.99 };
        double[] a3 = new double[] { 0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01 };
        double[] a4 = new double[] { 10.01, -12.22, 0.23, 19.20, -5.13, 3.12 };

        getTotal(a1);
        getTotal(a2);
        getTotal(a3);
        getTotal(a4);
    }

    static void getTotal(double[] arr){
        System.out.println("Processing Array:" + Arrays.toString(arr));
        double total = 0;
        String totalOutput = "";
        //TODO add/edit code here
        //set the double to a string variable
        /*
        ucid : fa376
        date: 5/30/22
        explanation: Since there is a double variable total initialized to 
        0, I used this variable to find the total sum of all the elements in 
        the array passed in the parameter. I iterate through the array by
        adding each element to total=total+arr[i].
        So for every new element gets added to the previous total. 
        For roundoff to two decimal places I used a variable called 
        double roundoff and used the formula (double) Math.round(total * 100) / 100; 
        where the total * 100 is 
        rounded which then gets divided by 100. Since the roundoff is double,
        I did totalOutput = String.valueof(roundOff+"") which typecasts 
        double roundoff to string value and stores that value in the variable 
        totalOutput. 
        */
        for (int i = 0; i < arr.length; i++) 
        {  
            total = total + arr[i];  
        }  
        double roundOff = (double) Math.round(total * 100) / 100;
       DecimalFormat df = new DecimalFormat("#0.00");
        totalOutput = df.format(roundOff)+"";
        // totalOutput = String.valueOf(roundOff+"");
        //end add/edit section
        System.out.println("Total is " + totalOutput);
        System.out.println("End process");
    }

}
