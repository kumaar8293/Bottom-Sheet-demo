package com.mukesh.bottomsheetdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ModalBottomSheetActivity extends AppCompatActivity
        implements BottomSheetExampleFrg.BottomSheetListener {
    private TextView buttonClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modal_bottom_sheet);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Modal(dialogs)");

        final BottomSheetExampleFrg bottomSheetExample = new BottomSheetExampleFrg();

        findViewById(R.id.openModalBottomSheet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bottomSheetExample.show(getSupportFragmentManager(), "example");
            }
        });

        buttonClicked = findViewById(R.id.buttonClicked);
    }

    @Override
    public void previewClicked(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        buttonClicked.setText(text);
    }

    @Override
    public void shareClicked(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        buttonClicked.setText(text);
    }

    @Override
    public void getLinkClicked(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        buttonClicked.setText(text);
    }

    @Override
    public void makeACopyClicked(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        buttonClicked.setText(text);
    }

    @Override
    public void emailACopyClicked(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        buttonClicked.setText(text);
    }
}
