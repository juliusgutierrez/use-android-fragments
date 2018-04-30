package com.example.julius.usefragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToolbarFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {

    private static int SEEK_VALUE = 10;
    private static EditText EDIT_TEXT;

    ToolbarListener activityCallback;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            activityCallback = (ToolbarListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement ToolbarListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.toolbar_fragment, container, false);

        EDIT_TEXT = view.findViewById(R.id.editText1);
        final SeekBar seekBar = view.findViewById(R.id.seekBar1);
        seekBar.setOnSeekBarChangeListener(this);

        final Button button = view.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(v);
            }
        });

        return view;
    }

    public interface ToolbarListener {
        void onButtonClick(int position, String text);
    }

    public void buttonClicked(View view) {
        activityCallback.onButtonClick(SEEK_VALUE, EDIT_TEXT.getText().toString());
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        SEEK_VALUE = progress;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //TODO auto-generated
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //TODO auto-generated
    }
}
