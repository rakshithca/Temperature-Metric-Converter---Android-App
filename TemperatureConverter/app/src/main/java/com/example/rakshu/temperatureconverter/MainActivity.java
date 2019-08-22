package com.example.rakshu.temperatureconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText In;
    EditText Out;
    RadioButton toCelsius;
    RadioButton toFahrenheit;
    TextView display;
    String dst;
    TextView textView3;
    TextView textView4;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        In=(EditText)findViewById(R.id.InputValue);
        Out=(EditText)findViewById(R.id.OutputValue);
        toCelsius=(RadioButton)findViewById(R.id.ToCelsiusRadioButton);
        toFahrenheit=(RadioButton)findViewById(R.id.toFahrenheitRadioButton);
        display = (TextView)findViewById(R.id.textView);
        textView3 = (TextView)findViewById(R.id.textView3);
        textView4 = (TextView)findViewById(R.id.textView4);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if (toCelsius.isChecked()) {
                    textView3.setText("Fahrenheit Degrees:");
                    textView4.setText("Celsius Degrees:");
                } else {
                    textView4.setText("Fahrenheit Degrees:");
                    textView3.setText("Celsius Degrees:");
                }
            }
        });
    }


@Override
public void onSaveInstanceState(Bundle s)
{
    super.onSaveInstanceState(s);
    dst=display.getText().toString();
    s.putString("edittext",dst);
}

    @Override
    public void onRestoreInstanceState(Bundle r )
    {
        super.onRestoreInstanceState(r);
        display.setText(r.getString("edittext"));
    }

       public void convert(View v) {
           Log.d("Chal", "convert: workkkkk");
        double val = Double.valueOf(In.getText().toString());
        double input=val;
        if (toCelsius.isChecked()){
            val = TempertureConverter.fahrenheitTocelsius(val);
            Out.setText(""+String.format("%.1f",val));
            String history_text = display.getText().toString();
            display.setText( +input+ " F ==>"  +String.format("% .1f",val)+ " C \n" + history_text);
        }

        else{
            val = TempertureConverter.celsiusTofahrenheit(val);
            Out.setText(""+String.format("%.1f",val));
            String history_text = display.getText().toString();
            display.setText(+input+" C ==> " +String.format("% .1f",val)+" F \n" + history_text);
                        }
                        display.setMovementMethod(new ScrollingMovementMethod());

    }


    public void clearTemprature(View view){
        display.setText("");
    }
}
