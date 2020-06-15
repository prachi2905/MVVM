package com.data.assignment.UI.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.data.assignment.BR
import com.data.assignment.Model.UserData
import com.data.assignment.R
import kotlinx.android.synthetic.main.user_data_ui.view.*

class UserDataAdapter(
    val mContext: Context, val dataList: List<UserData>

) : RecyclerView.Adapter<UserDataAdapter.UserDataViewHolder>() {
    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        i: Int
    ): UserDataViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            inflater,
            R.layout.user_data_ui,
            viewGroup,
            false
        )
        return UserDataViewHolder(binding)
    }

    override fun onBindViewHolder(
        @NonNull holder: UserDataAdapter.UserDataViewHolder, i: Int
    ) {
        holder.binding.root.appName.setText(dataList.get(i).title)
        holder.binding.root.idName.setText(dataList.get(i).id.toString())
        holder.binding.root.title.setText(dataList.get(i).body)

    }

    override fun getItemCount() = dataList.size
    class UserDataViewHolder(var binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: String?) {
            binding.setVariable(BR.recyclerModel, data)

        }
    }
}