package acs.tasklist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.ObjectOutput;
import java.util.ArrayList;

public class TaskList extends Activity {
    private ListView mListView;
    SharedPreferences shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_list);
        //Intent i = getIntent();
        shared = getSharedPreferences("tasks", Context.MODE_PRIVATE);
        mListView = findViewById(R.id.lvx);
        ArrayList<String> list = new ArrayList<String>();
        for (int i=1; i<=shared.getInt("next",1); i++){
            String item;
            item = shared.getString(Integer.toString(i),"");
            if(!item.equals("")) list.add(item);
        }
        //if(i.hasExtra("OtherO")||i.hasExtra("EventO")||i.hasExtra("ShoppingO")||i.hasExtra("HomeworkO")){list.add(i.getStringExtra("OtherO"));}
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        mListView.setAdapter(adapter);
    }

    public void goBack(View v)
    {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}

