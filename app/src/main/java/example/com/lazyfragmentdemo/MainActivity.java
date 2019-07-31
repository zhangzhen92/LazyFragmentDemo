package example.com.lazyfragmentdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import example.com.lazyfragmentdemo.fragment.FirstFragment;
import example.com.lazyfragmentdemo.fragment.FourFragment;
import example.com.lazyfragmentdemo.fragment.SecondFragment;
import example.com.lazyfragmentdemo.fragment.ThirdFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;
    private List<Fragment> fragments = new ArrayList<>();
    private MyFragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar supportActionBar = getSupportActionBar();
        if(supportActionBar != null){
            supportActionBar.hide();
        }
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * 初始化View
     */
    private void initView() {
        viewPager = ((ViewPager) findViewById(R.id.viewpager_id));
        bottomNavigationView = ((BottomNavigationView) findViewById(R.id.bottom_id));
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        viewPager.addOnPageChangeListener(this);
        fragments.add(FirstFragment.newInstance());
        fragments.add(SecondFragment.newInstance());
        fragments.add(ThirdFragment.newInstance());
        fragments.add(FourFragment.newInstance());
        adapter = new MyFragmentAdapter(getSupportFragmentManager(), fragments, this);
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.menu_home:
                viewPager.setCurrentItem(0,false);
                break;
            case R.id.menu_second:
                viewPager.setCurrentItem(1,false);
                break;
            case R.id.menu_third:
                viewPager.setCurrentItem(2,false);
                break;
            case R.id.menu_person:
                viewPager.setCurrentItem(3,false);
                break;
                default:break;
        }
        return false;
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int position) {
        MenuItem item = bottomNavigationView.getMenu().getItem(position);
        item.setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
