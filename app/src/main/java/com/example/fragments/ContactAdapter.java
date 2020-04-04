package com.example.fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private List<Contact> contactList;

    public ContactAdapter(List<Contact> movies){
        this.contactList = movies;
    }
    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.itm_recycler_view, parent, false);

        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, int position) {

        final Contact contact = contactList.get(position);

        ImageView image = holder.image;
        image.setImageResource(contact.getImageID());

        TextView name = holder.name;
        name.setText(contact.getName());

        TextView phoneNumber = holder.phoneNumber;
        phoneNumber.setText(contact.getPhoneNumber());

    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public void addContact(Contact contact){
        contactList.add(contact);
        //notifyItemChanged(0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView image;
        public TextView name;
        public TextView phoneNumber;

        public ViewHolder(View itemView){
            super(itemView);

            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            phoneNumber = itemView.findViewById(R.id.phoneNumber);

        }


    }

}
