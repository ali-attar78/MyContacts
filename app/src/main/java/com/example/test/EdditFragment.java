package com.example.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class EdditFragment extends Fragment {

    String name,phone;
    Contacts contacts;
    EditText edditName,edditPhone;
    Button edditBtn;


    public EdditFragment(String name,String phone){
      this.name=name;
      this.phone=phone;
    }




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.eddit_fragment,container,false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edditName=view.findViewById(R.id.name_eddit);
        edditPhone=view.findViewById(R.id.phone_eddit);
        edditBtn=view.findViewById(R.id.eddit_btn);


        edditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                DbHandler dbHandler= new DbHandler(getActivity());
                dbHandler.open();

                dbHandler.update(name,edditName.getText().toString());
                dbHandler.update(phone,edditPhone.getText().toString());

                getActivity().onBackPressed();
                dbHandler.close();





            }
        });


    }
}
