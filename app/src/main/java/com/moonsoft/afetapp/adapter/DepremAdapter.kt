package com.moonsoft.afetapp.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moonsoft.afetapp.R
import com.moonsoft.afetapp.model.depremListRespose
import kotlinx.android.synthetic.main.item_deprem_list.view.*

class DepremAdapter : RecyclerView.Adapter<DepremAdapter.DepremViewHolder>() {
    val depremList: ArrayList<depremListRespose.Result> = arrayListOf()
    var depremItemClickListener: (Double, Double) -> Unit = {_,_->}
    class DepremViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DepremViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_deprem_list, parent, false)
        return DepremViewHolder(view)
    }

    override fun onBindViewHolder(holder: DepremViewHolder, position: Int) {
        holder.itemView.deprem_lokasyon.text = depremList[position].lokasyon
        holder.itemView.deprem_mag.text = depremList[position].mag.toString()
        holder.itemView.deprem_lat.text = "Enlem: " + depremList[position].lat.toString()
        holder.itemView.deprem_lng.text = "Boylam: " + depremList[position].lng.toString()
        holder.itemView.deprem_time.text = depremList[position].date
        holder.itemView.setOnClickListener {
            depremItemClickListener(depremList[position].lat, depremList[position].lng)
        }
    }

    override fun getItemCount(): Int = depremList.size
    fun depremUpdate(newDepremList: List<depremListRespose.Result>) {
        depremList.clear()
        depremList.addAll(newDepremList)
        notifyDataSetChanged()
    }
    companion object{
        const val DEPREM_ID = "deprem_id"
        const val MAPS_LAT = "maps_lat"
        const val MAPS_LNG = "maps_lng"
    }
}