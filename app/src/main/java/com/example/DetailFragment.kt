package com.example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.foodlist.databinding.FragmentDetailBinding
import kotlin.properties.Delegates


class DetailFragment : Fragment() {

  private var _binding: FragmentDetailBinding? = null
  private val binding get() = _binding!!
  private lateinit var food: String
  private var image by Delegates.notNull<Int>()

  companion object {
    const val Food = "food"
    const val ImageView = "image"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    arguments.let {
      food = it?.getString(Food).toString()
      if (it != null) {
        image = it.getInt(ImageView)
      }

    }
  }
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentDetailBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.detailedActivityTv.text = food
    binding.detailedActivityIv.setImageResource(image)


  }
  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}