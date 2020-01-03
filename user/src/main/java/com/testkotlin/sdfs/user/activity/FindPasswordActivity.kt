package com.testkotlin.sdfs.user.activity

import android.os.Bundle
import android.view.View
import com.testkotlin.sdfs.common.activity.BaseActivity
import com.testkotlin.sdfs.user.R
import com.testkotlin.sdfs.user.contract.FindPasswordContract
import com.testkotlin.sdfs.user.presenter.FindPasswordPresenter
import kotlinx.android.synthetic.main.activity_find_password.*

class FindPasswordActivity : BaseActivity<FindPasswordPresenter>(),FindPasswordContract.View {
    override fun getPresenter(): FindPasswordPresenter {
        return FindPasswordPresenter(this)
    }

    var mFindPasMethod = 0  //0表示通过手机号，1表示通过邮箱

    override fun getLayoutId(): Int {
        return R.layout.activity_find_password
    }

    override fun onCreated(savedInstanceState: Bundle?) {
        setViewsOnClickListener(tvSwitchMethod, tvNextStep)
    }

    override fun onClick(v: View?) {
        when (v) {
            tvSwitchMethod -> {
                mFindPasMethod = if (mFindPasMethod == 0) 1 else 0
                resetView()
            }
            tvNextStep -> {
                goPager(VerifyCodeActivity::class.java)
            }
        }
    }

    fun resetView() {
        when (mFindPasMethod) {
            0 -> {
                tvSwitchMethod.setText(R.string.user_switch_email_find)
                setViewGone(etInputEmail)
                setViewVisible(tvCountry, line0, etInputPhone)
                tvTips.setText(R.string.user_input_correct_phone)
            }
            1 -> {
                tvSwitchMethod.setText(R.string.user_switch_phone_find)
                setViewVisible(etInputEmail)
                setViewGone(tvCountry, line0, etInputPhone)
                tvTips.setText(R.string.user_input_correct_email)
            }
        }
    }
}