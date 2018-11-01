package com.example.dell.calculator;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by dell on 10/31/2018.
 */

public class PostfixConversion {

    int index ;
    int lastIndex ;
    Stack<Character> holder ;
    ArrayList<String> expression ;

    PostfixConversion()
    {
        index = 0;
        lastIndex = 0;
        holder = new Stack<>();
        expression = new ArrayList<>();
    }

    public static int precedence(char c)
    {
        switch (c)
        {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    public ArrayList<String> conversion(String input)
    {
        char temp[] = input.toCharArray();
        for (int i=0;i<input.length();i++)
        {
            if (temp[i] == '*' || temp[i] == '/' || temp[i] == '+' || temp[i] == '-')
            {
                index = i;
                String str = input.substring(lastIndex , index);
                expression.add(str);
                lastIndex = index +1;

                if (temp[i] == '*' || temp[i]== '/')
                {
                    if (!holder.empty() && precedence(temp[i]) == precedence(holder.peek()))
                    {
                        while (!holder.empty())
                        {
                            expression.add(holder.peek().toString());
                            holder.pop();
                        }
                    }
                }
                else if (temp[i] == '+' || temp[i]== '-')
                {
                    if ( !holder.empty() && precedence(temp[i]) <= precedence(holder.peek()))
                    {
                        while (!holder.empty())
                        {
                            expression.add(holder.peek().toString());
                            holder.pop();
                        }
                    }
                }
                holder.add(temp[i]);
            }
        }
        expression.add(input.substring(lastIndex , input.length()));
        while (!holder.empty())
        {
            expression.add(holder.peek().toString());
            holder.pop();
        }

        return expression;
    }

}
