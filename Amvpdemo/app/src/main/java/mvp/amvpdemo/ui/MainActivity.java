package mvp.amvpdemo.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import mvp.amvpdemo.R;
import mvp.amvpdemo.base.BaseActivity;
import mvp.amvpdemo.contract.MainContract;
import mvp.amvpdemo.model.MainModel;
import mvp.amvpdemo.presenter.Mainpresenter;

public class MainActivity extends BaseActivity<Mainpresenter, MainModel> implements MainContract.View, View.OnClickListener {

    @BindView(R.id.tv_success)
    TextView tvSuccess;
    @BindView(R.id.tv_fail)
    TextView tvFail;

    @Override
    protected void initView() {
        findViewById( R.id.tv_success ).setOnClickListener( this );
        findViewById( R.id.tv_fail ).setOnClickListener( this );
    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM( this, mModel );
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_success:
                mPresenter.loadList( new HashMap() );
                break;
            case R.id.tv_fail:
                mPresenter.loadMoreList( new HashMap() );
                break;
        }
    }

    @Override
    public void updateSuccessView(String result) {
        Toast.makeText( this, result, Toast.LENGTH_SHORT ).show();
    }

    @Override
    public void updateFailView(String erorMsg) {
        Toast.makeText( this, erorMsg, Toast.LENGTH_SHORT ).show();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        // TODO: add setContentView(...) invocation
        ButterKnife.bind( this );
    }
}
