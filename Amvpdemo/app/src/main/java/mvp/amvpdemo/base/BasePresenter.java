package mvp.amvpdemo.base;

import android.content.Context;

/**
 * Created by haichao on 2018/5/1.
 */

public class BasePresenter <V ,M >{

    public V mView;
    public M mModel;
    public Context mContext;

    public void setVM(V v,M m){
        this.mView = v;
        this.mModel = m;
    }
}
