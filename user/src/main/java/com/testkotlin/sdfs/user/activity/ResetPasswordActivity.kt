package com.testkotlin.sdfs.user.activity

import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.launcher.ARouter
import com.testkotlin.sdfs.common.activity.BaseActivity
import com.testkotlin.sdfs.user.R
import com.testkotlin.sdfs.user.contract.ResetPasswordContract
import com.testkotlin.sdfs.user.presenter.ResetPasswordPresenter
import kotlinx.android.synthetic.main.activity_reset_password.*

class ResetPasswordActivity : BaseActivity<ResetPasswordPresenter>(),ResetPasswordContract.View {

    override fun getPresenter(): ResetPasswordPresenter {
        return ResetPasswordPresenter(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_reset_password
    }

    override fun onCreated(savedInstanceState: Bundle?) {
        setViewsOnClickListener(tvOk)
    }

    override fun onClick(v: View?) {
        when(v){
            tvOk->{
                ARouter.getInstance().build("/app/MainActivity").navigation()
            }
        }
    }
}