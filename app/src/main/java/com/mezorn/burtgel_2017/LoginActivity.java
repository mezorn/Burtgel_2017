package com.mezorn.burtgel_2017;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {

    final Context context=this;

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

                            final Dialog dialog = new Dialog(context);
                            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            dialog.setContentView(R.layout.activity_dialog_login);
                            dialog.setCanceledOnTouchOutside(false);

                            //dialog.setTitle("Title...");

                            // set the custom dialog components - text, image and button
                            TextView text = (TextView) dialog.findViewById(R.id.login_dialog_name);
                            text.setText("Наранбаяр");
                           // ImageView image = (ImageView) dialog.findViewById(R.id.image);
                            //image.setImageResource(R.drawable.ic_launcher);

                            Button dialogButton = (Button) dialog.findViewById(R.id.btn_yes_dialog);
                            // if button is clicked, close the custom dialog
                            dialogButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Utils.setToken(getApplicationContext(), "123242");

                                    //Log.i("SHINE TOKEN : ", Utils.getToken(getApplicationContext()));
                                    goToMain();
                                    dialog.dismiss();
                                }
                            });

                            Button dialogButton_no = (Button) dialog.findViewById(R.id.btn_no_dialog);
                            // if button is clicked, close the custom dialog
                            dialogButton_no.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog.dismiss();
                                }
                            });

                            dialog.show();
                            //service end duudna


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
