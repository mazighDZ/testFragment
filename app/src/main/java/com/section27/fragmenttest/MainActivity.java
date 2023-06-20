package com.section27.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    setButtonClickHandler(R.id.imgGroup, groupFragment.class,"groupFr");
        setButtonClickHandler(R.id.btnChat, ChatFragment.class, "groupFr");
        setButtonClickHandler(R.id.btnStatus, StatusFragment.class, "statusFr");
        setButtonClickHandler(R.id.btnCalls, CallsFragment.class, "callFr");
    }


    public void setButtonClickHandler(int buttonId , Class<? extends Fragment> fragmentClass ,String backStackName)
    {
        if(buttonId!= R.id.imgGroup){
            Button button = findViewById(buttonId);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.mainFragment, fragmentClass, null)
                            .setReorderingAllowed(true)
                            .addToBackStack(backStackName) // Name can be null
                            .commit();
                }
            });
        } else  {
            ImageView    img= findViewById(buttonId);
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.mainFragment, fragmentClass, null)
                            .setReorderingAllowed(true)
                            .addToBackStack(backStackName) // Name can be null
                            .commit();
                }
            });
        }




    }

}