package com.mezorn.burtgel_2017;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends Activity implements SearchView.OnQueryTextListener{



    ListView list;
    ListViewAdapter adapter;
    SearchView editsearch;
    String[] voterNameList;
    ArrayList<VoterNames> arraylist = new ArrayList<VoterNames>();
    Button filterAll, filterNamaar, filterUhuulga, filterSonguuli, filterBag;
    // Generate sample data
    public static String filterID="";
    private BroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        receiver = new NetworkChangeReceiver();
        registerReceiver(receiver, filter);


        voterNameList = new String[]{"Амгаланбаатар Наранбаяр", "Одонсүрэн Золбаяр", "Батсайхан Эрдэм",
                "Бат-Орших Манлай", "Нөхөр Сүхээ"};

        filterAll = (Button) findViewById(R.id.filter_all);
        filterNamaar = (Button) findViewById(R.id.filter_namaar);
        filterUhuulga = (Button) findViewById(R.id.filter_uhuulga);
        filterSonguuli = (Button) findViewById(R.id.filter_songuuli);
        filterBag = (Button) findViewById(R.id.filter_bag);

        list = (ListView) findViewById(R.id.list_voters);

        for (int i = 0; i < voterNameList.length; i++) {
            VoterNames voterNames = new VoterNames(voterNameList[i]);
            // Binds all strings into an array
            arraylist.add(voterNames);
        }

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);



        Log.i("SHINE TOKEN : ", Utils.getToken(this));
        Log.i("User code ", Utils.getCode(this));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final VoterNames voter = ((VoterNames) adapterView.getItemAtPosition(i));
                Intent intent = new Intent(MainActivity.this, VoterActivity.class).putExtra("VoterItem", voter);
                startActivity(intent);
            }
        });

        filterAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterAll.setBackgroundResource(R.color.greebMain);
                filterNamaar.setBackgroundResource(R.color.greenLight);
                filterSonguuli.setBackgroundResource(R.color.greenLight);
                filterUhuulga.setBackgroundResource(R.color.greenLight);
                filterBag.setBackgroundResource(R.color.greenLight);
            }
        });

        filterNamaar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterAll.setBackgroundResource(R.color.greenLight);
                filterNamaar.setBackgroundResource(R.color.greebMain);
                filterSonguuli.setBackgroundResource(R.color.greenLight);
                filterUhuulga.setBackgroundResource(R.color.greenLight);
                filterBag.setBackgroundResource(R.color.greenLight);
            }
        });

        filterSonguuli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterAll.setBackgroundResource(R.color.greenLight);
                filterNamaar.setBackgroundResource(R.color.greenLight);
                filterSonguuli.setBackgroundResource(R.color.greebMain);
                filterUhuulga.setBackgroundResource(R.color.greenLight);
                filterBag.setBackgroundResource(R.color.greenLight);
            }
        });

        filterUhuulga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterAll.setBackgroundResource(R.color.greenLight);
                filterNamaar.setBackgroundResource(R.color.greenLight);
                filterSonguuli.setBackgroundResource(R.color.greenLight);
                filterUhuulga.setBackgroundResource(R.color.greebMain);
                filterBag.setBackgroundResource(R.color.greenLight);
            }
        });

        filterBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterAll.setBackgroundResource(R.color.greenLight);
                filterNamaar.setBackgroundResource(R.color.greenLight);
                filterSonguuli.setBackgroundResource(R.color.greenLight);
                filterUhuulga.setBackgroundResource(R.color.greenLight);
                filterBag.setBackgroundResource(R.color.greebMain);
            }
        });


    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);

    }


}
