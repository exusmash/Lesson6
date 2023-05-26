package ru.mirea.kokorevkv.lesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import ru.mirea.kokorevkv.lesson6.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        sharedPreferences = getSharedPreferences("mireaSettings", Context.MODE_PRIVATE);
        activityMainBinding.editTextGroup.setText(sharedPreferences.getString("Group", "unknown"));
        activityMainBinding.editTextFilm.setText(sharedPreferences.getString("Film", "unknown"));
        activityMainBinding.editTextNumber.setText(sharedPreferences.getString("Number", String.valueOf(0)));
    }

    public void buttonOnClick(View view) {
        sharedPreferences = getSharedPreferences("mireaSettings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Group", String.valueOf(activityMainBinding.editTextGroup.getText()));
        editor.putString("Film", String.valueOf(activityMainBinding.editTextFilm.getText()));
        editor.putString("Number", String.valueOf(activityMainBinding.editTextNumber.getText()));
        editor.apply();
    }
}