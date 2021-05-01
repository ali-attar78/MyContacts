package com.example.test;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    Context context;
    List<Contacts> contactList;
View view;



    public ContactAdapter(Context context, List<Contacts> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
Contacts contacts = contactList.get(position);
holder.phone.setText(contacts.getPhone());
        holder.name.setText(contacts.getName());
        holder.profile.setTag(contacts.getName());
        holder.sms_img.setTag(contacts.getName());
        holder.call_img.setTag(contacts.getName());


view.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        updateDeleteFragment fragment =new updateDeleteFragment(contactList.get(position));
        AppCompatActivity appCompatActivity = (AppCompatActivity) context;
        ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction().add(R.id.add_view,fragment).addToBackStack(null).commit();
    }
});






holder.sms_img.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String phone = (String) holder.phone.getText();
        Intent intent = new Intent(Intent.ACTION_VIEW);

            intent.setData(Uri.parse("sms:" + phone));
            context.startActivity(intent);

    }
});

holder.call_img.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String phone = (String) holder.phone.getText();
        Intent intent = new Intent(Intent.ACTION_VIEW);

        intent.setData(Uri.parse("tel:" + phone));
        context.startActivity(intent);
    }
});


    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }


    class ViewHolder extends  RecyclerView.ViewHolder{


        TextView name,phone;
        ImageView profile ,sms_img,call_img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_contact);
            phone = itemView.findViewById(R.id.phone_contact);
profile=itemView.findViewById(R.id.pro_item);
            sms_img=itemView.findViewById(R.id.sms_icon);
            call_img=itemView.findViewById(R.id.diling_icon);

        }
    }
}
