package com.navigation.demo;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Objects;

public class FirstNavFragment extends Fragment implements View.OnClickListener {
    private NavController navController;
    private MainActivity activity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first_nav, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        navController = Navigation.findNavController(getActivity(), R.id.my_nav_host_fragment);
        Button button = view.findViewById(R.id.btn_frag_first);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_frag_first:
                Bundle bundle = new Bundle();
                DataTest dataTest = activity.getDataTest();
                bundle.putSerializable("Data", dataTest);
                navController.navigate(R.id.action_firstNavFragment_to_secondNavFragment, bundle);
                break;
            default:
                break;
        }
    }
}
