package com.chromeinfotech.mrphone.view.ui.activity.phonefinder;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chromeinfotech.mrphone.R;
import com.chromeinfotech.mrphone.view.ui.activity.BaseActivity.BaseActivity;

public class PhoneFinderActivity extends BaseActivity implements View.OnClickListener{
private RecyclerView phonefinderRecyclerView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_finder);
        this.reference();
        this.setListenrs();
        this.setAdapter();
    }

    private void setAdapter() {
        PhonefinderAdapter adapter = new PhonefinderAdapter(phonefinderRecyclerView.getContext());
        phonefinderRecyclerView.setAdapter(adapter);
        phonefinderRecyclerView.setHasFixedSize(true);
        phonefinderRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    }

    @Override
    public void reference() {
        phonefinderRecyclerView = (RecyclerView) findViewById(R.id.recyclerviewPhonefinder) ;
    }

    @Override
    public void setListenrs() {

    }

    @Override
    public void onClick(View v) {

    }
}
