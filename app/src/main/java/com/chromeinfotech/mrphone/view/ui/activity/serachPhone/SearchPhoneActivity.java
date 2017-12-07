package com.chromeinfotech.mrphone.view.ui.activity.serachPhone;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.chromeinfotech.mrphone.R;
import com.chromeinfotech.mrphone.view.ui.activity.BaseActivity.BaseActivity;
import com.chromeinfotech.mrphone.view.ui.activity.compare.CompareActivityAdapter;

public class SearchPhoneActivity extends BaseActivity implements View.OnClickListener{
    private ImageView imgMenuPhonefinder ,imgClear ;
    private EditText edtenterphonename ;
    private RecyclerView recyclerView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_phone);
        this.reference();
        this.setListenrs();
        this.setAdapter();
    }

    private void setAdapter() {
        CompareActivityAdapter adapter= new CompareActivityAdapter(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void reference() {
        imgMenuPhonefinder     = (ImageView) findViewById(R.id.imgMenuPhonefinder) ;
        imgClear               = (ImageView) findViewById(R.id.imgClear) ;
        edtenterphonename      = (EditText) findViewById(R.id.edtenterphonename);
        recyclerView           = (RecyclerView) findViewById(R.id.recycleview_compare_phone);
    }

    @Override
    public void setListenrs() {
        imgMenuPhonefinder.setOnClickListener(this);
        imgClear.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgMenuPhonefinder:
                this.finish();
                onBackPressed();
                break;
            case R.id.imgClear:
                edtenterphonename.setText("");
                break;
        }
    }
}
