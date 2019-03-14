package com.andela.learndagger.ui.main

import com.andela.learndagger.base.BaseContract

class MainContract {

    interface View: BaseContract.View {

    }

    interface Presenter: BaseContract.Presenter<MainContract.View> {

    }
}