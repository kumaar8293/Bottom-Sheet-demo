package com.mukesh.bottomsheetdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {
    private BottomSheetBehavior bottomSheetBehavior;
    private TextView btnBottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View bottomView = findViewById(R.id.bottomSheet);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomView);

        btnBottomSheet = findViewById(R.id.status);
        findViewById(R.id.expend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });
        findViewById(R.id.collapsed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });

        bottomSheetBehavior.setBottomSheetCallback
                (new BottomSheetBehavior.BottomSheetCallback() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

                switch (newState) {

                    case BottomSheetBehavior.STATE_HIDDEN:
                        btnBottomSheet.setText("Hidden");
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        btnBottomSheet.setText("STATE_EXPANDED");

                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        btnBottomSheet.setText("STATE_COLLAPSED");

                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        btnBottomSheet.setText("Dragging");
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        btnBottomSheet.setText("Setting");
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                btnBottomSheet.setText("Dragging");
            }
        });

        findViewById(R.id.more).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ModalBottomSheetActivity.class));
            }
        });


    }
}
