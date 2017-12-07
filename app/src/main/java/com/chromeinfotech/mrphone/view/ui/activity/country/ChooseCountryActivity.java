package com.chromeinfotech.mrphone.view.ui.activity.country;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.chromeinfotech.mrphone.R;
import com.chromeinfotech.mrphone.controller.utils.Utils;
import com.chromeinfotech.mrphone.view.ui.activity.BaseActivity.BaseActivity;


public class ChooseCountryActivity extends BaseActivity implements AdapterView.OnItemClickListener{

    private ListView listCountry ;
    private  String country [] ;
    private final int RESULT_CODE_LOGIN = 100 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_country);
        this.reference();
        this.init();
        this.setListenrs();
        this.setAdapter();
    }

    @Override
    public void init() {
        country        =  this.getResources().getStringArray(R.array.Country);
    }

    private void setAdapter() {
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, country);
        listCountry.setAdapter(itemsAdapter);
    }

    @Override
    public void reference() {
        listCountry = (ListView) findViewById(R.id.list_country);
    }

    @Override
    public void setListenrs() {
        listCountry.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent   = new Intent();
        Bundle bundle =new Bundle() ;
        bundle.putString("MESSAGE",country[position]);
        Utils.printLog("MESSAGE",""+country[position]);
        intent.putExtras(bundle);
        setResult(RESULT_CODE_LOGIN,intent);
        finish();
    }
}
