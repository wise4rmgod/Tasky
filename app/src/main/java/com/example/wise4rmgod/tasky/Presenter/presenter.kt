package com.example.wise4rmgod.tasky.Presenter

import com.example.wise4rmgod.tasky.MainMvp

class presenter(private val view: MainMvp.view) : MainMvp.presenter {
    override fun closemenuclick() {
        view.closemenushow()
    }

    override fun savebtnclicked() {
        view.showsavebtn()
    }

    override fun sidemenuclick() {
       view.sidemenushow()

    }

}