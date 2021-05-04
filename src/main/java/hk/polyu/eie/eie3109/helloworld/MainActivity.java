package hk.polyu.eie.eie3109.helloworld;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static int MODE = Context.MODE_PRIVATE;
    public static final String PREFERENCE_NAME = "MyProfile";
    private SharedPreferences sharedPreferences;
    private EditText ETName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(PREFERENCE_NAME,MODE);
        ETName = findViewById(R.id.ETName);
        Button BNOK = findViewById(R.id.BNOK);
        TextView TVTitle = findViewById(R.id.TVTitle);

        if(BNOK != null){
            BNOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("Name",ETName.getText().toString());
                    editor.apply();

                    startActivity(new Intent(MainActivity.this,MainActivity2.class));
                    finish();


                }
            });
        };

        String name = sharedPreferences.getString("Name", "Default Name");
        if (name != null){
            TVTitle.setText("Hi " + name + "!");
        }

    }
}