package com.example.project_onlineshopecommerce.Data

class SliderItems {
     var url:String = ""

    var _url:String
        get() {return url}
        set(value) {url = value}

    //constructor
    constructor()
    constructor(url: String) {
        this.url = url
    }

}