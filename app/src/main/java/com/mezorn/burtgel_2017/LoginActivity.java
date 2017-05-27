package com.mezorn.burtgel_2017;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText token = (EditText) findViewById(R.id.et_token);
        Button btn_login = (Button) findViewById(R.id.btn_login);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String thisToken = token.getText().toString();

                        if(thisToken.length()<6){
                            Toast.makeText(getApplicationContext(), R.string.toast_wrong_token, Toast.LENGTH_SHORT).show();

                        } else{
                            //service end duudna
                            Utils.setToken(getApplicationContext(), thisToken);
                            //Log.i("SHINE TOKEN : ", Utils.getToken(getApplicationContext()));
                            goToMain();

                }

            }

            protected void goToMain(){
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
