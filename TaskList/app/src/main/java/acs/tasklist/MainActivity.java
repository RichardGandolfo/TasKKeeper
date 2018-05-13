package acs.tasklist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.graphics.Color;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    SharedPreferences shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button b = (Button) findViewById(R.id.button);
        b.setBackgroundColor(Color.BLACK);
        b.setTextColor(Color.WHITE);
        b = findViewById(R.id.button3);
        b.setBackgroundColor(Color.BLACK);
        b.setTextColor(Color.WHITE);
        shared = getSharedPreferences("tasks", Context.MODE_PRIVATE);
        SharedPreferences.Editor e = shared.edit();
        int i = shared.getInt("next", 1);
        e.putInt("next", i);
        e.commit();
        TextView t = (TextView) findViewById(R.id.txt);
        if(shared.getAll().size()!=0)t.setText(Integer.toString(shared.getAll().size()-1));
        else t.setText(Integer.toString(0));
    }

    public void goToTaskList(View v){
        Intent i = new Intent(this, TaskList.class);
        startActivity(i);
    }

    public void goToAddTask(View v){
        Intent i = new Intent(this, AddTask.class);
        startActivity(i);
    }
}
