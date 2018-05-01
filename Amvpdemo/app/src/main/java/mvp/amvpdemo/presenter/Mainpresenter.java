package mvp.amvpdemo.presenter;

import java.util.Map;

import mvp.amvpdemo.base.OnResultBackListener;
import mvp.amvpdemo.contract.MainContract;

/**
 * Created by haichao on 2018/5/1.
 */

public class Mainpresenter extends MainContract.Presenter {


    @Override
    public void loadList(Map params) {
        mView.showLoading();
        mModel.loadList( params, new OnResultBackListener() {
            @Override
            public void onSuccess() {
                mView.hideLoading();
                mView.updateSuccessView( "成功" );
            }

            @Override
            public void onFail() {
                mView.hideLoading();
            }
        } );
    }

    @Override
    public void loadMoreList(Map params) {
        mView.showLoading();
        mModel.loadMoreList( params, new OnResultBackListener() {
            @Override
            public void onSuccess() {
                mView.hideLoading();
            }

            @Override
            public void onFail() {
                mView.hideLoading();
                mView.updateFailView( "失败" );
            }
        } );
    }
}
