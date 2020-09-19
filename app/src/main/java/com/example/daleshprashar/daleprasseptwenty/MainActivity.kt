package com.example.daleshprashar.daleprasseptwenty

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ListView

import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.graphics.Movie
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.Observable
import io.reactivex.Observer


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CustomAdapter
    private lateinit var  photoList:ArrayList<RetroPhoto>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById<View>(R.id.list) as androidx.recyclerview.widget.RecyclerView
        photoList = ArrayList<RetroPhoto>()
        adapter = CustomAdapter(this, photoList)
        serverCall()
        recyclerView.setAdapter(adapter)
   //     setSupportActionBar(toolbar)
/*
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        */
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun serverCall() {
        /*Create handle for the RetrofitInstance interface*/
        val service = RetrofitClientInstance().getRetrofitInstance().create(DataService::class.java!!)
      //  val call = service.getAllPhotos()
      //  val secondCallString = service.getDummy()
        val postBodyString = service.postBodyString("requestedData")
     //   val passANameParameter = service.getCommitsByName("stringPassed")
        postBodyString.enqueue(object :Callback<Object>
        {
            override fun onFailure(call: Call<Object>?, t: Throwable?) {
                t.toString()
            }

            override fun onResponse(call: Call<Object>?, response: Response<Object>?) {
                response?.body()
            }

        })

        val retroCallObj = service.getCallRxJava()
        retroCallObj.enqueue(object : Observable<RetroPhoto>()
        {
            override fun subscribeActual(observer: Observer<in RetroPhoto>?) {
                TODO("Not yet implemented")
            }

        })

        /*
        call.enqueue(object : Callback<List<RetroPhoto>> {
            override fun onFailure(call: Call<List<RetroPhoto>>?, t: Throwable?) {
            t.toString()
            }

            override fun onResponse(call: Call<List<RetroPhoto>>?, response: Response<List<RetroPhoto>>?) {
                response?.body()
              //  Log.("a",response.body.toString())
            }
        })
        */
    }

}









