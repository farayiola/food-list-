package com.example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.foodlist.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

  private var _binding: FragmentDetailBinding? = null
  private val binding get() = _binding!!
  //private lateinit var food: String

  //override fun onCreate(savedInstanceState: Bundle?) {
    //super.onCreate(savedInstanceState)

    //arguments?.let {
     // food = it.getString(food).toString()

    //}
  //}
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentDetailBinding.inflate(inflater, container, false)

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    val food = activity?.intent?.getParcelableExtra<Food>("food")
    if (food != null) {
      val textView: TextView = binding.detailedActivityTv
      val imageView: ImageView = binding.detailedActivityIv
      textView.text = food.description
     imageView.setImageResource(food.image)
     // binding.detailedActivityTv.text = food.description
      //binding.detailedActivityIv.setImageResource(food.image)

    }

  }
  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}