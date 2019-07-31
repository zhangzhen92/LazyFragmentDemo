package example.com.lazyfragmentdemo.fragment;

import android.os.Bundle;

import example.com.lazyfragmentdemo.R;

/**
 * 类描述：
 * create by：zz
 * create on：2019-07-31 15:31
 */
public class ThirdFragment extends LazyFragment{
    public static ThirdFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ThirdFragment fragment = new ThirdFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public int getLayoutId() {
        return R.layout.third_fragment;
    }
}
