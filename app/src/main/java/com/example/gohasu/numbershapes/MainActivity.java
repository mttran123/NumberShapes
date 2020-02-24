package com.example.gohasu.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number {
        int number; //9

        public boolean isTriangular () {
            int x = 1;
            int triangularNumber =1;
            while (number > triangularNumber) {
                x++;  //2,3,4
                triangularNumber = x+triangularNumber; //3,6, 10
            }
            if (number==triangularNumber) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isSquareNumber() {
            int squareNumber=1;
            for(int i=1; number > squareNumber; i++) {
                squareNumber = i*i;  //1,4,9

            }
            if(number == squareNumber) {
                return true;
            } else {
                return false;
            }
        }
    }

    public void testNumber(View view) {
        Log.i("Info", "Button pressed");

        EditText editText = (EditText) findViewById(R.id.editText);

        String message;

        if(editText.getText().toString().isEmpty()) {
            message = "Please enter a number";
        } else {

            int enteredValue = Integer.parseInt(editText.getText().toString());

            Number enteredNumber = new Number();
            enteredNumber.number = enteredValue;

            message = editText.getText().toString();


            if (enteredNumber.isTriangular() && enteredNumber.isSquareNumber()) {
                message += " is triangular and square number.";
            } else if (enteredNumber.isSquareNumber()) {
                message += " is a square number but not triangular.";
            } else if (enteredNumber.isTriangular()) {
                message += " is triangular but not a square";
            } else {
                message += " is neither triangular nor square number";

            } 

        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
