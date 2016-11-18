package com.sotatek.locnguyen.pokertexasholdem.customviews;

import android.app.Service;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sotatek.locnguyen.pokertexasholdem.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by locnguyen on 17/11/2016.
 */
public class WinRatingView extends LinearLayout {

    Context context;
    @BindView(R.id.tv_winrating)
    TextView tv_winrating;
    @BindView(R.id.tv_tierating)
    TextView tv_tierating;
    @BindView(R.id.tv_orderplayer)
    TextView tv_orderplayer;


    public WinRatingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();
    }

    private void initView() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.activity_main_winrating, this);
        ButterKnife.bind(this);
    }

    public void setOrderPlayer(String order) {
        tv_orderplayer.setText(order);
    }

    public void setWinRating(String winRating) {
        tv_winrating.setText(winRating);
    }

    public void setTieRating(String tieRating) {
        tv_tierating.setText(tieRating);
    }
}
