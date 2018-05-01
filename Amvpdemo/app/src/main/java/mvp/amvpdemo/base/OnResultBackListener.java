package mvp.amvpdemo.base;

/**
 * Created by haichao on 2018/5/1.
 */

public interface OnResultBackListener {
    //网络请求成功
    void onSuccess();
    //网络请求失败
    void onFail();
}
