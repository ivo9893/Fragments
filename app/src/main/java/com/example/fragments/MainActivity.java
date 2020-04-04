package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IAddContact{

    RecyclerView recyclerView;
    ContactAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact(R.drawable.weird_sonic, "Mitko", "0888463234"));
        contacts.add(new Contact(R.drawable.kuche, "Gosho", "0888463123"));
        contacts.add(new Contact(R.drawable.tiger, "Tiger", "0882341223"));
        contacts.add(new Contact(R.drawable.racoon, "Raco", "0223463123"));

        recyclerView = findViewById(R.id.recyclerView);

        adapter = new ContactAdapter(contacts);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                ContactFragment fragment = ContactFragment.newInstance();
                fragment.show(fm, "fragment_contact");
            }
        });


    }

    @Override
    public void addContact(Contact contact) {
        adapter.addContact(contact);
    }
}
