package com.example.samsung.p0551_headerfooter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    ListView lvMain;
    ArrayAdapter<String> adapter;

    View header1;
    View header2;

    View footer1;
    View footer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        lvMain = (ListView) findViewById(R.id.lvMain);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.data));

        //Creating Header and Footer
        header1 = createHeader("header 1");
        header2 = createHeader("header 2");
        footer1 = createFooter("footer 1");
        footer2 = createFooter("footer 2");

        fillList();
    }

    //Creating list
    void fillList() {
        try {
            lvMain.addHeaderView(header1);
            lvMain.addHeaderView(header2, "some text for headr 2", false);
            lvMain.addFooterView(footer1);
            lvMain.addFooterView(footer2, "some text for footer 2", false);
            lvMain.setAdapter(adapter);
        } catch (Exception e) {
            Log.d(LOG_TAG, e.getMessage());
        }
    }

    //Pressing on button
    public void onClicButton(View view) {
        Object object;
        HeaderViewListAdapter headerViewListAdapter =
                (HeaderViewListAdapter) lvMain.getAdapter();
        object = headerViewListAdapter.getItem(1);
        Log.d(LOG_TAG, "headerViewListAdapter.getItem(1) = " + object.toString());
        object = headerViewListAdapter.getItem(4);
        Log.d(LOG_TAG, "headerViewListAdapter.getItem(4) = " + object.toString());

        ArrayAdapter<String> aaAdapter = (ArrayAdapter<String>) headerViewListAdapter.getWrappedAdapter();
        object = aaAdapter.getItem(1);
        Log.d(LOG_TAG, "aaAdapter.getItem(1) = " + object.toString());
        object = aaAdapter.getItem(4);
        Log.d(LOG_TAG, "aaAdapter.getItem(4) = " + object.toString());

    }

    //Creating Header
    View createHeader(String text) {
        View view = getLayoutInflater().inflate(R.layout.header, null);
        ((TextView) view.findViewById(R.id.tvText)).setText(text);
        return view;
    }

    //Creating Footer
    View createFooter(String text) {
        View view = getLayoutInflater().inflate(R.layout.footer, null);
        ((TextView) view.findViewById(R.id.tvText)).setText(text);
        return view;
    }

}
