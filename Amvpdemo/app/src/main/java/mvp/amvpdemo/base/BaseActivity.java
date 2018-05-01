package mvp.amvpdemo.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import butterknife.ButterKnife;
import mvp.amvpdemo.R;
import mvp.amvpdemo.app.AppManager;
import mvp.amvpdemo.util.TUtil;
import mvp.amvpdemo.widget.StatusBarCompat;

/**
 * Created by haichao on 2018/5/1.
 */

public  abstract class BaseActivity<P extends BasePresenter,M extends BaseModel> extends AppCompatActivity {

    public P mPresenter;
    public M mModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        initTheme();
        setContentView( getLayoutId() );
        ButterKnife.bind(this);
        mPresenter = TUtil.getT( this,0 );
        mModel = TUtil.getT( this,1 );
        if(mPresenter != null){
            mPresenter.mContext = this;
        }
        this.initPresenter();
        this.initView();
    }

    private void initTheme() {
        // 把actvity放到application栈中管理
        AppManager.getAppManager().addActivity(this);
        // 无标题
        requestWindowFeature( Window.FEATURE_NO_TITLE);
        // 默认着色状态栏
        SetStatusBarColor();
    }

    protected abstract void initView();

    protected abstract void initPresenter();

    public abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 沉浸状态栏（4.4以上系统有效）
     */
    protected void SetTranslanteBar(){
        StatusBarCompat.translucentStatusBar(this);
    }

    /**
     * 着色状态栏（4.4以上系统有效）
     */
    protected void SetStatusBarColor(){
        StatusBarCompat.setStatusBarColor(this, ContextCompat.getColor(this, R.color.colorAccent));
    }
}
