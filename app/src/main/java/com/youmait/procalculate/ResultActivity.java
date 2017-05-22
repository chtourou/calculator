package com.youmait.procalculate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

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


  /*  private ListView lv;
    private DBHelper dbHelper;
    private ArrayList<String> list;
    private ArrayAdapter<String> adapter;
    private String calcName="";
    private String []EmptyList={"There is  no history yet"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lv=(ListView)findViewById(R.id.listView);
        dbHelper=new DBHelper(this);
        calcName=getIntent().getStringExtra("calcName");
        list=dbHelper.showHistory(calcName);
        if(!list.isEmpty())
            adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        else
            adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,EmptyList);
        lv.setAdapter(adapter);
    }

    public void onClick(View v)
    {

        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,EmptyList);
        lv.setAdapter(adapter);
    }

*/



}
