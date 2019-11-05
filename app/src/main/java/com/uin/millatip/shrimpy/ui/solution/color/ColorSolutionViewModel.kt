package com.uin.millatip.shrimpy.ui.solution.color

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.uin.millatip.shrimpy.models.Problem

class ColorSolutionViewModel : ViewModel() {

    var water: MutableLiveData<List<Problem>> = MutableLiveData()
    var waterr: MutableList<Problem> = mutableListOf()

    fun getItems(): LiveData<List<Problem>> {
        if (water.value == null) {
            FirebaseDatabase.getInstance()
                .getReference("warna_air")
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onCancelled(p0: DatabaseError) {
                        Log.w(TAG, "loadPost:onCancelled", p0.toException())
                    }

                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        for (postSnapshot in dataSnapshot.children) {
                            val item = postSnapshot.getValue(Problem::class.java)
                            if (item != null) {
                                waterr.add(item)
                            }
                        }
                        water.postValue(waterr)
                        Log.i("data", waterr.toString())
                    }

                })
        }
        return water
    }


}
