package hk.polyu.eie.eie3109.helloworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button BNBack = findViewById(R.id.BNBack);

        TextView TVWelcome = findViewById(R.id.TVWelcome);
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.PREFERENCE_NAME,MainActivity.MODE);
        String name = sharedPreferences.getString("Name" , "Default Name");
        if(TVWelcome != null){
            TVWelcome.setText(name);
        }


        if(BNBack != null){
            BNBack.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    startActivity(new Intent(MainActivity2.this, MainActivity.class));
                    finish();

                }

            });
        }


    }
}