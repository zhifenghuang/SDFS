package com.testkotlin.user.fragment

import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.testkotlin.sdfs.user.R

@Route(path = "/user/DiscoverFragment")
class DiscoverFragment : BaseFragment(){
    override fun onFragmentViewCreated(view: View, savedInstanceState: Bundle?) {
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_discover
    }

}
