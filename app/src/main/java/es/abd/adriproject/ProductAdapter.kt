package es.abd.adriproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter (private val context: Context?,
                      private var products: MutableList<Product>,
                      private val mListener: (Product) -> Unit) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){


    fun updateData(newData: MutableList<Product>) {
        products = newData
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.model_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bindItem(product)
        holder.itemView.setOnClickListener { mListener(product) }
    }


    class ProductViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val product_name: TextView = view.findViewById(R.id.productName)
        private val product_image: ImageView = view.findViewById(R.id.productImage)
        private val product_price:  TextView = view.findViewById(R.id.productPrice)

        fun bindItem(product: Product){
            product_name.text = product.productName
            product_image.setImageResource(product.image)
            product_price.text = product.price.toString()

        }

    }

    }