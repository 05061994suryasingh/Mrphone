package com.chromeinfotech.mrphone.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.chromeinfotech.mrphone.R;
import com.chromeinfotech.mrphone.model.NotificationListModel;

import java.util.ArrayList;

/**
 * Created by user on 23/5/17.
 */

public class NotificationListAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater mLayoutInflater;
    private ArrayList<NotificationListModel> notificationListModels = new ArrayList<>();


    public NotificationListAdapter(Context context, ArrayList<NotificationListModel> notificationListModels) {
        this.context                    =    context;
        this.notificationListModels     =    notificationListModels;
        this.mLayoutInflater            =    LayoutInflater.from(context);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if(convertView    ==  null) {
            convertView   =   mLayoutInflater.inflate(R.layout.layout_notification_list, null);
            viewHolder    =   new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else
            viewHolder =  (ViewHolder) convertView.getTag();
        viewHolder.txtNotification.setText(notificationListModels.get(position).getNotification());
        return convertView;
    }


    @Override
    public int getCount() {
        return notificationListModels.size();
    }

    @Override
    public NotificationListModel getItem(int position) {
        return notificationListModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class  ViewHolder{
        private ImageView imgNotificationicon;
        private TextView txtNotification;

        public ViewHolder( View view ) {
            imgNotificationicon    =   (ImageView)   view.findViewById(R.id.img_notificationicon);
            txtNotification        =   (TextView)    view.findViewById(R.id.txt_notification);
        }
    }
}
