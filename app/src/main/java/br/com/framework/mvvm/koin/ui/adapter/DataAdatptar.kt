package br.com.framework.mvvm.koin.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.framework.mvvm.koin.R
import br.com.framework.mvvm.koin.data.model.DataModel

class DataAdatptar(private val dataList: List<DataModel>, private val listener: OnItemClickListener):
    RecyclerView.Adapter<DataAdatptar.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.data_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.numberText.text = dataList[position].userName
        holder.messageText.text = dataList[position].userDesignation
    }

    override fun getItemCount(): Int = dataList.size

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val numberText = itemView.findViewById(R.id.nameID) as TextView
        val messageText = itemView.findViewById(R.id.designationTextID) as TextView
        val imageView = itemView.findViewById(R.id.imageViewID) as ImageView

        init {
            imageView.setOnClickListener {
                listener.itemClick(it, adapterPosition)
            }
        }

    }
    interface OnItemClickListener {
        fun itemClick(view: View, position: Int)
    }
}