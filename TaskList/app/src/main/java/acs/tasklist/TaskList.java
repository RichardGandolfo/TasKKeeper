package acs.tasklist;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.ObjectOutput;
import java.util.ArrayList;

public class TaskList extends Activity {
    private ListView mListView;
    SharedPreferences shared;
    ArrayList<String> list;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_list);
        Intent intent = getIntent();
        if(intent.hasExtra("bool")){
            Toast.makeText(getApplicationContext(), "Task added successfully",
                    Toast.LENGTH_LONG).show();
        }
        shared = getSharedPreferences("tasks", Context.MODE_PRIVATE);
        mListView = findViewById(R.id.lvx);
        list = new ArrayList<String>();
        for (int i=1; i<=shared.getInt("next",1); i++){
            String item;
            item = shared.getString(Integer.toString(i),"");
            if(!item.equals("")) list.add(item);
        }
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);

        //if(i.hasExtra("OtherO")||i.hasExtra("EventO")||i.hasExtra("ShoppingO")||i.hasExtra("HomeworkO")){list.add(i.getStringExtra("OtherO"));}
        mListView.setAdapter(adapter);
    }

    public void goBack(View v)
    {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void clear(View v){
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this);

        builder.setTitle("Complete All")
                .setMessage("Are you sure you want to complete all of your tasks?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        shared = getSharedPreferences("tasks", Context.MODE_PRIVATE);
                        SharedPreferences.Editor e = shared.edit();
                        e.clear();
                        e.commit();
                        Toast.makeText(getApplicationContext(), "All tasks were completed",
                                Toast.LENGTH_LONG).show();
                        list.clear();
                        adapter.notifyDataSetChanged();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}

