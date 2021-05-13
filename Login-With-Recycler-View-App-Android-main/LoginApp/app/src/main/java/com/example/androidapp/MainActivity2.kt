package com.example.androidapp
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main_recycler.*

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_recycler)

        var myrv = findViewById<RecyclerView>(R.id.myrecyclerview)

        myrv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        var myDatalist = ArrayList<UsersData>()

        myDatalist.add(UsersData("Hari","a@gamil.com","945484444"))
        myDatalist.add(UsersData("shreyansh","shreyansh@gamil.com","345345345"))
        myDatalist.add(UsersData("rahul","rahul@gamil.com","9454834543"))
        myDatalist.add(UsersData("vijay","vijay@gamil.com","777644545"))

        myrv.adapter = MyAdapter(myDatalist)
        logout_btn.setOnClickListener {
            var intentHere = Intent(this, MainActivity::class.java)
            startActivity(intentHere)
        }

    }
}





