package com.kaanduzbastilar.kotlincountries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.kaanduzbastilar.kotlincountries.R
import com.kaanduzbastilar.kotlincountries.databinding.ItemCountryBinding
import com.kaanduzbastilar.kotlincountries.model.Country
import com.kaanduzbastilar.kotlincountries.util.downloadFromUrl
import com.kaanduzbastilar.kotlincountries.util.placeholderProgressBar
import com.kaanduzbastilar.kotlincountries.view.FeedFragmentDirections
//ben biraz değiştirdim videodaki çalışmıyordu
class CountryAdapter(val countryList: ArrayList<Country>): RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(val binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root), CountryClickListener {
        override fun onCountryClicked(v: View) {
            val uuid = binding.countryUuidText.text.toString().toInt()
            val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment(uuid)
            Navigation.findNavController(v).navigate(action)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        //val binding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val binding = DataBindingUtil.inflate<ItemCountryBinding>(LayoutInflater.from(parent.context), R.layout.item_country, parent, false)
        return CountryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.binding.country = countryList[position]
        holder.binding.listener = holder


        /*
        holder.binding.name.text = countryList[position].countryName
        holder.binding.region.text = countryList[position].countryRegion

        holder.itemView.setOnClickListener {
            val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment(countryList[position].uuid)
            Navigation.findNavController(it).navigate(action)
        }

        holder.binding.imageView.downloadFromUrl(countryList[position].imageUrl, placeholderProgressBar(holder.binding.root.context))
         */





    }

    fun updateCountryList(newCountryList: List<Country>){
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }

}