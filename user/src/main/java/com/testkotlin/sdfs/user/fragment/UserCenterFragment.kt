package com.testkotlin.sdfs.user.fragment

import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.testkotlin.sdfs.common.fragment.BaseFragment
import com.testkotlin.sdfs.user.R
import com.testkotlin.sdfs.user.contract.UserCenterContract
import com.testkotlin.sdfs.user.presenter.UserCenterPresenter
import kotlinx.android.synthetic.main.fragment_user_center.*

@Route(path = "/user/UserCenterFragment")
class UserCenterFragment : BaseFragment<UserCenterPresenter>(),UserCenterContract.View {
    override fun getPresenter(): UserCenterPresenter {
        return UserCenterPresenter(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_user_center
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        setViewsOnClickListener(
            ivMessage,
            clUserProfile,
            tvInviteCode,
            tvAddressList,
            tvHelp,
            llLanguageSet,
            llAuthenticate,
            tvLoginPassword,
            tvPayPassword,
            llPhoneBind,
            llEmailBind,
            tvUserAgreement,
            tvAbout,
            llCheckUpdate
        )
    }

    override fun onClick(v: View?) {

    }
}
