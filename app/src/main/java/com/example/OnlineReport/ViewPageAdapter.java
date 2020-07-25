package com.example.OnlineReport;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/*
 * viewPager adapter.
 * @author Chris Coughlan 2019
 */
class ViewPageAdapter extends FragmentPagerAdapter {

    ViewPageAdapter(FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        Fragment fragment = new Fragment();

        //finds the tab position (note array starts at 0)
        position = position+1;

        //finds the fragment
        switch (position)
        {
            case 1:
                //code
                //fragment = new com.example.OnlineReport.Welcome();
                break;
            case 2:
                //code
                fragment = new com.example.OnlineReport.ViewReports();
                break;
            case 3:
                //code
                fragment = new com.example.OnlineReport.WriteReport();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        position = position+1;

        CharSequence tabTitle = "";

        //finds the fragment
        switch (position)
        {
            case 1:
                //code
                tabTitle = "";
                break;
            case 2:
                //code
                tabTitle = "ViewReport";
                break;
            case 3:
                //code
                tabTitle = "WriteReport";
                break;
        }

        return tabTitle;
    }
}
