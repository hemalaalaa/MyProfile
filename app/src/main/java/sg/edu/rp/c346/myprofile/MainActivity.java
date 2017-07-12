package sg.edu.rp.c346.myprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;




public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;


    @Override
    protected void onPause() {
        super.onPause();

        String strName=etName.getText().toString();

        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor preEdit = prefs.edit();

        preEdit.putString("name", strName);

        preEdit.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        String strName= prefs.getString("name","John");

        etName.setText(strName);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //btnPassInteger = (Button)findViewById(R.id.buttonPassInteger);
        //btnPassChar = (Button)findViewById(R.id.buttonPassChar);

        etName=(EditText)findViewById(R.id.editTextName);
        etGPA=(EditText)findViewById(R.id.editTextGPA);





    }
}
