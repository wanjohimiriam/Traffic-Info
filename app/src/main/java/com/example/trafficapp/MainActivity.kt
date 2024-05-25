package com.example.trafficapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Collections

class MainActivity : AppCompatActivity(),SwipeRefreshLayout.OnRefreshListener {

//    private lateinit var newsList: List<News>
    private lateinit var newsList: MutableList<News>
    private lateinit var progressBar: ProgressBar
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var myAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        swipeRefreshLayout = findViewById(R.id.swipeRefresh)

        newRecyclerView = findViewById(R.id.recyclerview)
        swipeRefreshLayout.setOnRefreshListener(this)
        manager = LinearLayoutManager(this)
        progressBar = findViewById(R.id.progressBar)

//        swipeRefreshLayout.setOnRefreshListener {
//            getAllData() // Call your data fetch function on refresh
//        }


        progressBar.visibility = View.VISIBLE

        // Set layout manager
        newRecyclerView.layoutManager = manager

        // Initialize adapter with an empty list
        myAdapter = MyAdapter(ArrayList())
        newsList = ArrayList()

        // Set adapter
        newRecyclerView.adapter = myAdapter

        Log.d(TAG, "onCreate")
        onRefresh()


        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(newRecyclerView)


    }
    override fun onRefresh() {

        Handler(Looper.getMainLooper()).postDelayed(
            {
                getAllData()
                swipeRefreshLayout.isRefreshing = false

            },300)
    }


    private fun getAllData() {
        progressBar.visibility = View.VISIBLE
        ApiService.service.allData().enqueue(object : Callback<List<News>> {
            override fun onResponse(call: Call<List<News>>, response: Response<List<News>>) {
                if (response.isSuccessful) {
                    response.body()?.let { news ->
                        newsList.clear()
                        newsList.addAll(news)
                        // Data is successfully received, update UI
                        myAdapter = MyAdapter(news)
                        newRecyclerView.adapter = myAdapter
                        myAdapter.notifyDataSetChanged()
                        Log.d(TAG, "Data received: $news")
                        progressBar.visibility = View.GONE
                    } ?: run {
                        // Response body is null, handle this case
                        Log.e(TAG, "Response body is null")
                        progressBar.visibility = View.GONE
                    }
                } else {
                    // Request was not successful (e.g., 404, 500, etc.), handle this case
                    Log.e(TAG, "Failed to fetch data: ${response.code()}")
                    Toast.makeText(this@MainActivity, "Not Loaded", Toast.LENGTH_SHORT).show()
                    progressBar.visibility = View.GONE
                    swipeRefreshLayout.isRefreshing = false

                }
            }

            override fun onFailure(call: Call<List<News>>, t: Throwable) {
                val errorMessage = t.message ?: "Unknown error"
                Log.e(TAG, "Failed to fetch data: $errorMessage")
                t.printStackTrace()
                progressBar.visibility = View.GONE
                swipeRefreshLayout.isRefreshing = false
            }
        })
    }

    companion object {
        private const val TAG = "MainActivity"
    }

    private val itemTouchHelperCallback: ItemTouchHelper.Callback = object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int {
            val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
            val swipeFlags = 0 // Disable swipe for now (optional)
            return makeMovementFlags(dragFlags, swipeFlags)
        }

        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {

            val fromPos = viewHolder.adapterPosition
            val toPos = target.adapterPosition
            Collections.swap(newsList, fromPos, toPos)
            myAdapter.notifyItemMoved(fromPos, toPos)
            Log.d(TAG, "OnMove Function List: $newsList")
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            // Implement swipe functionality if needed
            val position = viewHolder.adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                newsList.removeAt(position)
                myAdapter.notifyItemRemoved(position)
            }
            Log.d(TAG, "OnSwiped Function List: $newsList")
        }
    }

}