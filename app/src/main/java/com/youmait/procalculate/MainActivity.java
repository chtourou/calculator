package com.youmait.procalculate;

import android.content.Intent;
import android.graphics.Color;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.eclipsesource.v8.V8;


public class MainActivity extends AppCompatActivity {

    private boolean haveComma = false;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        result = (TextView) findViewById(R.id.result);
        Button buDelete = (Button) findViewById(R.id.buDelete);
        Button buParenthes1 = (Button) findViewById(R.id.buParenthes1);
        Button buParenthes2 = (Button) findViewById(R.id.buParenthes2);
        final Button buEqual = (Button) findViewById(R.id.butEqual);
        final Button buSum = (Button) findViewById(R.id.buSum);
        Button buProd = (Button) findViewById(R.id.buProd);
        Button buDiv = (Button) findViewById(R.id.buDiv);
        Button buSub = (Button) findViewById(R.id.buSub);
        Button buVirgule = (Button) findViewById(R.id.buVirgule);
        final ImageButton btnBack = (ImageButton) findViewById(R.id.back);
        final Button button0 = (Button) findViewById(R.id.button0);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);

        buParenthes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "(");
            }
        });
        buParenthes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + ")");
            }
        });
        buDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText("");
                haveComma = true;
                btnBack.setEnabled(true);
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "0");

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "9");
            }
        });
        buVirgule.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!haveComma) {
                    String res = result.getText().toString();
                    if (res.equals("")) {
                        result.setText(result.getText() + "0,");
                    } else {
                        String lastChar = res.substring(res.length() - 1, res.length());
                        if (lastChar.equals("+") || lastChar.equals("/") || lastChar.equals("*") || lastChar.equals("-")) {
                            result.setText(result.getText() + "0,");
                        } else {
                            result.setText(result.getText() + ",");
                        }
                    }
                    haveComma = true;
                }


            }
        });


        buSum.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(!canWriteOperation(result.getText().toString()))
                    return;
                result.setText(result.getText() + "+");
                haveComma = false;
            }
        });


        buSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!canWriteOperation(result.getText().toString()))
                    return;
                result.setText(result.getText() + "-");
                haveComma = false;
            }
        });
        buProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!canWriteOperation(result.getText().toString()))
                    return;
                result.setText(result.getText() + "*");
                haveComma = false;
            }
        });

        buDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!canWriteOperation(result.getText().toString()))
                    return;
                result.setText(result.getText() + "/");
                haveComma = false;
            }
        });


        buEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    V8 runtime = V8.createV8Runtime();
                    String expression = result.getText().toString();
                    Double res = runtime.executeDoubleScript("var value = " + expression + ";\n value;");
                    result.setText("" + res);
                    runtime.release();
                } catch (Exception exp) {
                    result.setText("Resultat invalide!");
                    btnBack.setEnabled(false);
                }

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = result.getText().toString();
                btnBackHandler(value);
            }
        });

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                startActivity(intent);
            }
        });


    }

    private void btnBackHandler(String res){
        if (!res.equals("")) {
            String deletedValue = res.substring(res.length() - 1, res.length());
            if (deletedValue.equals(",")) {
                haveComma = false;
            }

            if (deletedValue.equals("+") || deletedValue.equals("/") || deletedValue.equals("*") || deletedValue.equals("-")) {
                haveComma = true;
            }

            res = res.substring(0, res.length() - 1);
            result.setText(res);
        }
    }

    private boolean canWriteOperation(String rese) {
        if(rese.equals("")) return true;
        String lastChar = rese.substring(rese.length() - 1, rese.length());
        return !(lastChar.equals("+") || lastChar.equals("/") || lastChar.equals("*") || lastChar.equals("-"));
    }
}








