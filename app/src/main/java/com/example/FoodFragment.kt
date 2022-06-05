package com.example


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.adapter.FoodAdapter
import com.example.foodlist.R
import com.example.foodlist.databinding.FragmentFoodBinding

class FoodFragment : Fragment(R.layout.fragment_food) {
private var _binding: FragmentFoodBinding? = null  //change val to var here
    private lateinit var foodList: ArrayList<Food>
    private lateinit var foodAdapter: FoodAdapter
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private var isGridLayoutManager = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFoodBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recycler
        chooseLayout()

        foodList = ArrayList()

        foodList.add(Food(R.drawable.fried_rice,"fried rice", "$10", "Fried rice is a dish of cooked rice that has been stir-fried in a wok or a frying pan and is usually mixed with other ingredients such as eggs, vegetables, seafood, or meat. It is often eaten by itself or as an accompaniment to another dish." ))
        foodList.add(Food(R.drawable.amala,"amala", "$19", "It is made out of yam and/or cassava flour, or unripe plantain flour. Yams are peeled, sliced, cleaned, dried and then blended into flour, also called èlùbọ́. Yams are white in colour but turn brown when dried. This gives àmàlà its colour." ))
        foodList.add(Food(R.drawable.yam_and_egg,"yam and egg", "$9", "Egg sauce recipe is a dish cook with tomato, egg, pepper, onion, vegetable oil, and seasoning cube. It's typically one of Nigerian staple food that is perfect for breakfast, lunch or dinner." ))
        foodList.add(Food(R.drawable.rice_and_stew,"rice and stew", "$10", "Rice and Stew' is one of the most popular dishes in Nigeria. It is as simple as rice and stew but garnishing makes this dish more interesting" ))
        foodList.add(Food(R.drawable.apple_juice,"Apple juice", "$4", "Apple juice is a fruit juice made by the maceration and pressing of an apple. The resulting expelled juice may be further treated by enzymatic and centrifugal clarification to remove the starch and pectin, which holds fine particulate in suspension, and then pasteurized for packaging in glass, metal, or aseptic processing system containers, or further treated by dehydration processes to a concentrate." ))
        foodList.add(Food(R.drawable.salad,"salad", "$9", "A salad can be a composed salad (with the ingredients specifically arranged on the serving dish) or a tossed salad (with the ingredients placed in a bowl and mixed, often with salad dressing)." ))
        foodList.add(Food(R.drawable.potato_soup,"potato soup", "$29", "Potato soup is a good source of soluble and insoluble fiber. Dietary fiber contained in potato is able to help preventing constipation, reduce the absorption of dietary cholesterol and lowers LDL bad cholesterol. In addition, fiber will help to protect against intestinal polyps and cancer. Loaded with Alpha-lipoic Acid" ))
        foodList.add(Food(R.drawable.pizza,"pizza", "$10", "Pizza (Italian: [ˈpittsa], Neapolitan: [ˈpittsə]) is a dish of Italian origin consisting of a usually round, flat base of leavened wheat-based dough topped with tomatoes, cheese, and often various other ingredients (such as anchovies, mushrooms, onions, olives, vegetables, meat, ham, etc.), which is then baked at a high temperature, traditionally in a wood-fired oven." ))
        foodList.add(Food(R.drawable.coffe, "coffee", "$6", "Coffee is a brewed drink prepared from roasted coffee beans, the seeds of berries from certain flowering plants in the Coffee genus."))
        foodList.add(Food(R.drawable.spaghetti, "spaghetti", "$20", "Spaghetti (Italian: [spaˈɡetti]) is a long, thin, solid, cylindrical noodle pasta. It is a staple food of traditional Italian cuisine.Like other pasta, spaghetti is made of milled wheat and water and sometimes enriched with vitamins and minerals. Italian spaghetti is typically made from durum wheat semolina."))

        //binding adapter to the recyclerview
        foodAdapter = FoodAdapter(foodList)
        recyclerView.adapter = foodAdapter
     foodAdapter.onItemClick = {
         val intent = Intent(this.requireContext(), DetailFragment::class.java)
         intent.putExtra("food", "food")
         //activity?.supportFragmentManager

        //activity?.startActivity(intent)
       // startActivity(intent)





      }


        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.layout_menu, menu)
        val layoutButton = menu.findItem(R.id.action_switch)
        setIcon(layoutButton)

    }
    private fun chooseLayout() {
        if (isGridLayoutManager) {
            recyclerView.layoutManager = GridLayoutManager(requireContext(),2)
        }else{
            recyclerView.layoutManager = StaggeredGridLayoutManager(3, 1)

        }


    }
    // setIcon
    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null) return

        menuItem.icon =
            if (isGridLayoutManager)
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_view_grid)
            else {
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_view_staggered)

            }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_switch -> {
                isGridLayoutManager = !isGridLayoutManager

                chooseLayout()
                setIcon(item)

                return true
            }

            else ->super.onOptionsItemSelected(item)
        }


    }
}