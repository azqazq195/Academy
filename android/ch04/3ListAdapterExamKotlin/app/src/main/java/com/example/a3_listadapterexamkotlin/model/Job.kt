package com.example.a3_listadapterexamkotlin.model

class Job {
    var title: String? = null
    var description: String? = null
    var image = 0

    constructor() {}
    constructor(title: String?, description: String?, image: Int) {
        this.title = title
        this.description = description
        this.image = image
    }

}