package com.tebanur.formulario;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    Spinner ciudad;
    int iyear, imonth, iday;
    EditText ePass, eCPass, eCorreo, eLogin, eDate;
    TextView tInfo;
    CheckBox cBailar, cCorrer, cCantar, cLeer;
    DatePickerDialog datePickerDialog;
    String sUsuario, sCorreo, sPass1, sPass2, sHobbies = "", sGenero, sCiudad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eDate = findViewById(R.id.date);
        eLogin = findViewById(R.id.eLogin);
        eCPass = findViewById(R.id.eCPass);
        ePass = findViewById(R.id.ePass);
        eCorreo = findViewById(R.id.eCorreo);
        cBailar = findViewById(R.id.cBailar);
        cCorrer = findViewById(R.id.cCorrer);
        cCantar = findViewById(R.id.cCantar);
        cLeer = findViewById(R.id.cLeer);
        tInfo = findViewById(R.id.info);
        ciudad = findViewById(R.id.ciudades_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Ciudades, android.R.layout.simple_dropdown_item_1line);
        ciudad.setAdapter(adapter);

        eDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                eDate.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                                iday = dayOfMonth;
                                imonth = monthOfYear + 1;
                                iyear = year;
                            }
                        }, mYear, mMonth, mDay);

                datePickerDialog.show();
            }
        });
    }


    public void onCheckBoxClicked(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.cCantar:
                if (cCantar.isChecked()) {
                    sHobbies += "Cantar ";
                }
                break;
            case R.id.cBailar:
                if (cBailar.isChecked()) {
                    sHobbies += "Bailar ";
                }else
                break;
            case R.id.cCorrer:
                if (cCorrer.isChecked()) {
                    sHobbies += "Correr ";
                }
                break;
            case R.id.cLeer:
                if (cLeer.isChecked()) {
                    sHobbies += "Leer ";
                }
                break;
        }
    }


    public void onRadioButtonClicked(View view) {

        int id = view.getId();

        if (id == R.id.rMasculino) {
            sGenero = "Masculino";
        } else {
            sGenero = "Femenino";
        }

    }

    public void onButtonClicked(View view) {

        sCorreo = eCorreo.getText().toString();
        sPass1 = ePass.getText().toString();
        sPass2 = eCPass.getText().toString();
        sUsuario = eLogin.getText().toString();
        sCiudad = ciudad.getSelectedItem().toString();


        if (sCorreo.equals("") | sPass1.equals("") | sPass2.equals("") | sUsuario.equals("")) {
            Toast.makeText(this, "Por favor ingrese todos los valores",
                    Toast.LENGTH_LONG).show();
        } else {
            if (sPass1.equals(sPass2)) {
                tInfo.setText(" Usuario: " + sUsuario + "\n E-mail: " + sCorreo + "\n Sexo: " + sGenero + "\n Nacido el: "
                        + iday + "/" + imonth + "/" + iyear + " En: " + sCiudad + "\n Sus hobbbies son: " + sHobbies);
            } else {
                Toast.makeText(this, "Contraseñas no coinciden",
                        Toast.LENGTH_LONG).show();
            }
        }

    }


    public void showDatePickerDialog(View view) {
    }
}
