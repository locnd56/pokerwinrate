package com.sotatek.locnguyen.pokertexasholdem.customviews;

import android.app.Service;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sotatek.locnguyen.pokertexasholdem.R;
import com.sotatek.locnguyen.pokertexasholdem.enums.CardRankingEnum;

/**
 * Created by locnguyen on 16/11/2016.
 */
public class PlayerView extends LinearLayout implements View.OnClickListener {

    Context context;
    OnClickCardViewListener onClickCardViewListener;
    TextView tv_player;
    CardView cv_card1;
    CardView cv_card2;
    EditText edt_stats;
    Button btn_remove;

    public PlayerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();
        initData();
        initListener();
    }

    private void initListener() {
        btn_remove.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "remove", Toast.LENGTH_LONG);
            }
        });
    }

    private void initData() {

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


    @Override
    public void onClick(View view) {
        this.setVisibility(View.GONE);
        onClickCardViewListener.onClick();
    }

    public interface OnClickCardViewListener {
        public void onClick();
    }
}
