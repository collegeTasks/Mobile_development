package com.example.taskmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button resault;
    EditText A, B, C;
    CheckBox Ploshad, Perimetr;
    String a1, b1, c1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resault = findViewById(R.id.BtnRes);
        A = findViewById(R.id.inputA);
        B = findViewById(R.id.inputB);
        C = findViewById(R.id.inputC);

        Perimetr = findViewById(R.id.checkBoxPerimetr);
        Ploshad = findViewById(R.id.checkBoxPloshad);




        resault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double res, a, b, c, perimetrRes, ploshadRes;

                a1 = A.getText().toString();
                b1 = B.getText().toString();
                c1 = C.getText().toString();

                a =  Double.parseDouble(a1);
                b =  Double.parseDouble(b1);
                c =  Double.parseDouble(c1);
                if ((a < b + c) && (b < a + c) && (c < a + b)){

                    if (Perimetr.isChecked() && Ploshad.isChecked()){
                        perimetrRes = a + b + c;
                        double S = perimetrRes / 2;

                        ploshadRes = (double) Math.sqrt(S * (S - a) * (S - b) * (S - c));
                        ImageView img = new ImageView(MainActivity.this);

                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("Информация")
                                .setIcon(R.drawable.good)
                                .setMessage("Периметр :" + perimetrRes  + "\nПлощадь :" + ploshadRes)
                                .setPositiveButton("OK", null)
                                .show();
                    }else if(Perimetr.isChecked()){
                        perimetrRes = a + b + c;
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("Информация")
                                .setIcon(R.drawable.good)
                                .setMessage("Периметр :" + perimetrRes )
                                .setPositiveButton("OK", null)
                                .show();

                    }else if (Perimetr.isChecked() == false && Ploshad.isChecked() == false){
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("Туть пусто")
                                .setMessage("Выберите, что вам нужно посчитать")
                                .setIcon(R.drawable.notfound)
                                .setPositiveButton("OK", null)
                                .show();
                    }else{
                        perimetrRes = a + b + c;
                        double S = perimetrRes / 2;
                        ploshadRes = (double) Math.sqrt(S * (S - a) * (S - b) * (S - c));

                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("Информация")
                                .setIcon(R.drawable.good)
                                .setMessage("Площадь :" + ploshadRes )
                                .setPositiveButton("OK", null)
                                .show();
                    }
                }else {
                    ImageView img = new ImageView(MainActivity.this);
                    img.setImageResource(R.drawable.unreal);
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Треугольника не существует")
                            .setIcon(R.drawable.unreal)
                            .setPositiveButton("OK", null)
                            .show();
                }
            }
        });
    }
}