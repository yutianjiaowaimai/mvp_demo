package mvp.amvpdemo.model;

import java.util.Map;

import mvp.amvpdemo.base.OnResultBackListener;
import mvp.amvpdemo.contract.MainContract;

/**
 * Created by haichao on 2018/5/1.
 */

public class MainModel implements MainContract.Model{

    @Override
    public void loadList(Map params,OnResultBackListener listener) {
        //TODO 网络请求回调
        listener.onSuccess();
    }

    @Override
    public void loadMoreList(Map params, OnResultBackListener listener) {
        //TODO 网络请求回调
        listener.onFail();
    }
}
