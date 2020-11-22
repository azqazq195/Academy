package com.example.a3_listadapterexamkotlin.adapter

import android.app.Activity
import android.content.Context
import android.widget.ArrayAdapter
import com.example.a3_listadapterexamkotlin.model.Job

class JobAdapter(
    context: Context,
    resource: Int,
    objects: List<*>
) :
    ArrayAdapter<Job?>(context, resource, objects) {
    var activity: Activity
    var resource: Int

    // JobAdapter adapter = new JobAdapter(this, R.layout.list_item, list);
    init {
        activity = context as Activity
        this.resource = resource
    }
}
