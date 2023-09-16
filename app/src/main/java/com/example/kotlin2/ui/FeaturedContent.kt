package com.example.kotlin2.ui

import com.example.kotlin2.R

class FeaturedContent() {
    var contentDesc = ""
    var contentAction = "Start"
    var contentImage = R.drawable.cart

    constructor(contentDesc:String, contentAction:String, contentImage:Int) : this() {
        this.contentDesc = contentDesc
        this.contentAction = contentAction
        this.contentImage = contentImage
    }

    constructor(contentDesc:String, contentAction:String) : this(){
        this.contentDesc = contentDesc
        this.contentAction = contentAction
    }

    constructor(contentDesc:String) : this(){
        this.contentDesc = contentDesc
    }
}