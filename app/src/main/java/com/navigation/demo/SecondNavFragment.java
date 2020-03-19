package com.navigation.demo;

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
import android.widget.Toast;

import java.util.Objects;


public class SecondNavFragment extends Fragment implements View.OnClickListener {
    private NavController navController;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second_nav, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(Objects.requireNonNull(getActivity()), R.id.my_nav_host_fragment);
        Button button = view.findViewById(R.id.btn_frag_second);
        button.setOnClickListener(this);

        assert getArguments() != null;
        DataTest dataTest = (DataTest) getArguments().getSerializable("Data");
        assert dataTest != null;
        Toast.makeText(getActivity(), dataTest.getValue(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_frag_second:
//                navController.popBackStack();//back to previous fragment
                navController.popBackStack(R.id.firstNavFragment, true);//back to fragment with id
                break;
            default:
                break;
        }
    }
}
