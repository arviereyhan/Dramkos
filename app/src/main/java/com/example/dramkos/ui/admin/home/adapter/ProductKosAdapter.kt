package com.example.dramkos.ui.admin.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dramkos.R
import com.example.dramkos.core.data.source.model.Kos
import com.example.dramkos.databinding.ItemHomeProdukKosBinding
import com.example.dramkos.ui.admin.detailkosadmin.DetailKosAdminActivity
import com.inyongtisto.myhelper.extension.intentActivity
import com.inyongtisto.myhelper.extension.toJson

class ProductKosAdapter : RecyclerView.Adapter<ProductKosAdapter.ViewHolder>() {

    private var data = ArrayList<Kos>()

    inner class ViewHolder(private val itemBinding: ItemHomeProdukKosBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        @SuppressLint("SetTextI18n")

        fun bind(data: Kos, position: Int) {
            itemBinding.apply {
                namaKos.text = data.namaKos
                daerahKos.text = data.alamat
                ratingKos.text = "" + data.rating
                bookmarkKos.setImageResource(R.drawable.ic_baseline_bookmark_border_24)

                val context = root.context
                detailKos.setOnClickListener{
                    context.intentActivity(
                        DetailKosAdminActivity::class.java,
                        data.toJson()
                    )
                }
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