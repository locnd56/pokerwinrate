package com.sotatek.locnguyen.pokertexasholdem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.sotatek.locnguyen.pokertexasholdem.customviews.PlayerView;
import com.sotatek.locnguyen.pokertexasholdem.enums.CardRankingEnum;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spn_cardranking;
    RadioGroup rg_cardsuit;
    int cardSuitChose = 0;
    LinearLayout ll_dealarea;
    LinearLayout ll_betarea;
    LinearLayout ll_winratearea;
    int numberPlayer = 0;
    Button btn_pick;
    List<PlayerView> players = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        numberPlayer = Integer.parseInt(intent.getStringExtra("quantity"));
        initView();
        initData();
        initListener();
    }

    private void initView() {
        spn_cardranking = (Spinner) findViewById(R.id.spn_cardranking);
        rg_cardsuit = (RadioGroup) findViewById(R.id.rg_cardsuit);
        ll_dealarea = (LinearLayout) findViewById(R.id.ll_dealarea);
        ll_betarea = (LinearLayout) findViewById(R.id.ll_betArea);
        ll_winratearea = (LinearLayout) findViewById(R.id.ll_winrateArea);
        btn_pick = (Button) findViewById(R.id.btn_choosecard);
    }

    private void initData() {
        for (int i = 1; i <= numberPlayer; i++) {
            PlayerView playerView = new PlayerView(this, null);
            ll_dealarea.addView(playerView);
        }
        spn_cardranking.setAdapter(new ArrayAdapter<CardRankingEnum>(this, android.R.layout.simple_spinner_item, CardRankingEnum.values()));
    }

    private void initListener() {
        rg_cardsuit.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_suit_clubs:
                        cardSuitChose = 1;
                        break;
                    case R.id.rb_suit_heart:
                        cardSuitChose = 2;
                        break;
                    case R.id.rb_suit_diamond:
                        cardSuitChose = 3;
                        break;
                    case R.id.rb_suit_spades:
                        cardSuitChose = 4;
                        break;
                    default:
                        cardSuitChose = 0;
                        break;
                }
            }
        });
        btn_pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.rb_suit_clubs:
                cardSuitChose = 1;
                break;
            case R.id.rb_suit_heart:
                cardSuitChose = 2;
                break;
            case R.id.rb_suit_diamond:
                cardSuitChose = 3;
                break;
            case R.id.rb_suit_spades:
                cardSuitChose = 4;
                break;
            default:
                cardSuitChose = 0;
                break;
        }
    }
}
