package com.ea222.reminderlistt4;

import Adapter.MyAdapter;
import Model.ListItem;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView reciclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;
   // MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //did not need to typecast (RecyclerView)
        reciclerView = findViewById(R.id.reciclerViewID);
        reciclerView.setHasFixedSize(true);

        reciclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        for (int i = 0; i<14; i++) {
            ListItem listItem = new ListItem(
                    "Item " + (i+1),
                    "Description",
                    "rating"
            );
            listItems.add(listItem);
        }

        adapter = new MyAdapter(this, listItems);


//        mAdapter = new MyAdapter(this, listItems,
//                new adapterClickListener(){
//                    @Override
//                    public void onClickListener(int position){
//                        //    Toast.makeText(MainActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
//                    }
//
//                },
//                new adapterDeleteListener(){
//                    @Override
//                    public void onDeleteListener(int position){
//                        listItems.remove(position);
//                        mAdapter.notifyDataSetChanged();
//                    }
//                });

        reciclerView.setAdapter(adapter);

    }
}
