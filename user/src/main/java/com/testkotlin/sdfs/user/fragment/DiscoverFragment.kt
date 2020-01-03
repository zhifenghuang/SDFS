package com.testkotlin.sdfs.user.fragment

import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.testkotlin.sdfs.common.fragment.BaseFragment
import com.testkotlin.sdfs.user.R
import com.testkotlin.sdfs.user.contract.DiscoverContract
import com.testkotlin.sdfs.user.presenter.DiscoverPresenter

@Route(path = "/user/DiscoverFragment")
class DiscoverFragment : BaseFragment<DiscoverPresenter>(), DiscoverContract.View {
    override fun getPresenter(): DiscoverPresenter {
        return DiscoverPresenter(this)
    }

    override fun onClick(v: View?) {

    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_discover
    }

}
