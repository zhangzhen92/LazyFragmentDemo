package example.com.lazyfragmentdemo;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：
 * create on：2019-07-31 15:24
 */
public class MyFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments = new ArrayList<>();
    private Context mContext;

    public MyFragmentAdapter(FragmentManager fm, List<Fragment> mFragments, Context mContext) {
        super(fm);
        this.mFragments = mFragments;
        this.mContext = mContext;
    }

    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

    @Override
    public int getCount() {
        return mFragments == null ? 0 : mFragments.size();
    }
}
