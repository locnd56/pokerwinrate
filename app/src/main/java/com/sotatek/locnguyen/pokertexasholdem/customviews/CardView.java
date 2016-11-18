package com.sotatek.locnguyen.pokertexasholdem.customviews;

import android.app.Service;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.sotatek.locnguyen.pokertexasholdem.R;

/**
 * Created by locnguyen on 17/11/2016.
 */
public class CardView extends LinearLayout implements View.OnClickListener {

    Context context;
    ImageView iv_cardview;
    int resourceId;
    boolean isActivity;
    OnClickCardListener onClickCardListener;

    public OnClickCardListener getOnClickCardListener() {
        return onClickCardListener;
    }

    public void setOnClickCardListener(OnClickCardListener onClickCardListener) {
        this.onClickCardListener = onClickCardListener;
    }

    public CardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.ImageView,
                0, 0);
        resourceId = a.getInteger(R.styleable.ImageView_addimage, 0);
        isActivity = a.getBoolean(R.styleable.ImageView_isactivity, true);
        initView();
    }

    private void initView() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.cardview, this);
        iv_cardview = (ImageView) findViewById(R.id.iv_cardview);
        if (resourceId != 0) {
            iv_cardview.setImageResource(resourceId);
        }
    }

    public void setImageView(int resourceId) {
        iv_cardview.setImageResource(resourceId);
    }

    @Override
    public void onClick(View view) {
        onClickCardListener.onClick(view, isActivity);
    }

    public interface OnClickCardListener {
        public void onClick(View view, boolean isActivity);
    }
}
