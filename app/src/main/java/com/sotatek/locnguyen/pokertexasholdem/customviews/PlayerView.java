package com.sotatek.locnguyen.pokertexasholdem.customviews;

import android.app.Service;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sotatek.locnguyen.pokertexasholdem.R;

/**
 * Created by locnguyen on 16/11/2016.
 */
public class PlayerView extends LinearLayout {

    Context context;
    OnClickRemovePlayerListener onClickRemovePlayerListener;
    OnClickCardListener onClickCardListener;
    TextView tv_player;
    TextView tv_orderplayer;
    CardView cv_card1;
    CardView cv_card2;
    EditText edt_stats;
    Button btn_remove;
    String orderPlayer;

    public PlayerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.OrderPlayer,
                0, 0);
        orderPlayer = a.getString(R.styleable.OrderPlayer_addorder);
        this.context = context;
        initView();
        initData();
        initListener();
    }

    public OnClickCardListener getOnClickCardListener() {
        return onClickCardListener;
    }

    public void setOnClickCardListener(OnClickCardListener onClickCardListener) {
        this.onClickCardListener = onClickCardListener;
    }

    private void initListener() {
        btn_remove.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                PlayerView.this.setVisibility(View.GONE);
                onClickRemovePlayerListener.onClick();
            }
        });

        cv_card1.setOnClickCardListener(new CardView.OnClickCardListener() {
            @Override
            public void onClick(View view, boolean isActivity) {
                onClickCardListener.onClick(Integer.valueOf(orderPlayer), 1, view, isActivity);
            }
        });

        cv_card2.setOnClickCardListener(new CardView.OnClickCardListener() {
            @Override
            public void onClick(View view, boolean isActivity) {
                onClickCardListener.onClick(Integer.valueOf(orderPlayer), 2, view, isActivity);
            }
        });
    }

    private void initData() {
    }

    public void setOrderPlayer(String orderPlayer) {
        tv_player.setText(orderPlayer);
    }

    private void initView() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.playerview, this);
        tv_player = (TextView) findViewById(R.id.tv_player);
        cv_card1 = (CardView) findViewById(R.id.cv_playerview_card1);
        cv_card2 = (CardView) findViewById(R.id.cv_playerview_card2);
        edt_stats = (EditText) findViewById(R.id.edt_stats);
        btn_remove = (Button) findViewById(R.id.btn_remove);

    }

    public interface OnClickRemovePlayerListener {
        public void onClick();
    }

    public OnClickRemovePlayerListener getOnClickRemovePlayerListener() {
        return onClickRemovePlayerListener;
    }

    public void setOnClickRemovePlayerListener(OnClickRemovePlayerListener onClickRemovePlayerListener) {
        this.onClickRemovePlayerListener = onClickRemovePlayerListener;
    }

    public interface OnClickCardListener {
        public void onClick(int orderPlayer, int cardOrder, View view, boolean isActivity);
    }
}
