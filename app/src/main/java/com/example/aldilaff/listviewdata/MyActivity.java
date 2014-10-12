package com.example.aldilaff.listviewdata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MyActivity extends Activity {
    ArrayList<String> listDataVar;
    ArrayAdapter arrayAdapter;
    ListView listViewObjObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        listDataVar = new ArrayList<String>();
        for(int i=0; i<50; i++){
            listDataVar.add(String.valueOf(i));
        }

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listDataVar);

        listViewObjObject = (ListView) findViewById(R.id.listViewObject);

        listViewObjObject.setAdapter(arrayAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        } else if(id == R.id.newItem){
            Intent intent = new Intent(this, NewItemActivity.class);
            startActivityForResult(intent, 1);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(data == null){
            Log.e("data", "data is null");
            return;
        }

        if(resultCode == 1){
            Log.e("data", "its there");
            String text = data.getStringExtra("item");
            listDataVar.add(text);
            arrayAdapter.notifyDataSetChanged();

        }
    }
}
