 package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

 public class MainActivity extends AppCompatActivity {

    List<Contacts> contacts;
    RecyclerView recyclerView;
FloatingActionButton floatButton;
ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
floatButton=findViewById(R.id.float_button);



floatButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        AddFragment fragment = new AddFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.add_view,fragment).addToBackStack(null).commit();
    }



});






    }

     @Override
     protected void onResume() {
         super.onResume();
         contacts = new ArrayList<>();
         String[] temp;
         DbHandler dbhand = new DbHandler(MainActivity.this);
         dbhand.open();
         temp=dbhand.getAllTodo();
         dbhand.close();
         if(temp.length>=2){
         for(int i=0,j=1;i<temp.length;i+=2,j+=2){

             contacts.add(new Contacts(temp[i],temp[j]));
         }
         adapter = new ContactAdapter(MainActivity.this,contacts);
recyclerView.setAdapter(adapter);
recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

     }}



     @Override
     public void onBackPressed() {

        if(getSupportFragmentManager().getBackStackEntryCount()>0)
            onResume();

         super.onBackPressed();
     }
 }