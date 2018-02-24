package com.haofan.calculator;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;

/**
 * Created by Haofan Hou (B00783052)
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //store calculating result
    private float result = 0;

    private TextView tv;

    //store a calculation
    //calculation[0]=first number, calculation[1]=operator, calculation[2]=second number,
    private float[] calculation = {0,0,0};

    //store the last calculation
    private float[] last_calculation = {0,0,0};

    //store the id of the currently operating View (used to change and recover button color)
    private int view_id = 0;

    //store the initial background of a button (used to recover the button color)
    private int initial_bg;

    //indicate if any number was clicked since last time clicking an operator
    private boolean clicked_num = false;

    //indicate if any operator was clicked since last time clicking an number
    private boolean clicked_ope = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);

        Button btn_ac = findViewById(R.id.btn_ac);
        Button btn_pos_neg = findViewById(R.id.btn_pos_neg);
        Button btn_radical = findViewById(R.id.btn_radical);
        Button btn_divide = findViewById(R.id.btn_divide);

        Button btn_seven = findViewById(R.id.btn_seven);
        Button btn_eight = findViewById(R.id.btn_eight);
        Button btn_nine = findViewById(R.id.btn_nine);
        Button btn_multiple = findViewById(R.id.btn_multiple);

        Button btn_four = findViewById(R.id.btn_four);
        Button btn_five = findViewById(R.id.btn_five);
        Button btn_six = findViewById(R.id.btn_six);
        Button btn_minus = findViewById(R.id.btn_minus);

        Button btn_one = findViewById(R.id.btn_one);
        Button btn_two = findViewById(R.id.btn_two);
        Button btn_three = findViewById(R.id.btn_three);
        Button btn_plus = findViewById(R.id.btn_plus);

        Button btn_clear = findViewById(R.id.btn_clear);
        Button btn_zero = findViewById(R.id.btn_zero);
        Button btn_dot = findViewById(R.id.btn_dot);
        Button btn_equal = findViewById(R.id.btn_equal);

        btn_ac.setOnClickListener(this);
        btn_pos_neg.setOnClickListener(this);
        btn_radical.setOnClickListener(this);
        btn_divide.setOnClickListener(this);

        btn_seven.setOnClickListener(this);
        btn_eight.setOnClickListener(this);
        btn_nine.setOnClickListener(this);
        btn_multiple.setOnClickListener(this);

        btn_four.setOnClickListener(this);
        btn_five.setOnClickListener(this);
        btn_six.setOnClickListener(this);
        btn_minus.setOnClickListener(this);

        btn_one.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_three.setOnClickListener(this);
        btn_plus.setOnClickListener(this);

        btn_clear.setOnClickListener(this);
        btn_zero.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
        btn_equal.setOnClickListener(this);

    }

    public void onClick(View v){

        //When clicking a button, the color changes until clicking the next button
        if (view_id != 0){
            Button previous_bt = findViewById(view_id); //find the last clicked button
            previous_bt.setBackgroundColor(initial_bg); //recover the color of the last clicked button
        }
        initial_bg = ((ColorDrawable)v.getBackground()).getColor(); //record the initial color of the currently clicking button
        v.setBackgroundColor(Color.GRAY);  //change the color of the currently clicking button
        view_id = v.getId();  //record the id of the currently clicking button

        String display = tv.getText().toString().trim(); //get the current content of the text view

        switch (v.getId()){

            //the operations when '1' button clicked.
            case R.id.btn_one:
                clickingNums (display, "1");
                break;
            case R.id.btn_two:
                clickingNums (display, "2");
                break;
            case R.id.btn_three:
                clickingNums (display, "3");
                break;
            case R.id.btn_four:
                clickingNums (display, "4");
                break;
            case R.id.btn_five:
                clickingNums (display, "5");
                break;
            case R.id.btn_six:
                clickingNums (display, "6");
                break;
            case R.id.btn_seven:
                clickingNums (display, "7");
                break;
            case R.id.btn_eight:
                clickingNums (display, "8");
                break;
            case R.id.btn_nine:
                clickingNums (display, "9");
                break;
            case R.id.btn_zero:
                clickingNums (display, "0");
                break;

            //The operations when "+/-" button clicked
            case R.id.btn_pos_neg:
                clicked_num = true;
                clicked_ope = false;
                if (display.equals("0"))
                {
                    display = "-0";
                }else if (display.charAt(0)=='-'){
                    display = display.substring(1, display.length());
                }
                else if (display.length()<10){ //when display is longer than 10 chars, don't print "-"
                    display = "-" + display;
                }
                tv.setText(display);
                break;

            //The operations when "." button clicked
            case R.id.btn_dot:
                clicked_num = true;
                clicked_ope = false;

                //when display is longer than 10 chars or there is already a dot, don't print "."
                if (!display.contains(".") && display.length()<10){
                    display = display + ".";
                }
                tv.setText(display);
                break;

            //The operations when "AC" button clicked
            case R.id.btn_ac:
                for (int i=1;i<3;i++){
                    calculation[i]=0;
                    last_calculation[i]=0;
                }
                tv.setText("0");
                clicked_num = false;
                clicked_ope = false;
                break;

            //The operations when "C" button clicked
            case R.id.btn_clear:
                tv.setText("0");
                clicked_num = false;
                break;

            //The operations when "+" button clicked
            case R.id.btn_plus:
                clickingOperators(display, 1);
                break;
            case R.id.btn_minus:
                clickingOperators(display, 2);
                break;
            case R.id.btn_multiple:
                clickingOperators(display, 3);
                break;
            case R.id.btn_divide:
                clickingOperators(display, 4);
                break;

            //The operations when "=" button clicked
            case R.id.btn_equal:
                clicked_ope = true;

                //if no button has been clicked since last time clicking the "=" button,
                // continue clicking "button" will show the calculating result of the printed number
                // and the second operand with the same operator as the latest calculation
                if (!clicked_num && calculation[1]==0){
                    result = calculateResult(last_calculation);

                    if (checkDecimal(result)){
                        display = Float.toString(result);
                        display = removeZeroAndDot(display);
                    }else {
                        display = Integer.toString((int)result);
                    }
                    tv.setText(display);

                    last_calculation[0] = result;

                }else if (calculation[1]!=0){
                    calculation[2] = Float.parseFloat(display);
                    result = calculateResult(calculation);

                    if (checkDecimal(result)){
                        display = Float.toString(result);
                        display = removeZeroAndDot(display);
                    }else {
                        display = Integer.toString((int)result);
                    }
                    tv.setText(display);

                    //store the just finished calculation
                    last_calculation[0] = result;
                    last_calculation[1] = calculation[1];
                    last_calculation[2] = calculation[2];

                    //reset the calculation
                    calculation[0] = result;
                    calculation[1] = 0;
                    calculation[2] = 0;

                    clicked_num = false;
                }
                break;

            //The operations when "√" button clicked
            case R.id.btn_radical:
                result = (float) Math.sqrt(Float.parseFloat(display));

                if (checkDecimal(result)){
                    display = Float.toString(result);
                    display = removeZeroAndDot(display);
                }else {
                    display = Integer.toString((int)result);
                }
                tv.setText(display);



        }

    }

    //the operations when a number button is clicked
    public void clickingNums (String display, String num){

        clicked_num = true;

        //if an operator was just clicked, reset the screen
        if (clicked_ope){
            display = "0";
            tv.setText(display);
        }
        clicked_ope = false;

        //print the clicked number on the screen
        if (result == 0 && display.equals("0")){
            display = num;
        }else if (result == 0 && !display.equals("0")){
            if (display.equals("-0")){
                display = "-" + num;
            }else {
                display = display + num;
            }
        }else{
            display = num;
            result = 0;
        }
        tv.setText(display);
    }

    //the operations when an operator button is clicked
    public void clickingOperators(String display, int operator){
        clicked_ope = true;
        if (calculation[1]==0){ //if no operator has been clicked
            calculation[0] = Float.parseFloat(display);
            calculation[1] = operator;
            calculation[2] = 0;
//                    tv.setText("0");
            clicked_num = false;
        }else if (!clicked_num){
            //if clicking more than one operator button
            // and no number button has been clicked since last time clicking an operator,
            // the final operator for the calculation will be the latest clicked operator.
            calculation[1] = operator;
        }else{
            //if the calculation already has two operands,
            // clicking another operator button will show the result of the finished calculation first
            // and start the next calculation in the mean time.
            calculation[2] = Float.parseFloat(display);
            result = calculateResult(calculation);

            //if the result has decimal, print the decimal without needless zeros
            if (checkDecimal(result)){
                display = Float.toString(result);
                display = removeZeroAndDot(display);
            }else { //if the result has no decimal, print the int
                display = Integer.toString((int)result);
            }
            tv.setText(display);

            //start the next calculation
            calculation[0] = result;
            calculation[1] = operator;
            calculation[2] = 0;

            clicked_num = false;
        }
    }

    //calculating the result of the input calculation
    public float calculateResult(float cal[]){

        float result = 0;

        try{
            if (cal[1]==1){
                result = cal[0] + cal[2];
            }else if (cal[1]==2){
                result = cal[0] - cal[2];
            }else if (cal[1]==3){
                result = cal[0] * cal[2];
            }else if (cal[1]==4){
                result = cal[0] / cal[2];
            }
        }catch (Exception e){
            System.out.println("Error: " + e);
        }

        return result;
    }

    //check if a number has decimal part
    public boolean checkDecimal(float num){

        return num - (int) num != 0;
    }

    //remove the needless zero and dot
    public String removeZeroAndDot(String str){

        //The string after "E"
        String str_afterE ="";

        //When the decimal is longer than 10 chars, remove the excess part
        if (str.length()>10){

            //make sure the exponent will be completely shown
            if (str.contains("E")){
                System.out.println("xxx"+str);
                str = str.substring(0, 7) + str.substring(str.indexOf("E"),str.length());
            }else {
                str=str.substring(0,10);
            }

        }

        if (str.contains("E")){
            str_afterE = str.substring(str.indexOf("E"), str.length());
            str = str.substring(0,str.indexOf("E"));
        }

        //remove the needless zero and dot
        for (int i= str.length()-1; i>0; i--){
            if (str.charAt(i)=='0' || str.charAt(i)=='.'){
                str=str.substring(0,i-1);
                i--;
            }else {
                break;
            }
        }

        if (!str_afterE.equals("")){
            str = str + str_afterE;
        }

        return str;
    }

}
