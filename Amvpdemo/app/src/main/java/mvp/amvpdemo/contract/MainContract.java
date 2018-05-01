package mvp.amvpdemo.contract;

import java.util.Map;

import mvp.amvpdemo.base.BaseModel;
import mvp.amvpdemo.base.BasePresenter;
import mvp.amvpdemo.base.BaseView;
import mvp.amvpdemo.base.OnResultBackListener;

/**
 * Created by haichao on 2018/5/1.
 */

public interface MainContract {

    interface Model extends BaseModel{

        void loadList(Map params, OnResultBackListener listener);

        void loadMoreList(Map params, OnResultBackListener listener);
    }

    interface View extends BaseView{

        void updateSuccessView(String result);

        void updateFailView(String erorMsg);
    }

    abstract static class Presenter extends BasePresenter<View,Model>{

        public abstract void loadList(Map params);

        public abstract void loadMoreList(Map params);
    }
}
