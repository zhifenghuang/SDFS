package com.testkotlin.user.fragment

import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.testkotlin.sdfs.user.R

@Route(path = "/user/UserCenterFragment")
class UserCenterFragment : BaseFragment(){
    override fun onFragmentViewCreated(view: View, savedInstanceState: Bundle?) {
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_user_center
    }

}
