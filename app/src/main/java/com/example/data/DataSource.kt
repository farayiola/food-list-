package com.example.data
import com.example.foodlist.R
import com.example.model.Declaration

class DataSource {
   fun loadDeclaration() : List<Declaration>{
       return listOf<Declaration>(
           Declaration(R.string.food1 ,R.string.food1_price, R.drawable.fried_rice),
           Declaration(R.string.food2,R.string.food2_price, R.drawable.rice_and_stew),
           Declaration(R.string.food3, R.string.food3_price, R.drawable.amala),
           Declaration(R.string.food4,R.string.food4_price, R.drawable.yam_and_egg),



       )
   }
}