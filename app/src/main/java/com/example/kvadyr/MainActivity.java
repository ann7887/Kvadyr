package com.example.kvadyr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private EditText editText3;
    private EditText editText2;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double ax,bx,cx,x1,x2;
                String S1 = editText.getText().toString();
                String S2 = editText2.getText().toString();
                String S3 = editText3.getText().toString();
                ax = Double.parseDouble(S1);
                bx = Double.parseDouble(S2);
                cx = Double.parseDouble(S3);
                double d = (bx * bx) - (4 * ax * cx);
                if (d > 0){
                    x1 = ((-bx) + Math.sqrt(d)) / (2 * ax);
                    x2 = ((-bx) - Math.sqrt(d)) / (2 * ax);
                    String s = Double.toString(x1);
                    String s1 = Double.toString(x2);
                    if (x1 == x2){
                        textView.setText("x = " + s);
                    }
                    else{
                        textView.setText("x1 = " + s + " x2 = " + s1);
                    }
                }
                else if (d == 0 && (ax != 0 || bx != 0 || cx != 0)) {
                    x1 = (-bx) / (2 * ax);
                    String s = Double.toString(x1);
                    textView.setText("x = " + s);
                }
                else{
                    textView.setText("нет решений");
                }
            }
        });
    }
}