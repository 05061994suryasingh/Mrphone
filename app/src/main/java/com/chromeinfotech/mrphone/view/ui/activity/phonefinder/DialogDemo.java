package com.chromeinfotech.mrphone.view.ui.activity.phonefinder;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.chromeinfotech.mrphone.controller.utils.Utils;

/**
 * Created by user on 6/9/17.
 */

public class DialogDemo {
    private int selectCount = 0 ;
    private static final String TAG = "DialogDemo";
    private Context mContext;
    public  DialogDemo(Context mContext){
        this.mContext = mContext;
    }

    public void showDialogButtonClick(String title, String[] arrayList1, final TextView txtcategorycount) {
        Log.i(TAG, "show Dialog ButtonClick");
        final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle(title);

        final String[] arrayList = arrayList1 ;

        builder.setMultiChoiceItems(arrayList1,null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                Utils.printLog("DialogDemo","which="+which);
                ++selectCount;
                Utils.printLog("DialogDemo","isChecked="+isChecked);
            }
        })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                Utils.printLog("DialogDemo","which="+which);
                                Utils.printLog("DialogDemo","selectCount="+selectCount);
                                Log.d(TAG,"Which value="+which);
                                txtcategorycount.setText(""+selectCount);
                                dialog.dismiss();
                            }
                        }
                )
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                Toast.makeText(mContext, "Cancel click", Toast.LENGTH_SHORT).show();
                            }
                        }
                );
        AlertDialog alert = builder.create();
        alert.show();
    }
}
