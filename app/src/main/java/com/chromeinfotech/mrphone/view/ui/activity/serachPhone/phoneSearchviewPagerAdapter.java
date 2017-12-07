package com.chromeinfotech.mrphone.view.ui.activity.serachPhone;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.chromeinfotech.mrphone.view.ui.fragement.buy.BuyPhoneFragment;
import com.chromeinfotech.mrphone.view.ui.fragement.reviews.ReviewPhoneFragement;
import com.chromeinfotech.mrphone.view.ui.fragement.spaces.SpaceFragment;
import com.chromeinfotech.mrphone.view.ui.fragement.stories.StoriesFragement;
import com.chromeinfotech.mrphone.view.ui.fragement.summary.SummaryFragement;

/**
 * Created by user on 7/9/17.
 */
public class phoneSearchviewPagerAdapter  extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;

    public phoneSearchviewPagerAdapter(FragmentManager supportFragmentManager, int tabCount) {
        super(supportFragmentManager);
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                SummaryFragement  summaryfragment= new SummaryFragement();
                return summaryfragment;
            case 1:
                SpaceFragment spaceFragement = new SpaceFragment();
                return spaceFragement;
            case 2:
                StoriesFragement storiesFragment = new StoriesFragement();
                return storiesFragment;
            case 3:
                ReviewPhoneFragement reviewFragment = new ReviewPhoneFragement();
                return reviewFragment;
            case 4:
                BuyPhoneFragment buyPhoneFragment = new BuyPhoneFragment();
                return buyPhoneFragment;
            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}
