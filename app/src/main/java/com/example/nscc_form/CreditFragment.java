package com.example.nscc_form;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nscc_form.databinding.FragmentAddBinding;
import com.example.nscc_form.databinding.FragmentCreditBinding;

import java.util.Calendar;
import java.util.Date;

public class CreditFragment extends Fragment {

    FragmentCreditBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        binding = FragmentCreditBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Date time = Calendar.getInstance().getTime();
        binding.timeview.setText(time.toString());
        return root;
    }
}