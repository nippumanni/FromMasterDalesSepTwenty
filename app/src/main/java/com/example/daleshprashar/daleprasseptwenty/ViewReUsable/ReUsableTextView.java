package com.example.daleshprashar.daleprasseptwenty.ViewReUsable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.provider.SyncStateContract;
import android.util.AttributeSet;

import com.example.daleshprashar.daleprasseptwenty.MainConstants;
import com.example.daleshprashar.daleprasseptwenty.R;

import org.w3c.dom.Attr;

import androidx.appcompat.widget.AppCompatTextView;

class ReUsableTextView extends AppCompatTextView {

    private static final String TAG = ReUsableTextView.class.getSimpleName();


    public ReUsableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected void setCustomTypeFace(Context context, AttributeSet attributeSet, int defStyleAttr)
    {
        final TypedArray typedArray = context.obtainStyledAttributes(attributeSet,
                R.styleable.mainCustomWidgets,defStyleAttr,
                R.style.mainCustomText);
        try {
            //   below mainCustomWidgets_MainCustomTypeFace is from attrs stylebale  mainCustomWidgets but not put as dot, but hash(_)

                setTypeface(Typeface.createFromAsset(context.getAssets(),
                        MainConstants.ASSETS_FONT + typedArray.getString(R.styleable.mainCustomWidgets_MainCustomTypeFace)));
            }
            catch(Exception exception)
            {
            }
        }
    }

