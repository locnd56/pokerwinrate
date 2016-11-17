package com.sotatek.locnguyen.pokertexasholdem.customviews;

import android.app.Service;
import android.content.Context;
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

    public CardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();
    }

    private void initView() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.cardview, this);
        iv_cardview = (ImageView) findViewById(R.id.iv_cardview);
    }

    @Override
    public void onClick(View view) {

    }
}
