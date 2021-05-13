package com.madhu.deltatexteditor;

import android.text.SpannableString;

public class MySpannable extends SpannableString {

    String text;

    public MySpannable(CharSequence source) {
        super(source);
        this.text = source.toString();
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;

    }

    @Override
    public void setSpan(Object what, int start, int end, int flags) {
        super.setSpan(what, start, end, flags);

    }
}
