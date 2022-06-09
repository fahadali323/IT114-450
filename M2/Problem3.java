package M2;

import java.util.Arrays;
import java.util.stream.IntStream;

import javax.lang.model.type.ArrayType;

public class Problem3 {
    public static void main(String[] args) {
        // Don't edit anything here
        Integer[] a1 = new Integer[] { -1, -2, -3, -4, -5, -6, -7, -8, -9, -10 };
        Integer[] a2 = new Integer[] { -1, 1, -2, 2, 3, -3, -4, 5 };
        Double[] a3 = new Double[] { -0.01, -0.0001, -.15 };
        String[] a4 = new String[] { "-1", "2", "-3", "4", "-5", "5", "-6", "6", "-7", "7" };

        bePositive(a1);
        bePositive(a2);
        bePositive(a3);
        bePositive(a4);
    }

    static <T> void bePositive(T[] arr) {
        System.out.println("Processing Array:" + Arrays.toString(arr));
        // your code should set the indexes of this array
        Object[] output = new Object[arr.length];

        // TODO convert each value to positive
        // set the result to the proper index of the output array
        // hint: don't forget to handle the data types properly
        /*
        ucid : fa376
        date: 5/30/22
        explanation: Iterate through the elements in the generic array.
        Then I used if statment where the if the generic array matches 
        one of the type: float, int, double, or long, the code does case by case.
        For instance, if its float, you assin the elements to float, and use 
        math.abs for each floating value in the array and then output that to the 
        output array. This is the same for double and integer.
        However, for string array we set the generic array
        to string array.
        We use regex to remove brackets and comma, and then add the elements 
        to a new int array. For each elements in the int array, we 
        do math.abs() for each element so that each negative value gets positive.
        To ouput the correct data type we use Integer.toString.
        */

        for (int i = 0; i < arr.length; ++i) 
        { 
            if(arr[i] instanceof Integer)
            {
                int d = (int) arr[i];
                int s = Math.abs(d);
                output[i] = s;
            }
            else if(arr[i] instanceof Float)
            {
                float f = (float) arr[i];
                float fs = Math.abs(f);
                output[i]= fs;
            }
            else if(arr[i] instanceof Double)
            {
                double d = ( double) arr[i];
                double fs = Math.abs(d);
                output[i]= fs;
            }
            else if(arr[i] instanceof String)
            {
                String  f = (String) arr[i];
                String[] string = f.replaceAll("\\[", "").replaceAll("]", "").split(",");
                int[] arr3 = new int[string.length];   
                for (int x = 0; x < string.length; x++)
                {
                    arr3[x] = Integer.valueOf(string[x]); 
                    output[i] = Integer.toString(Math.abs(arr3[x]));
                }
            }
        }
        // end edit section
        StringBuilder sb = new StringBuilder();
        for (Object i : output) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(String.format("%s (%s)", i, i.getClass().getSimpleName().substring(0, 1)));
        }
        System.out.println("Result: " + sb.toString());
    }
}
