package com.example.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Food
import com.example.foodlist.R



class FoodAdapter(private val foodlist: ArrayList<Food>) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    var onItemClick : ((Food) -> Unit)? = null

    class FoodViewHolder( view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val price: TextView = view.findViewById(R.id.item_price)
        val imageView: ImageView = view.findViewById(R.id.item_image)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent,false)

        return FoodViewHolder(view)

    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodlist[position]
        holder.textView.text = food.name
        holder.price.text = food.price
        holder.imageView.setImageResource(food.image)

        holder.itemView.setOnClickListener{

            onItemClick?.invoke(food)

        }
    }

    override fun getItemCount() = foodlist.size
}