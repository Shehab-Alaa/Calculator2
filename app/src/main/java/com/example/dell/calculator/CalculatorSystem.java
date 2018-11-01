package com.example.dell.calculator;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by dell on 10/31/2018.
 */

public class CalculatorSystem {

    ArrayList<String> expression;
    Stack<String> holder ;
    String first , second;
    double num1 , num2;

    CalculatorSystem(ArrayList<String> in)
    {
        expression = in;
        holder  = new Stack<>();
        first = "";
        second = "";
    }


    public String calculator()
    {
      for (int i =0;i<expression.size();i++)
      {
          String operator = expression.get(i);
          if (operator.equals("*") || operator.equals("/") || operator.equals("+") || operator.equals("-"))
          {
              first = holder.peek();
              num1 = Double.parseDouble(first);
              holder.pop();
              second = holder.peek();
              num2 = Double.parseDouble(second);
              holder.pop();
              String temp = calc(num1 , num2 , operator);
              holder.add(temp);
          }
          else {
              holder.add(expression.get(i));
          }
      }

      return holder.peek();
    }

    public static String calc(double a , double b , String op)
    {
        switch (op)
        {
            case "*":
                return String.valueOf(a*b);
            case "/":
                if (a==0)
                    return "MATH ERROR";
                return String.valueOf(b / a);
            case "+":
                return String.valueOf(a+b);
            case "-":
                return String.valueOf(b - a);
        }
        return "MATH ERROR";
    }

}
