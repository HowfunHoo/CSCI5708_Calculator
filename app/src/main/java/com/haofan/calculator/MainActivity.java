package com.haofan.calculator;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private float result = 0;
    private TextView tv;
    private float[] calculation = {0,0,0};
    private float[] last_calculation = {0,0,0};
    private int view_id = 0;
    private int initial_bg;

    //indicate if any number was clicked since last time clicking an operator
    private boolean clicked_num = false;

    //indicate if any operator was clicked since last time clicking an number
    private boolean clicked_ope = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.textView);

        Button btn_ac = (Button)findViewById(R.id.btn_ac);
        Button btn_pos_neg = (Button)findViewById(R.id.btn_pos_neg);
        Button btn_radical = (Button)findViewById(R.id.btn_radical);
        Button btn_divide = (Button)findViewById(R.id.btn_divide);

        Button btn_seven = (Button)findViewById(R.id.btn_seven);
        Button btn_eight = (Button)findViewById(R.id.btn_eight);
        Button btn_nine = (Button)findViewById(R.id.btn_nine);
        Button btn_multiple = (Button)findViewById(R.id.btn_multiple);

        Button btn_four = (Button)findViewById(R.id.btn_four);
        Button btn_five = (Button)findViewById(R.id.btn_five);
        Button btn_six = (Button)findViewById(R.id.btn_six);
        Button btn_minus = (Button)findViewById(R.id.btn_minus);

        Button btn_one = (Button)findViewById(R.id.btn_one);
        Button btn_two = (Button)findViewById(R.id.btn_two);
        Button btn_three = (Button)findViewById(R.id.btn_three);
        Button btn_plus = (Button)findViewById(R.id.btn_plus);

        Button btn_clear = (Button)findViewById(R.id.btn_clear);
        Button btn_zero = (Button)findViewById(R.id.btn_zero);
        Button btn_dot = (Button)findViewById(R.id.btn_dot);
        Button btn_equal = (Button)findViewById(R.id.btn_equal);

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
            Button previous_bt = (Button)findViewById(view_id);
            previous_bt.setBackgroundColor(initial_bg);
        }
        initial_bg = ((ColorDrawable)v.getBackground()).getColor();
        v.setBackgroundColor(Color.GRAY);
        view_id = v.getId();

        String display = tv.getText().toString().trim();

        switch (v.getId()){
            case R.id.btn_one:
                clicked_num = true;
                if (clicked_ope){
                    display = "0";
                    tv.setText(display);
                }
                clicked_ope = false;
                if (result == 0 && display.equals("0")){
                    display = "1";
                }else if (result == 0 && !display.equals("0")){
                    display = display + "1";
                }else{
                    display = "1";
                    result = 0;
                }
                tv.setText(display);
                break;
            case R.id.btn_two:
                clicked_num = true;
                if (clicked_ope){
                    display = "0";
                    tv.setText(display);
                }
                clicked_ope = false;
                if (result == 0 && display.equals("0")){
                    display = "2";
                }else if (result == 0 && !display.equals("0")){
                    display = display + "2";
                }else{
                    display = "2";
                    result = 0;
                }
                tv.setText(display);
                break;
            case R.id.btn_three:
                clicked_num = true;
                if (clicked_ope){
                    display = "0";
                    tv.setText(display);
                }
                clicked_ope = false;
                if (result == 0 && display.equals("0")){
                    display = "3";
                }else if (result == 0 && !display.equals("0")){
                    display = display + "3";
                }else{
                    display = "3";
                    result = 0;
                }
                tv.setText(display);
                break;
            case R.id.btn_four:
                clicked_num = true;
                if (clicked_ope){
                    display = "0";
                    tv.setText(display);
                }
                clicked_ope = false;
                if (result == 0 && display.equals("0")){
                    display = "4";
                }else if (result == 0 && !display.equals("0")){
                    display = display + "4";
                }else{
                    display = "4";
                    result = 0;
                }
                tv.setText(display);
                break;
            case R.id.btn_five:
                clicked_num = true;
                if (clicked_ope){
                    display = "0";
                    tv.setText(display);
                }
                clicked_ope = false;
                if (result == 0 && display.equals("0")){
                    display = "5";
                }else if (result == 0 && !display.equals("0")){
                    display = display + "5";
                }else{
                    display = "5";
                    result = 0;
                }
                tv.setText(display);
                break;
            case R.id.btn_six:
                clicked_num = true;
                if (clicked_ope){
                    display = "0";
                    tv.setText(display);
                }
                clicked_ope = false;
                if (result == 0 && display.equals("0")){
                    display = "6";
                }else if (result == 0 && !display.equals("0")){
                    display = display + "6";
                }else{
                    display = "6";
                    result = 0;
                }
                tv.setText(display);
                break;
            case R.id.btn_seven:
                clicked_num = true;
                if (clicked_ope){
                    display = "0";
                    tv.setText(display);
                }
                clicked_ope = false;
                if (result == 0 && display.equals("0")){
                    display = "7";
                }else if (result == 0 && !display.equals("0")){
                    display = display + "7";
                }else{
                    display = "7";
                    result = 0;
                }
                tv.setText(display);
                break;
            case R.id.btn_eight:
                clicked_num = true;
                if (clicked_ope){
                    display = "0";
                    tv.setText(display);
                }
                clicked_ope = false;
                if (result == 0 && display.equals("0")){
                    display = "8";
                }else if (result == 0 && !display.equals("0")){
                    display = display + "8";
                }else{
                    display = "8";
                    result = 0;
                }
                tv.setText(display);
                break;
            case R.id.btn_nine:
                clicked_num = true;
                if (clicked_ope){
                    display = "0";
                    tv.setText(display);
                }
                clicked_ope = false;
                if (result == 0 && display.equals("0")){
                    display = "9";
                }else if (result == 0 && !display.equals("0")){
                    display = display + "9";
                }else{
                    display = "9";
                    result = 0;
                }
                tv.setText(display);
                break;
            case R.id.btn_zero:
                clicked_num = true;
                if (clicked_ope){
                    display = "0";
                    tv.setText(display);
                }
                clicked_ope = false;
                if (result == 0 && display.equals("0")){
                    display = "0";
                }else if (result == 0 && !display.equals("0")){
                    display = display + "0";
                }else{
                    display = "0";
                    result = 0;
                }
                tv.setText(display);
                break;
            case R.id.btn_pos_neg:
                clicked_num = true;
                clicked_ope = false;
                if (display.equals("0"))
                {
                    display = "-0";
                }else if (display.charAt(0)=='-'){
                    display = display.substring(1, display.length());
                }
                else if (display.length()<10){
                    display = "-" + display;
                }
                tv.setText(display);
                break;
            case R.id.btn_dot:
                clicked_num = true;
                clicked_ope = false;
                if (!display.contains(".") && display.length()<10){
                    display = display + ".";
                }
                tv.setText(display);
                break;
            case R.id.btn_ac:
                for (int i=1;i<3;i++){
                    calculation[i]=0;
                    last_calculation[i]=0;
                }
                tv.setText("0");
                clicked_num = false;
                clicked_ope = false;
                break;
            case R.id.btn_clear:
                tv.setText("0");
                clicked_num = false;
                break;
            case R.id.btn_plus:
                clicked_ope = true;
                if (calculation[1]==0){
                    calculation[0] = Float.parseFloat(display);
                    calculation[1] = 1;
                    calculation[2] = 0;
//                    tv.setText("0");
                    clicked_num = false;
                }else if (!clicked_num){
                    calculation[1] = 1;
                }else{
                    calculation[2] = Float.parseFloat(display);
                    result = CalculateResult(calculation);
                    if (CheckDecimal(result)){
                        display = Float.toString(result);
                        display = removeZeroAndDot(display);
                    }else {
                        display = Integer.toString((int)result);
                    }
//                    display = new BigDecimal(String.valueOf(result)).stripTrailingZeros().toString();
//                    display = Float.toString(result);
//                    display = removeZeroAndDot(display);
                    tv.setText(display);

                    calculation[0] = result;
                    calculation[1] = 1;
                    calculation[2] = 0;
                    clicked_num = false;
                }
                break;
            case R.id.btn_minus:
                clicked_ope = true;
                if (calculation[1]==0){
                    calculation[0] = Float.parseFloat(display);
                    calculation[1] = 2;
                    calculation[2] = 0;
//                    tv.setText("0");
                    clicked_num = false;
                }else if (!clicked_num){
                    calculation[1] = 2;
                }else{
                    calculation[2] = Float.parseFloat(display);
                    result = CalculateResult(calculation);
                    if (CheckDecimal(result)){
                        display = Float.toString(result);
                        display = removeZeroAndDot(display);
                    }else {
                        display = Integer.toString((int)result);
                    }
//                    display = new BigDecimal(String.valueOf(result)).stripTrailingZeros().toString();
//                    display = Float.toString(result);
//                    display = removeZeroAndDot(display);
                    tv.setText(display);

                    calculation[0] = result;
                    calculation[1] = 2;
                    calculation[2] = 0;
                    clicked_num = false;
                }
                break;
            case R.id.btn_multiple:
                clicked_ope = true;
                if (calculation[1]==0){
                    calculation[0] = Float.parseFloat(display);
                    calculation[1] = 3;
                    calculation[2] = 0;
//                    tv.setText("0");
                    clicked_num = false;
                }else if (!clicked_num){
                    calculation[1] = 3;
                }else{
                    calculation[2] = Float.parseFloat(display);
                    result = CalculateResult(calculation);

                    if (CheckDecimal(result)){
                        display = Float.toString(result);
                        display = removeZeroAndDot(display);
                    }else {
                        display = Integer.toString((int)result);
                    }
                    tv.setText(display);

                    calculation[0] = result;
                    calculation[1] = 3;
                    calculation[2] = 0;

                    clicked_num = false;
                }
                break;
            case R.id.btn_divide:
                clicked_ope = true;
                if (calculation[1]==0){
                    calculation[0] = Float.parseFloat(display);
                    calculation[1] = 4;
                    calculation[2] = 0;
//                    tv.setText("0");
                    clicked_num = false;
                }else if (!clicked_num){
                    calculation[1] = 4;
                }else{
                    calculation[2] = Float.parseFloat(display);
                    result = CalculateResult(calculation);

                    if (CheckDecimal(result)){
                        display = Float.toString(result);
                        display = removeZeroAndDot(display);
                    }else {
                        display = Integer.toString((int)result);
                    }
                    tv.setText(display);

                    calculation[0] = result;
                    calculation[1] = 4;
                    calculation[2] = 0;

                    clicked_num = false;
                }
                break;
            case R.id.btn_equal:
                clicked_ope = true;
                if (!clicked_num && calculation[1]==0){
                    result = CalculateResult(last_calculation);

                    if (CheckDecimal(result)){
                        display = Float.toString(result);
                        display = removeZeroAndDot(display);
                    }else {
                        display = Integer.toString((int)result);
                    }
                    tv.setText(display);

                    last_calculation[0] = result;

                }else if (calculation[1]!=0){
                    calculation[2] = Float.parseFloat(display);
                    result = CalculateResult(calculation);

                    if (CheckDecimal(result)){
                        display = Float.toString(result);
                        display = removeZeroAndDot(display);
                    }else {
                        display = Integer.toString((int)result);
                    }
                    tv.setText(display);

                    last_calculation[0] = result;
                    last_calculation[1] = calculation[1];
                    last_calculation[2] = calculation[2];

                    calculation[0] = result;
                    calculation[1] = 0;
                    calculation[2] = 0;

                    clicked_num = false;
                }
                break;
            case R.id.btn_radical:
                result = (float) Math.sqrt(Float.parseFloat(display));

                if (CheckDecimal(result)){
                    display = Float.toString(result);
                    display = removeZeroAndDot(display);
                }else {
                    display = Integer.toString((int)result);
                }
                tv.setText(display);



        }

    }

    public float CalculateResult(float cal[]){

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

        }

        return result;
    }

    //check if a number has decimal part
    public boolean CheckDecimal(float num){

        if (num-(int)num!=0){
            return true;
        }else {
            return false;
        }
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
