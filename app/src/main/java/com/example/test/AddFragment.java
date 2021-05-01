package com.example.test;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.zip.Inflater;

public class AddFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_fragment,container,false);
    }

    EditText edditPhone,edditName;
    Button deleteButton,addButton;
    ContactAdapter adapter;
    Context context;



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews(view);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edditPhone.length()!=0||edditName.length()!=0){
                String name =edditName.getText().toString();
                String phone=edditPhone.getText().toString();
                edditName.setText("");
                edditPhone.setText("");
                DbHandler dbHandler=new DbHandler(getContext());
                dbHandler.open();
                dbHandler.insert(name);
                dbHandler.insert(phone);
                dbHandler.close();





                    getActivity().onBackPressed();

                }

            }

        });

    }

    private void findViews(View view) {
        edditName=view.findViewById(R.id.add_user);
        edditPhone=view.findViewById(R.id.add_phone);
        addButton=view.findViewById(R.id.add_btn);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
