package example.com.lazyfragmentdemo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 类描述：Fragment基类
 * create on：2019-07-31 15:27
 */
public abstract class LazyFragment extends Fragment {

    private boolean isViewCreate = false;
    private boolean isCurrentVis = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutId(),container,false);
        isViewCreate = true;


       if(getUserVisibleHint() && !isHidden()){
          dispatchTouser(true);
       }
        return rootView;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isViewCreate){
            if(isVisibleToUser && !isCurrentVis){
                dispatchTouser(true);
            }else if(!isVisibleToUser && isCurrentVis){
                dispatchTouser(false);
            }
        }
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

    }

    /**
     * 分发是否可见事件
     * @param isVisibleToUser
     */
    private void dispatchTouser(boolean isVisibleToUser) {
        isCurrentVis = isVisibleToUser;
        if(isVisibleToUser){
            onRealResume();
        }else if(!isVisibleToUser){
            onRealPause();
        }

    }


    /**
     * 视图真正的可见  进行数据的渲染处理
     */
    public void onRealResume(){

    }

    /**
     * 视图不可见，停止数据的加载
     */
    public void onRealPause(){

    }

    @Override
    public void onPause() {
        super.onPause();
        if( isCurrentVis && getUserVisibleHint()){
            dispatchTouser(false);
        }

    }

    /**
     * 处理进入后台恢复界面
     */
    @Override
    public void onResume() {
        super.onResume();
    if(!isHidden() && !isCurrentVis && getUserVisibleHint()){
      dispatchTouser(true);
    }
    }

    public abstract int getLayoutId();
}
