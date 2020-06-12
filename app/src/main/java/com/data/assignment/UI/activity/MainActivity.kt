package com.data.assignment.UI.adapter.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.data.assignment.Model.UserData
import com.data.assignment.R
import com.data.assignment.UI.adapter.UserDataAdapter
import com.data.assignment.MainViewModel
import com.data.assignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: com.data.assignment.MainViewModel
    lateinit var dataList: List<UserData>;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(com.data.assignment.MainViewModel::class.java)
       // binding.mainViewModel = viewModel
        subscribeViewModelData()
    }

    fun subscribeViewModelData() {
        viewModel.getProjectList()?.observe(this, Observer<List<UserData>> {

            if (it != null) {
                setDataOnUI(it as ArrayList<UserData>)
            }

        })
    }

    fun setDataOnUI(dataList: List<UserData>) {
        val userDataAdapter = UserDataAdapter(this,dataList)
        val mLayoutManager = LinearLayoutManager(this)
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        binding.recyclerView.setLayoutManager(mLayoutManager)
        binding.recyclerView.setNestedScrollingEnabled(false)
        binding.recyclerView.setAdapter(userDataAdapter)

    }

}
