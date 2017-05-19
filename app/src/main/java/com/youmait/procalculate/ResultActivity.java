package com.youmait.procalculate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ResultActivity extends AppCompatActivity {

    private String[] array  = {"1+2 = 3","1+2 = 3","1+2 = 3","1+2 = 3","1+2 = 3","1+2 = 3","1+2 = 3", "104/4 = 26"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ListView list = (ListView) findViewById(R.id.list_history);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
            (this, R.layout.layout_item, array);
        list.setAdapter(adapter);
    }
}
