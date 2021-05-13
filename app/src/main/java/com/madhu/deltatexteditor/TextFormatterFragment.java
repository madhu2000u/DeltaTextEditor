package com.madhu.deltatexteditor;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TextFormatterFragment extends Fragment implements View.OnClickListener {

    private Communication mCallback;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.format_text_layout, container, false);
        ImageView bold;
        ImageView italic;
        ImageView underline;
        ImageView alignLeft;
        ImageView alignCenter;
        ImageView alignRight;
        ImageView clearText;
        ImageView fontIncrease;
        ImageView fontDecrease;
        bold = view.findViewById(R.id.bold);
        italic = view.findViewById(R.id.italic);
        underline = view.findViewById(R.id.underline);
        alignLeft = view.findViewById(R.id.allignLeft);
        alignCenter = view.findViewById(R.id.allignCenter);
        alignRight = view.findViewById(R.id.allignRight);
        clearText = view.findViewById(R.id.clearText);
        fontIncrease = view.findViewById(R.id.fontIncrease);
        fontDecrease = view.findViewById(R.id.fontDecrease);


        bold.setOnClickListener(this);
        italic.setOnClickListener(this);
        underline.setOnClickListener(this);
        alignLeft.setOnClickListener(this);
        alignCenter.setOnClickListener(this);
        alignRight.setOnClickListener(this);
        clearText.setOnClickListener(this);
        fontIncrease.setOnClickListener(this);
        fontDecrease.setOnClickListener(this);


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback = (Communication) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement Communication");
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bold:
                Log.d("msg", "Bold Button clicked");
                mCallback.sendFormatButtonId(R.id.bold);
                break;
            case R.id.italic:
                mCallback.sendFormatButtonId(R.id.italic);
                break;
            case R.id.underline:
                mCallback.sendFormatButtonId(R.id.underline);
                break;
            case R.id.allignLeft:
                mCallback.sendFormatButtonId(R.id.allignLeft);
                break;
            case R.id.allignCenter:
                mCallback.sendFormatButtonId(R.id.allignCenter);
                break;
            case R.id.allignRight:
                mCallback.sendFormatButtonId(R.id.allignRight);
                break;
            case R.id.clearText:
                mCallback.sendFormatButtonId((R.id.clearText));
                break;
            case R.id.fontIncrease:
                mCallback.sendFormatButtonId(R.id.fontIncrease);
                break;
            case R.id.fontDecrease:
                mCallback.sendFormatButtonId(R.id.fontDecrease);
                break;

        }
    }


}
