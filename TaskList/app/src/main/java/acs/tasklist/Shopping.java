package acs.tasklist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Shopping extends Activity {
    private ListView list;
    ArrayList<String> listItems=new ArrayList<String>();

    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_t);
        list = findViewById(R.id.lvx);
        adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        list.setAdapter(adapter);
    }

    public void addItem(View v)
    {
        String item;
        EditText ed = (EditText) findViewById(R.id.EditTextItems2);
        item = ed.getText().toString();
        if (!item.equals("")){
            listItems.add(item);
            adapter.notifyDataSetChanged();
            ed.setText("");
        }
    }

    public void cancel(View v)
    {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
