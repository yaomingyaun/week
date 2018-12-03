package com.bw.ymy.yaomingyuan1203;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private  String[] desc=new String[]{"电动牙刷","沐浴露","洗发水","牙膏","电动牙刷","男装","女装","儿童用品","床上用品","京东",};
    Custor custor;
    Custor histor;
    EditText et;
    Dao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dao=new Dao(MainActivity.this);


        //获取资源id
        custor=findViewById(R.id.custormmm);
        et=findViewById(R.id.et_text);
        histor=findViewById(R.id.histor);



        //玄幻
        for (String str:desc)
        {
            final TextView textView=new TextView(MainActivity.this);
            textView.setText(str);
            histor.addView(textView);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this,textView.getText().toString(),Toast.LENGTH_LONG).show();
                }
            });
        }



        List<String> list=dao.select();
        if(list.size()!=0)
        {
            for (String string:list)
            {
                 TextView tv=new TextView(MainActivity.this);
                tv.setText(et.getText());
                tv.setTextColor(Color.GREEN);
                custor.addView(tv);

            }
        }

        //点击添加按钮
        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView tv=new TextView(MainActivity.this);
                tv.setText(et.getText());
                tv.setTextColor(Color.GREEN);
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,tv.getText().toString(),Toast.LENGTH_LONG).show();
                    }
                });
                boolean b=dao.sel(et.getText().toString());
                if(!et.getText().toString().equals("")&&b)
                {
                    dao.add(et.getText().toString());
                    custor.addView(tv);
                }

            }
        });
        findViewById(R.id.dell).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao.dell();
                custor.removeAllViews();
            }
        });

    }
}
