package com.testkotlin.sdfs.user.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.alibaba.android.arouter.launcher.ARouter
import com.testkotlin.sdfs.common.activity.BaseActivity
import com.testkotlin.sdfs.user.R
import com.testkotlin.sdfs.user.contract.LoginContract
import com.testkotlin.sdfs.user.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity<LoginPresenter>(), LoginContract.View {


    override fun getPresenter(): LoginPresenter {
        return LoginPresenter(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    var mLoginType: Int = 0

    override fun onCreated(savedInstanceState: Bundle?) {
        setViewsOnClickListener(
            tvLanguage,
            inputViewCountry,
            tvPhone,
            tvEmail,
            tvForgetPassword,
            tvNextStep,
            tvRegister
        )
    }

    override fun onClick(v: View?) {
        when (v) {
            inputViewCountry -> {
                goPager(SelectCountryActivity::class.java)
            }
            tvLanguage -> {
                goPager(LanguageActivity::class.java)
            }
            tvRegister -> {
                goPager(RegisterActivity::class.java)
            }
            tvForgetPassword -> {
                goPager(FindPasswordActivity::class.java)
            }
            tvNextStep -> {
                getPresenter().login("55555", "123456")
            }
            tvPhone -> {
                if (mLoginType == 0) {
                    return
                }
                mLoginType = 0
                resetView()
            }
            tvEmail -> {
                if (mLoginType == 1) {
                    return
                }
                mLoginType = 1
                resetView()
            }
        }
    }

    fun resetView() {
        if (mLoginType == 0) {
            tvPhone.setBackgroundResource(R.drawable.user_login_tab_selected_left)
            setTextColor(tvPhone, R.color.color_151723)
            setTextColor(tvEmail, R.color.color_979797)
            tvEmail.setBackgroundResource(R.drawable.user_login_tab_unselected_right)
            setViewVisible(inputViewCountry, line0, inputViewPhone)
            setViewGone(inputViewEmail)
        } else {
            tvPhone.setBackgroundResource(R.drawable.user_login_tab_unselected_left)
            tvEmail.setBackgroundResource(R.drawable.user_login_tab_selected_right)
            setTextColor(tvEmail, R.color.color_151723)
            setTextColor(tvPhone, R.color.color_979797)
            setViewGone(inputViewCountry, line0, inputViewPhone)
            setViewVisible(inputViewEmail)
        }
    }

    override fun loginSuccess() {
        Toast.makeText(this, getString(R.string.user_login_success), Toast.LENGTH_SHORT).show()
        ARouter.getInstance().build("/app/MainActivity").navigation()
    }

    override fun loginFailed() {
    }

}