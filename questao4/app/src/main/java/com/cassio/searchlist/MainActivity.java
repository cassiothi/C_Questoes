package com.cassio.searchlist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity {
    private ListView listCar;
    private EditText search;
    private String[] arrayCar;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listCar = (ListView) findViewById(R.id.listview1);
        search = (EditText) findViewById(R.id.editText1);
        arrayCar = new String[]{"onix", "palio", "combi", "argo", "corolla", "hilux", "landau","celta"};
        arrayList = new ArrayList<>(Arrays.asList(arrayCar));

        adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                arrayList
        );

        listCar.setAdapter(adapter);
        listCar.setTextFilterEnabled(true);

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MainActivity.this.adapter.getFilter().filter(s);
                //Implement search here TODO

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    private static boolean checktypos(String s1, String s2) {
        int mismatch_count = 0;
        //check if the strings have the same length
        if(s1.length() == s2.length()) {
            //count the number of mismatching elements
            for(int i = 0; i < s1.length(); i++) {
                if(s1.charAt(i) != s2.charAt(i)) {
                    mismatch_count = mismatch_count + 1;
                }
            }
            // if the strings are 1 or zero typos away -> return true;
            if(mismatch_count <= 1) {
                return true;
            }
            else {
                return false;
            }
        }
        //string lengths are different
        else {
            //if the length difference is greater than 1 -> return false
            if(Math.abs( s1.length() - s2.length() ) > 1 ) {
                return false;
            }
            else {
                // if the length difference is equal 1
                //count the number of mismatching characters
                //Math.min(s1.length(), s2.length()) picks the lowest value between string lengths
                int i = 0;
                int j = 0;
                while(i < s1.length() && j < s2.length()) {
                    if(s1.charAt(i) != s2.charAt(j)) {
                        mismatch_count = mismatch_count + 1;
                        if(s1.length() > s2.length()) {
                            i++;
                        }
                        else{
                            j++;
                        }
                    }
                    else {
                        i++;
                        j++;
                    }
                }
                //if the number of mismatching characters is up to 1 -> return true
                if (mismatch_count <= 1)
                    return true;
                else
                    return false;
            }
        }
    }
}
