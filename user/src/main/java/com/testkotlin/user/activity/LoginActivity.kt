package com.testkotlin.user.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
import com.testkotlin.sdfs.user.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        tvRegister.setOnClickListener {
            startActivity(
                Intent(
                    LoginActivity@ this,
                    RegisterActivity::class.java
                )
            )
        }
        tvNextStep.setOnClickListener {
            Log.e("aaaaaaaa","aaaaa")
            ARouter.getInstance().build("/app/MainActivity").navigation()
        }
    }
}