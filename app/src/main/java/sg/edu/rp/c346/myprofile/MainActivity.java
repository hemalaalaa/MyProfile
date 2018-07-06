package sg.edu.rp.c346.myprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;
    RadioGroup rgGender;
    RadioButton rbMale;
    RadioButton rbFemale;


    @Override
    protected void onPause() {
        super.onPause();

        String strName = etName.getText().toString();
        float gpa = Float.valueOf(etGPA.getText().toString());
        int intGender = rgGender.getCheckedRadioButtonId();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);


        SharedPreferences.Editor preEdit = prefs.edit();

        preEdit.putString("name", strName);
        preEdit.putFloat("gpa", gpa);
        preEdit.putInt("gender", intGender);


        preEdit.commit();

    }

        @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        String strName= prefs.getString("name","John");
        Float gpa= prefs.getFloat("gpa",0);
        int intGender= prefs.getInt("gender",R.id.radioButtonGenderMale);

        etName.setText(strName);
        etGPA.setText(gpa+"");
        rgGender.check(intGender);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        etName=(EditText)findViewById(R.id.editTextName);
        etGPA=(EditText)findViewById(R.id.editTextGPA);
        rgGender=(RadioGroup)findViewById(R.id.RadioGroupGender);
        rbMale = (RadioButton)findViewById(R.id.radioButtonGenderMale);
        rbFemale = (RadioButton)findViewById(R.id.radioButtonGenderFemale);





    }
}
