package com.example.dramkos.ui.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dramkos.core.data.source.model.Kos
import com.example.dramkos.databinding.ItemHomeProdukKosBinding
import com.inyongtisto.myhelper.extension.toVisible

class ProductKosAdapter : RecyclerView.Adapter<ProductKosAdapter.ViewHolder>() {

    private var data = ArrayList<Kos>()

    inner class ViewHolder(private val itemBinding: ItemHomeProdukKosBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: Kos, position: Int) {
            itemBinding.apply {
                namaKos.text = item.name + " - " + item.jarak + "km"
                alamatKos.text = item.alamat
                imageKos.setImageResource(item.image)
                ratingKos.text = "" + item.rating
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