package com.example.dramkos.ui.user.bookmark.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dramkos.R
import com.example.dramkos.core.data.source.model.Kos
import com.example.dramkos.databinding.ItemHomeProdukKosBinding

class BookmarkKosAdapter : RecyclerView.Adapter<BookmarkKosAdapter.ViewHolder>() {

    private var data = ArrayList<Kos>()

    inner class ViewHolder(private val itemBinding: ItemHomeProdukKosBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: Kos, position: Int) {
            itemBinding.apply {
                namaKos.text = item.namaKos
                alamatKos.text = item.alamat
                ratingKos.text = "" + item.rating
                bookmarkKos.setImageResource(R.drawable.ic_baseline_bookmark_border_24)
            }
        }
    }

    fun addItems(items: List<Kos>) {
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemHomeProdukKosBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position], position)
    }

    override fun getItemCount(): Int {
        return data.size
    }

}