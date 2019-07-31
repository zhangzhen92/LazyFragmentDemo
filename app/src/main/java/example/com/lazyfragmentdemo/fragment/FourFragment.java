package example.com.lazyfragmentdemo.fragment;

import android.os.Bundle;

import example.com.lazyfragmentdemo.R;

/**
 * 类描述：
 * create on：2019-07-31 15:31
 */
public class FourFragment extends LazyFragment{
    public static FourFragment newInstance() {
        
        Bundle args = new Bundle();
        
        FourFragment fragment = new FourFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public int getLayoutId() {
        return R.layout.four_fragment;
    }


    @Override
    public void onRealResume() {
        super.onRealResume();
    }

    @Override
    public void onRealPause() {
        super.onRealPause();

    }
}
