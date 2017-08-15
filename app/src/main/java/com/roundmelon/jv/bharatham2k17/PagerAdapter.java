package com.roundmelon.jv.bharatham2k17;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by DELL on 16-08-2016.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabFragment0 tab0 = new TabFragment0();
                return tab0;

            case 1:
                TabFragment1 tab1 = new TabFragment1();
                return tab1;
            case 2:
                TabFragment2 tab2 = new TabFragment2();
                return tab2;
            case 3:
                TabFragment3 tab3 = new TabFragment3();
                return tab3;
            case 4:
                TabFragment4 tab4 = new TabFragment4();
                return tab4;
            case 5:
                TabFragment5 tab5 = new TabFragment5();
                return tab5;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

}
