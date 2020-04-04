package com.example.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.fragments.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class ContactFragment extends DialogFragment implements View.OnClickListener {

    private EditText name;
    private EditText phone;
    private Button btnSubmit;
    private IAddContact listener;

    public ContactFragment() {
    }

    public static ContactFragment newInstance(){
        return new ContactFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contact, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name = view.findViewById(R.id.etName);
        phone = view.findViewById(R.id.etPhone);
        btnSubmit = view.findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (IAddContact) context;
    }

    @Override
    public void onClick(View v) {
        int picID = R.drawable.def;
        String contName = name.getText().toString();
        String contPhone = phone.getText().toString();
        Contact contact = new Contact(picID, contName, contPhone);

        listener.addContact(contact);
        dismiss();
    }
}
