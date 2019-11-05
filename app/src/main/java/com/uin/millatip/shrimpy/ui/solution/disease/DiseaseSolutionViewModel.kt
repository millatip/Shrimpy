package com.uin.millatip.shrimpy.ui.solution.disease

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.uin.millatip.shrimpy.models.Problem

class DiseaseSolutionViewModel : ViewModel() {
    var data: MutableLiveData<List<Problem>> = MutableLiveData()
    var list: MutableList<Problem> = mutableListOf()

    fun getItems(): LiveData<List<Problem>> {
        if (data.value == null) {
            FirebaseDatabase.getInstance()
                .getReference("shrimp_disease")
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onCancelled(p0: DatabaseError) {
                        Log.w(ContentValues.TAG, "loadPost:onCancelled", p0.toException())
                    }

                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        for (postSnapshot in dataSnapshot.children) {
                            val item = postSnapshot.getValue(Problem::class.java)
                            if (item != null) {
                                list.add(item)
                            }
                        }
                        data.postValue(list)
                        Log.i("data", list.toString())
                    }

                })
        }
        return data
    }
}
