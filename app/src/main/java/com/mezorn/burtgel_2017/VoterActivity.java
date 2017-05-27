package com.mezorn.burtgel_2017;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class VoterActivity extends Activity {

    LinearLayout btn_check;
    LinearLayout btn_clear;
    RelativeLayout nam;
    RelativeLayout uhuulga;
    RelativeLayout songuuli;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voter);

      btn_check = (LinearLayout) findViewById(R.id.actionbar_btn_check);
      btn_clear = (LinearLayout) findViewById(R.id.actionbar_btn_clear);

      nam = (RelativeLayout) findViewById(R.id.nam_layout);
      uhuulga = (RelativeLayout) findViewById(R.id.uhuulga_layout);
      songuuli = (RelativeLayout) findViewById(R.id.songuuli_layout);

      nam.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(VoterActivity.this, ChooseNamActivity.class);
              startActivity(intent);
          }
      });

        VoterNames voter = (VoterNames) getIntent().getExtras().getSerializable("VoterItem");

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Log.i("Voter: ",""+voter.getVoterName());
    }
}
