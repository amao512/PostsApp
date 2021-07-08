package com.aslnstbk.postsapp.utils

import androidx.recyclerview.widget.DiffUtil

abstract class BaseDiffUtilCallBack(
    private val oldList: List<Any?>,
    private val newList: List<Any?>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.count()

    override fun getNewListSize(): Int = newList.count()

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return getAreContentsTheSame(oldItemPosition, newItemPosition)
    }

    abstract fun getAreContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean
}