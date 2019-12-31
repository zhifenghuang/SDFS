package com.testkotlin.sdfs.user.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
import com.testkotlin.sdfs.common.activity.BaseActivity
import com.testkotlin.sdfs.user.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity(){

    private var mRegisterType:Int = 0//0表示手机号注册，1表示邮箱注册

    override fun getLayoutId(): Int {
        return R.layout.activity_register
    }

    override fun onCreated(savedInstanceState: Bundle?) {
        setViewsOnClickListener(
            tvSwitchMethod,
            tvRegister,
            inputViewCountry,
            tvAgreement
        )
    }

    override fun onClick(v: View?) {

        when(v){
            tvSwitchMethod->{
                mRegisterType = if (mRegisterType == 0) 1 else 0
                resetView()
            }
            tvRegister->{
                ARouter.getInstance().build("/app/MainActivity").navigation()
            }
            inputViewCountry->{

            }
            tvAgreement->{

            }
        }
    }

    private fun resetView() {
        if (mRegisterType == 0) {
            setText(tvSwitchMethod, R.string.user_switch_email_register)
            setText(tvRegisterMethod, R.string.user_phone_register)
            setViewGone(inputViewEmail)
            setViewVisible(inputViewCountry, line1, inputViewPhone)
        } else {
            setText(tvSwitchMethod, R.string.user_switch_phone_register)
            setText(tvRegisterMethod, R.string.user_email_register)
            setViewVisible(inputViewEmail)
            setViewGone(inputViewCountry, line1, inputViewPhone)
        }
    }

}