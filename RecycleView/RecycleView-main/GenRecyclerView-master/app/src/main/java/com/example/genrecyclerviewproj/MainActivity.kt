package com.example.genrecyclerviewproj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myrv = findViewById<RecyclerView>(R.id.myrecyclerview)

        myrv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        var myDatalist = ArrayList<UsersData>()

        myDatalist.add(UsersData("pallavi","pallavi@gamil.com","9087654321"))
        myDatalist.add(UsersData("sirisha","sirisha@gamil.com","9807890675"))
        myDatalist.add(UsersData("vishal","vishal@gamil.com","7895647832"))
        myDatalist.add(UsersData("harshit","harshit@gamil.com","987000765"))
        myDatalist.add(UsersData("supriya","supriya@gamil.com","8907654321"))

            myrv.adapter = MyAdapter(myDatalist)

    }
}
