package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FragmentHelper {
    public static void displayFragment(AppCompatActivity activity, int placeholderId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(placeholderId, fragment);
        fragmentTransaction.commit();
    }
}
