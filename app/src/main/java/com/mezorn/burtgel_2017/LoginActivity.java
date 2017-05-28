package com.mezorn.burtgel_2017;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mezorn.burtgel_2017.models.UserRequest;
import com.mezorn.burtgel_2017.models.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends Activity {

    final Context context=this;

    private APIInterface mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mService = Utils.getSOService();
        final EditText token = (EditText) findViewById(R.id.et_token);
        Button btn_login = (Button) findViewById(R.id.btn_login);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String thisToken = token.getText().toString();


                        if(thisToken.length()<8){
                            Toast.makeText(getApplicationContext(), R.string.toast_wrong_token, Toast.LENGTH_SHORT).show();

                        } else{

                            mService.createUser(new UserRequest(thisToken)).enqueue(new Callback<UserResponse>() {
                                @Override
                                public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                                    final Dialog dialog = new Dialog(context);
                                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                                    dialog.setContentView(R.layout.activity_dialog_login);
                                    dialog.setCanceledOnTouchOutside(false);
                                    final UserResponse userResponse = response.body();
                                    Gson gson = new Gson();

                                    Log.i("UserResponse ", gson.toJson(userResponse));
                                    //dialog.setTitle("Title...");

                                    // set the custom dialog components - text, image and button
                                    TextView text = (TextView) dialog.findViewById(R.id.login_dialog_name);
                                    if(response.body()==null){
                                        Toast.makeText(getApplicationContext(), R.string.toast_wrong_token, Toast.LENGTH_SHORT).show();

                                    } else {
                                        try {
                                            text.setText(response.body().getFullname());
                                        } catch (NullPointerException e) {
                                            text.setText("name name");
                                        }
                                        // ImageView image = (ImageView) dialog.findViewById(R.id.image);
                                        //image.setImageResource(R.drawable.ic_launcher);

                                        Button dialogButton = (Button) dialog.findViewById(R.id.btn_yes_dialog);
                                        // if button is clicked, close the custom dialog
                                        dialogButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                try {


                                                    Utils.setToken(getApplicationContext(), userResponse.getToken());
                                                    Utils.setID(getApplicationContext(), userResponse.getId());
                                                    Utils.setCode(getApplicationContext(), userResponse.getCode());
                                                    Utils.setAimag(getApplicationContext(), userResponse.getAimag());
                                                    Utils.setBagkhoroo(getApplicationContext(), userResponse.getBagkhoroo());
                                                    Utils.setHeseginBagkhoroo(getApplicationContext(), userResponse.getHeseg_in_bagkhoroo());
                                                    Utils.setHesegId(getApplicationContext(), userResponse.getHeseg_id());
                                                    Utils.setHesegName(getApplicationContext(), userResponse.getHeseg_name());
                                                    Utils.setFullname(getApplicationContext(), userResponse.getFullname());
                                                    Utils.setPhone(getApplicationContext(), userResponse.getPhone());
                                                    Utils.setRole(getApplicationContext(), userResponse.getRole());
                                                    Utils.setSumduureg(getApplicationContext(), userResponse.getSumduureg());
                                                    //Log.i("SHINE TOKEN : ", Utils.getToken(getApplicationContext()));
                                                    goToMain();
                                                    dialog.dismiss();
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                    Toast.makeText(getApplicationContext(), R.string.toast_wrong_token, Toast.LENGTH_SHORT).show();

                                                    dialog.dismiss();
                                                }

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
                                    }
                                }

                                @Override
                                public void onFailure(Call<UserResponse> call, Throwable t) {
                                    Log.e("MainActivity", t.getMessage());

                                }
                            });


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
