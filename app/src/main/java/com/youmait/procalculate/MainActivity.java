package com.youmait.procalculate;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private static char action;
    private static boolean addition, subtraction, division, multiplication;

    private static final char parenthes1 = '(';
    private static final char parenthes2 = ')';
    private float valueOne;
    private float valueTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DecimalFormat decimalFormat = new DecimalFormat("#.########");

        setContentView(R.layout.activity_main);

        final EditText editText = (EditText) findViewById(R.id.editText);

       // TextView textView = (TextView) findViewById(R.id.textView);

        Button buDelete = (Button) findViewById(R.id.buDelete);

        final Button buParenthes1 = (Button) findViewById(R.id.buParenthes1);

        Button buParenthes2 = (Button) findViewById(R.id.buParenthes2);


        Button buEqual = (Button) findViewById(R.id.butEqual);

        Button buSum = (Button) findViewById(R.id.buSum);


        Button buProd = (Button) findViewById(R.id.buProd);

        final Button buDiv = (Button) findViewById(R.id.buDiv);

        Button buSub = (Button) findViewById(R.id.buSub);

        Button buVirgule = (Button) findViewById(R.id.buVirgule);

        Button button0 = (Button) findViewById(R.id.button0);
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
                editText.setText(editText.getText() + "(");
            }
        });

        buParenthes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + ")");
            }
        });

        buDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //System.out.println("button0 clicked!");
                editText.setText(editText.getText() + "0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //System.out.println("button1 clicked!");
                editText.setText(editText.getText() + "1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //System.out.println("button2 clicked!");
                editText.setText(editText.getText() + "2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // System.out.println("button3 clicked!");
                editText.setText(editText.getText() + "3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // System.out.println("button clicked!");
                editText.setText(editText.getText() + "4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //System.out.println("button5 clicked!");
                editText.setText(editText.getText() + "5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //System.out.println("button6 clicked!");
                editText.setText(editText.getText() + "6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //System.out.println("button7 clicked!");
                editText.setText(editText.getText() + "7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //System.out.println("button8 clicked!");
                editText.setText(editText.getText() + "8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // System.out.println("button9 clicked!");
                editText.setText(editText.getText() + "9");
            }
        });
        buVirgule.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //System.out.println("buVirgule clicked!");
                editText.setText(editText.getText() + ",");
            }
        });


        buSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editText == null) {
                    editText.setText("");
                } else {
                    valueOne = Float.parseFloat(editText.getText() + "");
                    addition = true;
                    editText.setText(null);
                }
            }
        });

        buSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Float.parseFloat(editText.getText() + "");
                subtraction = true;
                editText.setText(null);
            }
        });

        buProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Float.parseFloat(editText.getText() + "");
                multiplication = true;
                editText.setText(null);
            }
        });

        buDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Float.parseFloat(editText.getText() + "");
                division = true;
                editText.setText(null);
            }
        });

        buEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueTwo = Float.parseFloat(editText.getText() + "");

                if (addition == true) {

                    editText.setText(valueOne + valueTwo + "");
                    addition = false;
                }


                if (subtraction == true) {
                    editText.setText(valueOne - valueTwo + "");
                    subtraction = false;
                }

                if (multiplication == true) {
                    editText.setText(valueOne * valueTwo + "");
                    multiplication = false;
                }

                if (division == true) {
                    editText.setText(valueOne / valueTwo + "");
                    division = false;
                }


            }


        });


    }

}







