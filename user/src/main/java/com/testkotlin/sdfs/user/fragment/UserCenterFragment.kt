package com.testkotlin.sdfs.user.fragment

import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.testkotlin.sdfs.common.fragment.BaseFragment
import com.testkotlin.sdfs.user.R

@Route(path = "/user/UserCenterFragment")
class UserCenterFragment : BaseFragment() {
    override fun initView(view: View, savedInstanceState: Bundle?) {
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_user_center
    }

}
