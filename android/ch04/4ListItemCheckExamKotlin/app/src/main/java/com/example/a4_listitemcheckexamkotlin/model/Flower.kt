package com.example.a4_listitemcheckexamkotlin.model

class Flower {
    private var title: String? = null
    private var description: String? = null
    private var image = 0
    private var isCheck = false

    constructor() {}
    constructor(
        title: String?,
        description: String?,
        image: Int,
        check: Boolean
    ) {
        this.title = title
        this.description = description
        this.image = image
        isCheck = check
    }



}