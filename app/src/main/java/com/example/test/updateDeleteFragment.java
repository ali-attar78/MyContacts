package com.example.test;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class updateDeleteFragment extends Fragment {

    TextView nameTv,phoneTv;
    Button edditBtn,deleteBtn;
    ContactAdapter adapter;
    Context context;
    Contacts contacts;
    updateDeleteFragment updatefrag;


    public  updateDeleteFragment( Contacts contacts){
        this.contacts=contacts;

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.delete_update_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        deleteBtn=view.findViewById(R.id.delete_btn);
        edditBtn=view.findViewById(R.id.update_btn);
        nameTv=view.findViewById(R.id.name_tv);
        phoneTv=view.findViewById(R.id.phone_tv);


        nameTv.setText(contacts.getName());
        phoneTv.setText(contacts.getPhone());


deleteBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        AlertDialog.Builder deleteDialog =new AlertDialog.Builder(getActivity());
        deleteDialog.setTitle("Delete");
        deleteDialog.setMessage("Do you want delete this contact?");

        deleteDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

DbHandler dbHandler= new DbHandler(getActivity());
dbHandler.open();

                dbHandler.delete(nameTv.getText().toString());
                dbHandler.delete(phoneTv.getText().toString());


dbHandler.close();
dialog.cancel();
                getActivity().onBackPressed();
            }
        });




deleteDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialog, int which) {
dialog.cancel();
    }
});
deleteDialog.create().show();


    }
});
edditBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {



        EdditFragment fragment = new EdditFragment(contacts.getName(),contacts.getPhone());

       getFragmentManager().beginTransaction().add(R.id.eddit_view,fragment).addToBackStack(null).commit();

    }
});

    }




}
