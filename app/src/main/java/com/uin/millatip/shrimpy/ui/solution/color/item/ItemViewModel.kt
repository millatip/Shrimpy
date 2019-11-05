package com.uin.millatip.shrimpy.ui.solution.color.item

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uin.millatip.shrimpy.models.Problem

class ItemViewModel : ViewModel() {
    private var expandedVisibility = MutableLiveData<Int>()
    private val title = MutableLiveData<String>()
    private val url = MutableLiveData<String>()
    private val note = MutableLiveData<String>()

    fun bind(problem: Problem) {
        title.value = problem.title
        url.value = problem.url
        note.value = problem.note
        expandedVisibility.value = View.GONE
    }

    fun getTitle(): MutableLiveData<String> {
        return title
    }

    fun getImage(): MutableLiveData<String> {
        return url
    }

    fun getNote(): MutableLiveData<String> {
        return note
    }

    fun getExpandedVisibility(): MutableLiveData<Int> {
        return expandedVisibility
    }

    fun onExpand() {
        if (expandedVisibility.value == View.VISIBLE) expandedVisibility.value = View.GONE
        else expandedVisibility.value = View.VISIBLE
    }


}
