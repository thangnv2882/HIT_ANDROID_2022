package com.hitandroid.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private TextView demo;
    private ImageView del, phanx, square, sqrt;

    private String input, demoInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
        demo = findViewById(R.id.demo);
        del = findViewById(R.id.del);
        phanx = findViewById(R.id.phanx);
        square = findViewById(R.id.square);
        sqrt = findViewById(R.id.sqrt);

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input.length() > 0) {
                    String newInput = input.substring(0, input.length() - 1);
                    input = newInput;
                    result.setText(input);
                }
            }
        });

        phanx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Solve();
                demoInput = "1/" + input + "=";
                input = (1/Double.parseDouble(input))+"";
                checkDot();
                result.setText(input);
                demo.setText(demoInput);
            }
        });

        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Solve();
                demoInput = input + "^2=";
                input = Math.pow(Double.parseDouble(input), 2)+"";
                checkDot();
                result.setText(input);
                demo.setText(demoInput);
            }
        });

        sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input != "") {
                    Solve();
                    demoInput = "Sqrt(" + input + ")=";
                    input = Math.sqrt(Double.parseDouble(input))+"";
                    checkDot();
                    result.setText(input);
                    demo.setText(demoInput);
                }
                else {

                }
            }
        });

    }

    public void ButtonClick(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();
        if(input == "0") {
            input = "";
        }

        switch (data) {

            case "C":
                input = "0";
                demoInput = "";
                break;
            case "X":
                Solve();
                input+="*";
                break;

            case "=":
                Solve();
                break;
            case "%":
                demoInput = input + "/100=";
                input = (Double.parseDouble(input)/100)+"";
                break;
            default:
                if (input == null) {
                    input = "";
                }
                if (data.equals("+") || data.equals("-") || data.equals("/")) {
                    Solve();
                }
                input += data;

        }
        result.setText(input);
        demo.setText(demoInput);
    }

    public void Solve() {
        if (input.split("\\+").length == 2) {
            String number[] = input.split("\\+");
            try {
                double add = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = add+"";
                demoInput = number[0] + "+" + number[1] + "=";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (input.split("\\-").length == 2) {
            String number[] = input.split("\\-");
            try {
                double sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                input = sub+"";
                demoInput = number[0] + "-" + number[1] + "=";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (input.split("\\-").length == 3) {
            String number[] = input.split("\\-");
            try {
                double sub = -(Math.abs(Double.parseDouble(number[1])) + Math.abs(Double.parseDouble(number[2])));
                input = sub+"";
                demoInput = "-" + number[1] + "-" + number[2] + "=";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (input.split("\\*").length == 2) {
            String number[] = input.split("\\*");
            try {
                double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input = mul+"";
                demoInput = number[0] + "*" + number[1] + "=";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (input.split("\\/").length == 2) {
            String number[] = input.split("\\/");
            try {
                double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input = div+"";
                demoInput = number[0] + "/" + number[1] + "=";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        checkDot();
    }
    public void checkDot() {
        String dot[] = input.split("\\.");
        if(dot.length > 1) {
            if(dot[1].equals("0")) {
                input = dot[0];
            }
        }
    }
}