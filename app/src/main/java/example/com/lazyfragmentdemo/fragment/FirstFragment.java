package example.com.lazyfragmentdemo.fragment;

import android.os.Bundle;

import example.com.lazyfragmentdemo.R;

/**
 * 类描述：
 * create on：2019-07-31 15:30
 */
public class FirstFragment extends LazyFragment{
    public static FirstFragment newInstance() {
        
        Bundle args = new Bundle();
        
        FirstFragment fragment = new FirstFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public int getLayoutId() {
        return R.layout.first_fragment;
    }
}
