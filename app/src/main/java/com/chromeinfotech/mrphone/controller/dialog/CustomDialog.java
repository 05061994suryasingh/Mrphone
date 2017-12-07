package com.chromeinfotech.mrphone.controller.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chromeinfotech.mrphone.R;

/**
 * custom dialog extends Dialog and set title msg and button to customDialog
 */

public class CustomDialog {
    private Context    context ;
    public  Button     btnLater , btnChoose;
    public TextView    dialogTitle , dialogMessage ;
    private AlertDialog dialog;

    /**
     * constructor
     * @param context
     */
    public CustomDialog(Context context) {
        this.context = context ;

    }

    /**
     * Method in Which create a Custom dialog box
     * and called form Login Activity which set Title And Alert
     * Message.
     * @param title
     * @param message
     */
    public  void showCustomAlertDialog(String title, String message) {
        dialog                  = new AlertDialog.Builder(context).create();
        LayoutInflater inflater = LayoutInflater.from(context) ;
        final View view         = inflater.inflate(R.layout.layout_select_country_dialog , null);
        dialog.setView(view);
        this.setReference(view);
        setTitleandmsg(title,message);
        dialog.show();

    }
    /**
     * Method in Which create a Custom dialog box
     * and called form Login Activity which set Title And Alert
     * Message.
     */
    public  void showCustomAlertDialog() {
        dialog                  = new AlertDialog.Builder(context).create();
        LayoutInflater inflater = LayoutInflater.from(context) ;
        final View view         = inflater.inflate(R.layout.layout_select_country_dialog , null);
        dialog.setView(view);
        dialog.setCancelable(false);
        this.setReference(view);
        dialog.show();

    }

    private void setTitleandmsg(String title, String message) {
        dialogTitle.setText(title);
        dialogMessage.setText(message);
    }

    /**
     * dismiss the dialog
     */
    public void dismiss(){
        dialog.dismiss();
    }

    /**
     * create reference from the widgets
     * @param view
     */
    private void setReference(View view) {
        dialogTitle                       = (TextView)   view.findViewById(R.id.txttitle);
        dialogMessage                     = (TextView)   view.findViewById(R.id.txtmsg);
        btnChoose                         = (Button)     view.findViewById(R.id.btn_choose);
        btnLater                          = (Button)     view.findViewById(R.id.btn_Later);
    }


}
