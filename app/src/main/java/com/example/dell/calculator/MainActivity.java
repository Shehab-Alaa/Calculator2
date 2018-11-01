package com.example.dell.calculator;

import android.support.annotation.ColorRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button zero , one , two , three , four , five , six , seven , eight ,
    nine , dot , c_btn , ce_btn , mult , div , min , plus , equal ;
    private TextView calc_text , ans_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zero = (Button)findViewById(R.id.zero_btn);
        one = (Button)findViewById(R.id.one_btn);
        two = (Button)findViewById(R.id.two_btn);
        three = (Button)findViewById(R.id.three_btn);
        four = (Button)findViewById(R.id.four_btn);
        five = (Button)findViewById(R.id.five_btn);
        six = (Button)findViewById(R.id.six_btn);
        seven = (Button)findViewById(R.id.seven_btn);
        eight = (Button)findViewById(R.id.eight_btn);
        nine = (Button)findViewById(R.id.nine_btn);

        c_btn = (Button)findViewById(R.id.c_btn);
        ce_btn = (Button)findViewById(R.id.del_btn);

        mult = (Button)findViewById(R.id.mult_btn);
        div = (Button)findViewById(R.id.div_btn);
        plus = (Button)findViewById(R.id.plus_btn);
        min = (Button)findViewById(R.id.minus_btn);

        dot = (Button)findViewById(R.id.dot_btn);

        equal = (Button)findViewById(R.id.equal_btn);

        calc_text = (TextView) findViewById(R.id.edit_calc);
        ans_text = (TextView)findViewById(R.id.answer_text);

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (check_2())
               calc_text.append(".");
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                calc_text.append("0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                calc_text.append("1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                calc_text.append("2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                calc_text.append("3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                calc_text.append("4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                calc_text.append("5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                calc_text.append("6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                calc_text.append("7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                calc_text.append("8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                calc_text.append("9");
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check_2())
                calc_text.append("/");
            }
        });
        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check_2())
                calc_text.append("-");
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check_2())
                calc_text.append("+");
            }
        });
        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check_2())
                calc_text.append("*");
            }
        });

        c_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                calc_text.setText("");
            }
        });
        ce_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(ans_text.getText().toString().isEmpty()))
                    ans_text.setText("");

                String temp = calc_text.getText().toString();
                if (!(temp.isEmpty()))
                {
                    temp = temp.substring(0, temp.length() - 1);
                    calc_text.setText(temp);
                }
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = calc_text.getText().toString();
                if (check_2())
                  calculation(input);
            }
        });

    }
    public void calculation(String input)
    {
        PostfixConversion pc = new PostfixConversion();
        ArrayList<String> temp = pc.conversion(input);
        CalculatorSystem cs = new CalculatorSystem(temp);
        String result = cs.calculator();
        double num = 1.5;
        try {
            num = Double.parseDouble(result);
        }catch (Exception e)
        {}
        int num2 = (int) num ;
        if (num2 == num)
            ans_text.setText("= " + String.valueOf(num2));
        else
            ans_text.setText("= " + result);
    }

    public void check()
    {
        if (!(ans_text.getText().toString().isEmpty())) {
            ans_text.setText("");
            calc_text.setText("");
        }
    }

    public boolean check_2()
    {
        String check = calc_text.getText().toString();
        char temp[] = check.toCharArray();
        if (temp.length >= 1 && temp[temp.length-1] != '+' && temp[temp.length-1] != '-' &&
                temp[temp.length-1] != '/' && temp[temp.length-1] != '*'
                && temp[temp.length-1] != '.' && ans_text.getText().toString().isEmpty()==true)
               return true;
        return false;
    }
}
