package com.example.currencyConverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner spinner;
    private static final String[] paths = {"Select", "USD to BDT", "Pound to BDT","Clear"};


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:


                break;
            case 1:
                EditText edittext = findViewById(R.id.editTextNumberDecimal);
                EditText edittext2 = findViewById(R.id.editTextNumberDecimal2);
                String amountInUSD = edittext.getText().toString();
                 Double amountInDouble = Double.parseDouble(amountInUSD);
                Double amountInBDT= amountInDouble * 84.79;
                NumberFormat formatter = new DecimalFormat("#0.00");
                String x = formatter.format(amountInBDT);
                edittext2.setText(x+" BDT");
                Toast.makeText(getApplicationContext()," Converted",Toast.LENGTH_SHORT).show();

                break;
            case 2:
               EditText edittext1 = findViewById(R.id.editTextNumberDecimal);
                EditText edittext3 = findViewById(R.id.editTextNumberDecimal2);
                String amountInPound = edittext1.getText().toString();

                Double amountInDouble1 = Double.parseDouble(amountInPound);
                Double amountInBDT1= amountInDouble1 * 116.88;
                NumberFormat formatter1 = new DecimalFormat("#0.00");
                String x1 = formatter1.format(amountInBDT1);
                edittext3.setText(x1+" BDT");

                Toast.makeText(getApplicationContext()," Converted",Toast.LENGTH_SHORT).show();

                break;
            case 3:
                EditText e = findViewById(R.id.editTextNumberDecimal);
                EditText e2 = findViewById(R.id.editTextNumberDecimal2);
                EditText e1 = findViewById(R.id.editTextNumberDecimal);
                EditText e3 = findViewById(R.id.editTextNumberDecimal2);
                e.setText(" ");
                e1.setText(" ");
                e2.setText(" ");
                e3.setText(" ");
                Toast.makeText(getApplicationContext()," Cleared",Toast.LENGTH_SHORT).show();
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }

}

    