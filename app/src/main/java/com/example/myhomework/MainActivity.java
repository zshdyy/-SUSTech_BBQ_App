package com.example.myhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{
    private zhushiFragment zhushiFragment = new zhushiFragment();//声明Fragment
    private chaocaiFragment chaocaiFragment = new chaocaiFragment();
    private mltFragment mltFragment = new mltFragment();
    private qingzhencaiFragment qingzhencaiFragment = new qingzhencaiFragment();
    private Button btn_zhushi,btn_chaocai,btn_mlt,btn_qzc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.ll_detail,zhushiFragment).commitAllowingStateLoss();//绑定Fragment
        btn_zhushi = findViewById(R.id.btnzhushi);
        btn_chaocai = findViewById(R.id.btnchaocai);
        btn_mlt= findViewById(R.id.btnmalat);
        btn_qzc= findViewById(R.id.btnqingzhencai);

        OnClick onClick = new OnClick();
        btn_zhushi.setOnClickListener(onClick);
        btn_chaocai.setOnClickListener(onClick);
        btn_mlt. setOnClickListener(onClick);
        btn_qzc.setOnClickListener(onClick);

    }


    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if (view.getId()==R.id.btnzhushi){
                btn_zhushi.setBackgroundColor(getResources().getColor(R.color.white));
                btn_chaocai.setBackgroundColor(getResources().getColor(R.color.oringin));
                btn_mlt.setBackgroundColor(getResources().getColor(R.color.oringin));
                btn_qzc. setBackgroundColor(getResources().getColor(R.color.oringin));
                getSupportFragmentManager().beginTransaction().replace(R.id.ll_detail,zhushiFragment).commitAllowingStateLoss();
            }
            if (view.getId()==R.id.btnchaocai) {
                btn_zhushi.setBackgroundColor(getResources().getColor(R.color.oringin));
                btn_chaocai.setBackgroundColor(getResources().getColor(R.color.white));
                btn_mlt.setBackgroundColor(getResources().getColor(R.color.oringin));
                btn_qzc. setBackgroundColor(getResources().getColor(R.color.oringin));

                getSupportFragmentManager().beginTransaction().replace(R.id.ll_detail,chaocaiFragment).commitAllowingStateLoss();
            }
            if (view.getId()==R.id.btnqingzhencai) {
                btn_zhushi.setBackgroundColor(getResources().getColor(R.color.oringin));
                btn_chaocai.setBackgroundColor(getResources().getColor(R.color.oringin));
                btn_mlt.setBackgroundColor(getResources().getColor(R.color.oringin));
                btn_qzc. setBackgroundColor(getResources().getColor(R.color.white));

                getSupportFragmentManager().beginTransaction().replace(R.id.ll_detail,qingzhencaiFragment).commitAllowingStateLoss();
            }
            if (view.getId()==R.id.btnmalat) {
                btn_zhushi.setBackgroundColor(getResources().getColor(R.color.oringin));
                btn_chaocai.setBackgroundColor(getResources().getColor(R.color.oringin));
                btn_mlt.setBackgroundColor(getResources().getColor(R.color.white));
                btn_qzc. setBackgroundColor(getResources().getColor(R.color.oringin));

                getSupportFragmentManager().beginTransaction().replace(R.id.ll_detail,mltFragment).commitAllowingStateLoss();
            }
        }
    }
}