package com.testkotlin.sdfs.user.activity

import android.os.Bundle
import android.view.View
import com.testkotlin.sdfs.common.activity.BaseActivity
import com.testkotlin.sdfs.user.R
import kotlinx.android.synthetic.main.activity_set_language.*

class LanguageActivity : BaseActivity() {

    var mLanguage: Int = 0

    override fun getLayoutId(): Int {
        return R.layout.activity_set_language
    }

    override fun onCreated(savedInstanceState: Bundle?) {
        setViewsOnClickListener(
            llSimpleChinese,
            llEnglish,
            llJapanese,
            llKorean
        )
    }

    override fun onClick(v: View?) {
        when (v) {
            llSimpleChinese,
            llEnglish,
            llJapanese,
            llKorean -> {
                mLanguage = Integer.parseInt(v?.tag as String)
                for (i in 0..3) {
                    (findViewById(resources.getIdentifier("ivCheck_$i", "id", packageName)) as View)
                        .setVisibility(if (mLanguage == i) View.VISIBLE else View.GONE)
                }
            }
        }
    }
}