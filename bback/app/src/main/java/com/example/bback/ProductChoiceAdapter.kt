package com.example.bback

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bback.databinding.RvChoiceItemBinding
import java.text.DecimalFormat

class ProductChoiceAdapter(
	private val choicePlusListener: (Product) -> Unit,
	private val choiceMinusListener: (Product) -> Unit,
	private val choiceDeleteListener: (Product) -> Unit,
) : ListAdapter<Product, ProductChoiceAdapter.ViewHolder>(diffUtil) {

	private val choiceProducts = ArrayList<Product>()

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		return ViewHolder(
			RvChoiceItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.bind(currentList[position])
	}

	inner class ViewHolder(
		val binding: RvChoiceItemBinding
	) : RecyclerView.ViewHolder(binding.root) {
		fun bind(product: Product) {
			binding.apply {
				tvTitle.text = product.title
				val fmPrice = DecimalFormat("#,###원")
				tvPrice.text = fmPrice.format(product.price)
				etCount.setText(product.count.toString())
				option.text = "옵션:${product.option}"
				Glide.with(drinkimage.context)
					.load(product.image)
					.into(drinkimage)
				ibPlus.setOnClickListener {
					choicePlusListener(product)
				}
				ibMinus.setOnClickListener {
					choiceMinusListener(product)
				}
				ivDelete.setOnClickListener {
					choiceDeleteListener(product)
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