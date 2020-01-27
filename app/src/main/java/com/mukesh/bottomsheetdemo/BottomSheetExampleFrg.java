package com.mukesh.bottomsheetdemo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetExampleFrg extends BottomSheetDialogFragment implements
        View.OnClickListener {

    private BottomSheetListener bottomSheetListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_layout, container, false);

        view.findViewById(R.id.preview).setOnClickListener(this);
        view.findViewById(R.id.share).setOnClickListener(this);
        view.findViewById(R.id.makeACopy).setOnClickListener(this);
        view.findViewById(R.id.getLink).setOnClickListener(this);
        view.findViewById(R.id.emailACopy).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.preview:
                bottomSheetListener.previewClicked("Preview clicked");

                break;
            case R.id.share:
                bottomSheetListener.shareClicked("Share clicked");

                break;
            case R.id.makeACopy:
                bottomSheetListener.makeACopyClicked("Make A Copy clicked");

                break;
            case R.id.getLink:
                bottomSheetListener.getLinkClicked("Get Linked clicked");

                break;
            case R.id.emailACopy:
                bottomSheetListener.emailACopyClicked("Email A Copy clicked");

                break;


        }
        dismiss();
    }

    public interface BottomSheetListener {

        void previewClicked(String text);

        void shareClicked(String text);

        void getLinkClicked(String text);

        void makeACopyClicked(String text);

        void emailACopyClicked(String text);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            bottomSheetListener = (BottomSheetListener) context;
        } catch (ClassCastException ex) {
            ex.printStackTrace();

            throw new ClassCastException(context.toString() + "Must implement bottom sheet listener");
        }

    }
}
