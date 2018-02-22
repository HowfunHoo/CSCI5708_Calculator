package com.haofan.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private float result = 0;
    private TextView tv;
    private float[] calculation = new float[3];

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

        String display = tv.getText().toString().trim();
        if (display.equals("0")){
            display = "";
        }

        switch (v.getId()){
            case R.id.btn_one:
                if (result == 0){
                    display = display + "1";
                }else {
                    display = "1";
                    result = 0;
                }
//                if (result == 0 && display.equals("0")){
//                    display = "1";
//                }else if (result == 0 && display.equals("0")){
//                    display = display + "1";
//                }else{
//                    display = "1";
//                    result = 0;
//                }
                tv.setText(display);
                break;
            case R.id.btn_two:
                if (result == 0){
                    display = display + "2";
                }else {
                    display = "2";
                    result = 0;
                }
                tv.setText(display);
                break;
            case R.id.btn_three:
                if (result == 0){
                    display = display + "3";
                }else {
                    display = "3";
                    result = 0;
                }
                tv.setText(display);
                break;
            case R.id.btn_four:
                if (result == 0){
                    display = display + "4";
                }else {
                    display = "4";
                    result = 0;
                }
                tv.setText(display);
                break;
            case R.id.btn_five:
                if (result == 0){
                    display = display + "5";
                }else {
                    display = "5";
                    result = 0;
                }
                tv.setText(display);
                break;
            case R.id.btn_six:
                if (result == 0){
                    display = display + "6";
                }else {
                    display = "6";
                    result = 0;
                }
                tv.setText(display);
                break;
            case R.id.btn_seven:
                if (result == 0){
                    display = display + "7";
                }else {
                    display = "7";
                    result = 0;
                }
                tv.setText(display);
                break;
            case R.id.btn_eight:
                if (result == 0){
                    display = display + "8";
                }else {
                    display = "8";
                    result = 0;
                }
                tv.setText(display);
                break;
            case R.id.btn_nine:
                if (result == 0){
                    display = display + "9";
                }else {
                    display = "9";
                    result = 0;
                }
                tv.setText(display);
                break;
            case R.id.btn_zero:
                if (result == 0){
                    display = display + "0";
                }else {
                    display = "0";
                    result = 0;
                }
                tv.setText(display);
                break;
            case R.id.btn_pos_neg:
                if (!display.equals("") && display.charAt(0)=='-'){
                    display = display.substring(1, display.length());
                }else if (display.equals(""))
                {
                    display = "-";
                }
                else if ((display.charAt(0)!='-' && display.length()<10)){
                    display = "-" + display;
                }
                tv.setText(display);
                break;
            case R.id.btn_dot:
                if (!display.contains(".") && display.length()<10){
                    if (display.equals("")){
                        display = "0.";
                    }else {
                        display = display + ".";
                    }
                }
                tv.setText(display);
                break;
            case R.id.btn_ac:
                for (int i=1;i<3;i++){
                    calculation[i]=0;
                }
                tv.setText("0");
                break;
            case R.id.btn_clear:
                tv.setText("0");
                break;
            case R.id.btn_plus:
                if (calculation[1]==0 && !display.equals("")){
                    calculation[0] = Float.parseFloat(display);
                    calculation[1] = 1;
                    calculation[2] = 0;
                    tv.setText("0");
                }else{
                    if (display.equals("")){
                        calculation[2] = 0;
                    }else {
                        calculation[2] = Float.parseFloat(display);
                    }
                    result = CalculateResult(calculation);
                    if (CheckDecimal(result)){
                        display = Float.toString(result);
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
                }
                break;
            case R.id.btn_minus:
                if (calculation[1]==0 && !display.equals("")){
                    calculation[0] = Float.parseFloat(display);
                    calculation[1] = 2;
                    calculation[2] = 0;
                    tv.setText("0");
                }else{
                    if (display.equals("")){
                        calculation[2] = 0;
                    }else {
                        calculation[2] = Float.parseFloat(display);
                    }
                    result = CalculateResult(calculation);
                    if (CheckDecimal(result)){
                        display = Float.toString(result);
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
                }
                break;
            case R.id.btn_multiple:
                if (calculation[1]==0 && !display.equals("")){
                    calculation[0] = Float.parseFloat(display);
                    calculation[1] = 3;
                    calculation[2] = 0;
                    tv.setText("0");
                }else{
                    if (display.equals("")){
                        calculation[2] = 0;
                    }else {
                        calculation[2] = Float.parseFloat(display);
                    }
                    result = CalculateResult(calculation);

                    if (CheckDecimal(result)){
                        display = Float.toString(result);
                    }else {
                        display = Integer.toString((int)result);
                    }
                    tv.setText(display);

                    calculation[0] = result;
                    calculation[1] = 3;
                    calculation[2] = 0;
                }
                break;
            case R.id.btn_divide:
                if (calculation[1]==0 && !display.equals("")){
                    calculation[0] = Float.parseFloat(display);
                    calculation[1] = 4;
                    calculation[2] = 0;
                    tv.setText("0");
                }else{
                    if (display.equals("")){
                        calculation[2] = 0;
                    }else {
                        calculation[2] = Float.parseFloat(display);
                    }
                    result = CalculateResult(calculation);

                    if (CheckDecimal(result)){
                        display = Float.toString(result);
                    }else {
                        display = Integer.toString((int)result);
                    }
                    tv.setText(display);

                    calculation[0] = result;
                    calculation[1] = 4;
                    calculation[2] = 0;
                }
                break;
            case R.id.btn_equal:
                if (calculation[1]!=0){
                    if (display.equals("")){
                        calculation[2] = 0;
                    } else {
                        calculation[2] = Float.parseFloat(display);
                    }
                    result = CalculateResult(calculation);

                    if (CheckDecimal(result)){
                        display = Float.toString(result);
                    }else {
                        display = Integer.toString((int)result);
                    }
                    tv.setText(display);

                    calculation[0] = result;
                    calculation[1] = 0;
                    calculation[2] = 0;
                }
                break;



        }

    }

    public float CalculateResult(float cal[]){

        float result = 0;

        if (cal[1]==1){
            result = cal[0] + cal[2];
        }else if (cal[1]==2){
            result = cal[0] - cal[2];
        }else if (cal[1]==3){
            result = cal[0] * cal[2];
        }else if (cal[1]==4){
            result = cal[0] / cal[2];
        }

        return result;
    }

    public boolean CheckDecimal(float num){

        if (num-(int)num!=0){
            return true;
        }else {
            return false;
        }
    }

//    public String removeZeroAndDot(String str){
//        if(str.indexOf(".") > 0){
//            str = str.replaceAll("0+?$", "");
//            str = str.replaceAll("[.]$", "");
//        }
//        return str;
//    }

}
