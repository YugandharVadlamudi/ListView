package com.example.kiran.listview;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> naems = new ArrayList<>();
    String item[]={"reena","vijji"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv_lisView = (ListView) findViewById(R.id.listView);
        for(int i=0;i<item.length;i++){
            naems.add(item[i]);
        }

//        naems.add("usha");
//        naems.add("abhi");
//        naems.add("reena");
//        naems.add("vijji");
        CustomAdapter adapter = new CustomAdapter(MainActivity.this, naems);
        lv_lisView.setAdapter(adapter);
    }

    class CustomAdapter extends BaseAdapter {

        Context c;
        ArrayList<String> na;

        public CustomAdapter(Context c, ArrayList<String> naems) {
            this.c = c;
            this.na = naems;
        }

        @Override
        public int getCount() {
            return na.size();
        }

        @Override
        public Object getItem(int position) {
            return na.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(c).inflate(R.layout.row_item, null);
                ImageView iv = (ImageView) convertView.findViewById(R.id.iv);
                TextView tv = (TextView) convertView.findViewById(R.id.tv);
                tv.setText(na.get(position));
            }
            return convertView;
        }
    }
}
