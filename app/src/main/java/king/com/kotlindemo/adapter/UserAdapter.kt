package com.wingsofts.gankclient.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import king.com.kotlindemo.bean.U
import king.com.kotlindemo.bean.User
import king.com.kotlindemo.databinding.LayoutItemBinding

/**
 * Created by wing on 11/23/16.
 */
class UserAdapter(private val mList: MutableList<U>?) : BaseBindingAdapter<LayoutItemBinding>() {
    override fun getItemCount(): Int {
        return mList!!.size
    }

    override fun onBindViewHolder(holder: DataBoundViewHolder<LayoutItemBinding>, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.binding.user = mList!![position]
        holder.binding.executePendingBindings()
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): DataBoundViewHolder<LayoutItemBinding> {
        return DataBoundViewHolder(
                LayoutItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
}