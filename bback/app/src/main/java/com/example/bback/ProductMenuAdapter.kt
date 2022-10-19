package com.example.bback

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bback.databinding.RvMenuItemBinding
import java.text.DecimalFormat

class ProductMenuAdapter(
	private val productClickedListener: (Product) -> Unit
) : ListAdapter<Product, ProductMenuAdapter.ViewHolder>(diffUtil) {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		return ViewHolder(
			RvMenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.bind(currentList[position])
	}

	inner class ViewHolder(
		val binding: RvMenuItemBinding
	) : RecyclerView.ViewHolder(binding.root) {
		fun bind(product: Product) {
			binding.apply {
				tvTitle.text = product.title
				val fmPrice = DecimalFormat("#,###원")
				tvPrice.text = fmPrice.format(product.price)
				Glide.with(ivMenu1.context)
					.load(product.image)
					.into(ivMenu1)
				root.setOnClickListener {
					productClickedListener(product)
				}
			}
		}
	}

	companion object {
		val diffUtil = object : DiffUtil.ItemCallback<Product>() {
			override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
				return oldItem == newItem
			}

			override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
				return oldItem.idx == newItem.idx
			}
		}
	}
}