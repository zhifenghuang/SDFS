package com.testkotlin.sdfs.user.activity

import android.os.Bundle
import android.view.View
import com.testkotlin.sdfs.common.activity.BaseActivity
import com.testkotlin.sdfs.user.R
import com.testkotlin.sdfs.user.contract.VerifyCodeContract
import com.testkotlin.sdfs.user.presenter.VerifyCodePresenter
import com.testkotlin.sdfs.user.view.OnInputListener
import kotlinx.android.synthetic.main.activity_verify_code.*

class VerifyCodeActivity : BaseActivity<VerifyCodePresenter>(),VerifyCodeContract.View {

    override fun getPresenter(): VerifyCodePresenter {
        return VerifyCodePresenter(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_verify_code
    }

    override fun onCreated(savedInstanceState: Bundle?) {
        verifyCodeView.setOnInputListener(object : OnInputListener {
            override fun onSucess(code: String) {
                goPager(ResetPasswordActivity::class.java)
            }

            override fun onInput() {
            }
        })
    }

    override fun onClick(v: View?) {

    }
}