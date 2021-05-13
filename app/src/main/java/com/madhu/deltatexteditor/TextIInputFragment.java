package com.madhu.deltatexteditor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class TextIInputFragment extends Fragment implements Communication {

    private static EditText editText;
    private int selectedButtonId;
    private float size;
    //private MySpannable spannable=new MySpannable("default");


    private Communication mCallback;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.editor_layout, container, false);
        editText = view.findViewById(R.id.editor);


        return view;
    }



    @SuppressLint("NewApi")
    private void doOperation() {
        int start_selection, end_selection;
        String text;
        text = editText.getEditableText().toString();
        start_selection = editText.getSelectionStart();
        end_selection = editText.getSelectionEnd();
        MySpannable mySpannable = new MySpannable(text);


        switch (selectedButtonId) {
            case R.id.bold:

                // text = editText.getEditableText().toString();
                //start_selection = editText.getSelectionStart();
                //end_selection = editText.getSelectionEnd();
                setBold(mySpannable, text, start_selection, end_selection);

                break;

            case R.id.italic:

                setItalics(mySpannable, text, start_selection, end_selection);
                break;
            case R.id.underline:

                setUnderline(mySpannable, text, start_selection, end_selection);
                break;
            case R.id.allignLeft:
                editText.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
                break;
            case R.id.allignCenter:
                editText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                //editText.setScaleY((float)(scaleY+2));
                //editText.setTextScaleX((float)(scaleX+2));
                //fontIncrease(mySpannable,text,start_selection,end_selection);

                break;
            case R.id.allignRight:
                editText.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
                break;
            case R.id.clearText:
                editText.setText("");
                break;
            case R.id.fontIncrease:
                size = editText.getTextSize();
                editText.setTextSize(size + 2);
                break;
            case R.id.fontDecrease:
                size = editText.getTextSize();
                editText.setTextSize(size - 2);
                break;


        }
    }

    private void fontIncrease(MySpannable spannableString, String text, int start_selection, int end_selection) {
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan((int) size + 2, true);
        spannableString.setSpan(absoluteSizeSpan, start_selection, end_selection, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        editText.setText(spannableString);
    }


    private void setUnderline(MySpannable spannableString, String text, int start_selection, int end_selection) {


        UnderlineSpan underlineSpan = new UnderlineSpan();
        spannableString.setSpan(underlineSpan, start_selection, end_selection, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //StyleSpan italic = new StyleSpan(Typeface.ITALIC);
        //spannableString.setSpan(italic, 0,text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        editText.setText(spannableString);


    }

    private void setItalics(MySpannable spannableString, String text, int start_selection, int end_selection) {
        Log.d("msg", "i am here");
        //SpannableString spannableString = new SpannableString(text);
        StyleSpan italic = new StyleSpan(Typeface.ITALIC);
        spannableString.setSpan(italic, start_selection, end_selection, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        editText.setText(spannableString);


    }

    private void setBold(MySpannable spannableString, String text, int start_selection, int end_selection) {
        Log.d("msg", "i am here in bold");

        //SpannableString spannableString = new SpannableString(text);
        StyleSpan bold = new StyleSpan(Typeface.BOLD);
        spannableString.setSpan(bold, start_selection, end_selection, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        editText.setText(spannableString);
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
    public void sendFormatButtonId(int Id) {
        selectedButtonId = Id;
        doOperation();

    }
}
