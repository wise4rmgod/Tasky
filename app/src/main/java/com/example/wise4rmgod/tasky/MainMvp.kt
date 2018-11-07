package com.example.wise4rmgod.tasky

interface MainMvp {
    interface view{
        fun showsavebtn()
        fun sidemenushow()
        fun closemenushow()
    }

    interface presenter{
        fun savebtnclicked()
        fun sidemenuclick()
        fun closemenuclick()
    }
}