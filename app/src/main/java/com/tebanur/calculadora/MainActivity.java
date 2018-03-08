package com.tebanur.calculadora;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Math.sqrt;

public class MainActivity extends AppCompatActivity {

    EditText eCuadro, eTrianguloA, eCubo, eCirculo, eTrianguloB, eTrianguloC;
    TextView tCuadro, tTrianguloA, tCubo, tCirculo, tResultadoA, tTrianguloB, tTrianguloC;
    String radio, lado, ladoA, ladoB, ladoC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eCuadro = findViewById(R.id.eCuadro);
        tCuadro = findViewById(R.id.tCuadro);
        eCirculo = findViewById(R.id.eCirculo);
        tCirculo = findViewById(R.id.tCirculo);
        eCubo = findViewById(R.id.eCubo);
        tCubo = findViewById(R.id.tCubo);
        eTrianguloA = findViewById(R.id.eTrianguloA);
        tTrianguloA = findViewById(R.id.tTrianguloA);
        tResultadoA = findViewById(R.id.tResultadoA);
        eTrianguloB = findViewById(R.id.eTrianguloB);
        tTrianguloB = findViewById(R.id.tTrianguloB);
        eTrianguloC = findViewById(R.id.eTrianguloC);
        tTrianguloC = findViewById(R.id.tTrianguloC);

    }

    public void onRadioButtonClicked(View view) {
        int id = view.getId();

        if (id == R.id.rCuadro) {
            if (eCuadro.getVisibility() == view.GONE) {
                eCuadro.setVisibility(view.VISIBLE);
                tCuadro.setVisibility(view.VISIBLE);
            }
        } else {
            eCuadro.setVisibility(view.GONE);
            tCuadro.setVisibility(view.GONE);
        }
        if (id == R.id.rCirculo) {
            if (eCirculo.getVisibility() == view.GONE) {
                eCirculo.setVisibility(view.VISIBLE);
                tCirculo.setVisibility(view.VISIBLE);
            }
        } else {
            eCirculo.setVisibility(view.GONE);
            tCirculo.setVisibility(view.GONE);
        }
        if (id == R.id.rTriangulo) {
            if (eTrianguloA.getVisibility() == view.GONE) {
                eTrianguloA.setVisibility(view.VISIBLE);
                tTrianguloA.setVisibility(view.VISIBLE);
                eTrianguloB.setVisibility(view.VISIBLE);
                tTrianguloB.setVisibility(view.VISIBLE);
                eTrianguloC.setVisibility(view.VISIBLE);
                tTrianguloC.setVisibility(view.VISIBLE);
            }
        } else {
            eTrianguloA.setVisibility(view.GONE);
            tTrianguloA.setVisibility(view.GONE);
            eTrianguloC.setVisibility(view.GONE);
            tTrianguloC.setVisibility(view.GONE);
            eTrianguloB.setVisibility(view.GONE);
            tTrianguloB.setVisibility(view.GONE);
        }
        if (id == R.id.rCubo) {
            if (eCubo.getVisibility() == view.GONE) {
                eCubo.setVisibility(view.VISIBLE);
                tCubo.setVisibility(view.VISIBLE);
            }
        } else {
            eCubo.setVisibility(view.GONE);
            tCubo.setVisibility(view.GONE);
        }

    }


    public void onButtonClicked(View view) {

        if (eCirculo.getVisibility() == view.VISIBLE) {

            radio = eCirculo.getText().toString();
            int nro1 = Integer.parseInt(radio);
            float area = (float) 3.1415 * nro1 * nro1;
            float perimetro = (float) (2 * 3.1415 * nro1);
            tResultadoA.setVisibility(view.VISIBLE);
            tResultadoA.setText("El área del circulo es de: " + area + "\ny su perimetro es de: " + perimetro);
        }

        if (eCubo.getVisibility() == view.VISIBLE) {
            lado = eCubo.getText().toString();
            int nro1 = Integer.parseInt(lado);
            float area = nro1 * nro1 * 6;
            float perimetro = 12 * nro1;
            float volumen = nro1 * nro1 * nro1;
            tResultadoA.setVisibility(view.VISIBLE);
            tResultadoA.setText("El área del cubo es de: " + area + "\nsu perímetro es de: " + perimetro + "\ny su volumen es de: " + volumen);
        }

        if (eCuadro.getVisibility() == view.VISIBLE) {
            lado = eCuadro.getText().toString();
            int nro1 = Integer.parseInt(lado);
            float area = nro1 * 4;
            float perimetro = nro1 * nro1;
            tResultadoA.setVisibility(view.VISIBLE);
            tResultadoA.setText("El área del cuadrado es de: " + area + "\nsu perímetro es de: " + perimetro);
        }

        if (eTrianguloA.getVisibility() == view.VISIBLE) {
            ladoA = eTrianguloA.getText().toString();
            ladoB = eTrianguloB.getText().toString();
            ladoC = eTrianguloC.getText().toString();
            float nro1 = Float.parseFloat(ladoA);
            float nro2 = Float.parseFloat(ladoB);
            float nro3 = Float.parseFloat(ladoC);
            double perimetro = nro1 + nro2 + nro3;
            double s = perimetro / 2;
            double area = sqrt(s*(s - nro1)*(s - nro2)*(s - nro3));
            tResultadoA.setVisibility(view.VISIBLE);
            tResultadoA.setText("El área del triangulo es de: " + area + "\nsu perímetro es de: " + perimetro);
        }
    }
}