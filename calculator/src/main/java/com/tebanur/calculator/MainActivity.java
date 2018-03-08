package com.tebanur.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView Toperacion, Tresultado;
    String Soperacion = "", SResultado;
    float Foperacion = 0, Foperador1 = 0, Foperador2 = 0, FResultado, unidad = 1, f1=1, f2=10;
    int  Count = 0, decimal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toperacion = findViewById(R.id.operaciones);
        Tresultado = findViewById(R.id.Resultado);

    }

    public void onButtonClicked(View view) {
        int id = view.getId();
        if (decimal == 0) {   //condicional que me define la parte decimal
            switch (id) {
                case R.id.BCero:
                    if (unidad != 1) {
                        Foperacion = 0 + (10 * Foperacion);
                        Soperacion += "0";
                    }
                    break;
                case R.id.BUno:
                    Soperacion += "1";
                    Foperacion = (1 + (10 * Foperacion));
                    break;
                case R.id.BDos:
                    Soperacion += "2";
                    Foperacion = (2 + (10 * Foperacion));

                    break;
                case R.id.BTres:
                    Soperacion += "3";
                    Foperacion = (3 + (10 * Foperacion));
                    break;
                case R.id.BCuatro:
                    Soperacion += "4";
                    Foperacion = (4 + (10 * Foperacion));
                    break;
                case R.id.BCinco:
                    Soperacion += "5";
                    Foperacion = (5 + (10 * Foperacion));
                    break;
                case R.id.BSeis:
                    Soperacion += "6";
                    Foperacion = (6 + (10 * Foperacion));
                    break;
                case R.id.BSiete:
                    Soperacion += "7";
                    Foperacion = (7 + (10 * Foperacion));
                    break;
                case R.id.BOcho:
                    Soperacion += "8";
                    Foperacion = (8 + (10 * Foperacion));
                    break;
                case R.id.BNueve:
                    Soperacion += "9";
                    Foperacion = (9 + (10 * Foperacion));
                    break;
                case R.id.BPunto:
                    if (Foperacion == 0) {
                        Soperacion += "0";
                    }
                    Soperacion += ".";
                    decimal = 1;
                    unidad = (float)1 / ((float) 10);
                    break;
            }
        } else {
            switch (id) {  //condicional que me pone la parte fraccionaria
                case R.id.BCero:
                    if (unidad != 1) {
                        Soperacion += "0";
                    }
                    Foperacion = Foperacion + (unidad * 0);
                    unidad = unidad / 10;
                    break;
                case R.id.BUno:
                    Soperacion += "1";
                    Foperacion = Foperacion + (unidad * 1);
                    unidad = unidad / 10;
                    break;
                case R.id.BDos:
                    Soperacion += "2";
                    Foperacion = Foperacion + (unidad * 2);
                    unidad = unidad / 10;
                    break;
                case R.id.BTres:
                    Soperacion += "3";
                    Foperacion = Foperacion + (unidad * 3);
                    unidad = unidad / 10;
                    break;
                case R.id.BCuatro:
                    Soperacion += "4";
                    Foperacion = Foperacion + (unidad * 4);
                    unidad = unidad / 10;
                    break;
                case R.id.BCinco:
                    Soperacion += "5";
                    Foperacion = Foperacion + (unidad * 5);
                    unidad = unidad / 10;
                    break;
                case R.id.BSeis:
                    Soperacion += "6";
                    Foperacion = Foperacion + (unidad * 6);
                    unidad = unidad / 10;
                    break;
                case R.id.BSiete:
                    Soperacion += "7";
                    Foperacion = Foperacion + (unidad * 7);
                    unidad = unidad / 10;
                    break;
                case R.id.BOcho:
                    Soperacion += "8";
                    Foperacion = Foperacion + (unidad * 8);
                    unidad = unidad / 10;
                    break;
                case R.id.BNueve:
                    Soperacion += "9";
                    Foperacion = Foperacion + (unidad * 9);
                    unidad = unidad / 10;
                    break;
            }
        }
        switch (id) {
            case R.id.BMas:
                Foperador1 = Foperacion;
                Soperacion += "+";
                Foperacion = 0;
                unidad = 1;
                Count = 1;
                decimal = 0;
                break;
            case R.id.BMultiplicacion:
                Foperador1 = Foperacion;
                Soperacion += "x";
                Foperacion = 0;
                unidad = 1;
                Count = 2;
                decimal = 0;
                break;
            case R.id.BResta:
                Foperador1 = Foperacion;
                Soperacion += "—";
                Foperacion = 0;
                unidad = 1;
                Count = 3;
                decimal = 0;
                break;
            case R.id.BDivision:
                Foperador1 = Foperacion;
                Soperacion += "÷";
                Foperacion = 0;
                unidad = 1;
                Count = 4;
                decimal = 0;
                break;
            case R.id.BReiniciar:
                Foperador1 = 0;
                Foperador2 = 0;
                Foperacion = 0;
                unidad = 1;
                decimal = 0;
                Soperacion = "";
                break;
            case R.id.BIgual:
                Foperador2 = Foperacion;
                decimal = 0;
                switch (Count) {
                    case 1:
                        FResultado = Foperador1 + Foperador2;
                        break;
                    case 2:
                        FResultado = Foperador1 * Foperador2;
                        break;
                    case 3:
                        FResultado = Foperador1 - Foperador2;
                        break;
                    case 4:
                        FResultado = Foperador1 / Foperador2;
                        break;
                }
                SResultado = Float.toString(FResultado);
                Tresultado.setText(SResultado);
                break;
        }
        Toperacion.setText(Soperacion);

    }
}
