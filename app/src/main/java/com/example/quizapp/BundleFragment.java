package com.example.quizapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class BundleFragment extends Fragment {

    private TextView textRequirement;
    private TextView textAnswerOption1;
    private TextView textAnswerOption2;
    private TextView textAnswerOption3;
    private TextView textAnswerOption4;

    private String requirement;
    private String answerOption1;
    private String answerOption2;
    private String answerOption3;
    private String answerOption4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            requirement = getArguments().getString(FirstActivity.requirement, "");
            answerOption1 = getArguments().getString(FirstActivity.answerOption1, "");
            answerOption2 = getArguments().getString(FirstActivity.answerOption2, "");
            answerOption3 = getArguments().getString(FirstActivity.answerOption3, "");
            answerOption4 = getArguments().getString(FirstActivity.answerOption4, "");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bundle, container, false);
        textRequirement = view.findViewById(R.id.requirement);
        textAnswerOption1 = view.findViewById(R.id.answerOption1);
        textAnswerOption2 = view.findViewById(R.id.answerOption2);
        textAnswerOption3 = view.findViewById(R.id.answerOption3);
        textAnswerOption4 = view.findViewById(R.id.answerOption4);

        textRequirement.setText(String.format("%s", requirement));
        textAnswerOption1.setText(String.format("%s", answerOption1));
        textAnswerOption2.setText(String.format("%s", answerOption2));
        textAnswerOption3.setText(String.format("%s", answerOption3));
        textAnswerOption4.setText(String.format("%s", answerOption4));

        return view;
    }
}