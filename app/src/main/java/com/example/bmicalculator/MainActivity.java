package com.example.bmicalculator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etHeight, etWeight;
    private TextView tvResult;
    private Button btnCalcuate;
    private Double height, weight, result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        tvResult = findViewById(R.id.tvResult);
        btnCalcuate = findViewById(R.id.btnCalculate);
        btnCalcuate.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCalculate:
                if (Validation() == true) {
                    height = Double.parseDouble(etHeight.getText().toString());
                    weight = Double.parseDouble(etWeight.getText().toString());
                    height = height * 0.01;
                    BMI bim = new BMI();
                    bim.setHeight(height);
                    bim.setWeight(weight);
                    result = bim.CalculateBIM();
                    tvResult.setText(Double.toString(bim.CalculateBIM()));

                    if (result <= 18.5) {
                        Toast.makeText(this, "Under Weight", Toast.LENGTH_LONG).show();
                    } else if (result <= 18.5 || result <= 24.5) {
                        Toast.makeText(this, "Normal Weight", Toast.LENGTH_LONG).show();
                    } else if (result <= 24.5 || result <= 29.9) {
                        Toast.makeText(this, "Over Weight", Toast.LENGTH_LONG).show();
                    } else if (result > 30) {
                        Toast.makeText(this, "Obesity", Toast.LENGTH_LONG).show();
                    }
                }
        }
    }
    public Boolean Validation() {

        if (TextUtils.isEmpty(etHeight.getText())) {

            etHeight.requestFocus();
            etHeight.setError("Please Enter Height");
            return false;
        } else if (TextUtils.isEmpty(etWeight.getText())) {

            etWeight.requestFocus();
            etWeight.setError("Please Enter Weight");
            return false;
        }
        return true;
    }
}

