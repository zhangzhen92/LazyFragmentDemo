package example.com.lazyfragmentdemo.fragment;

import android.os.Bundle;

import example.com.lazyfragmentdemo.R;

/**
 * 类描述：
 * create on：2019-07-31 15:30
 */
public class SecondFragment extends LazyFragment{
    public static SecondFragment newInstance() {
        
        Bundle args = new Bundle();
        
        SecondFragment fragment = new SecondFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public int getLayoutId() {
        return R.layout.second_fragment;
    }
}
