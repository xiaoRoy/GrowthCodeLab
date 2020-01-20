package com.learn.growthcodelab.view.widget

import android.text.InputFilter
import android.text.Spanned
import android.util.Log
import java.lang.NumberFormatException

class QuantityRangeInputFilter : InputFilter {
    override fun filter(source: CharSequence?, start: Int, end: Int, dest: Spanned?, dstart: Int, dend: Int): CharSequence? {
        Log.d("trail", "source:${source}")
        Log.d("trail", "dest:${dest}")
        Log.d("trail", "dstart:${dstart}")
        Log.d("trail", "dend:${dend}")
        if (source?.run { length == 1 } == true && dest != null) {
            val input: Char = source.toList().first()
            val origin: MutableList<Char> = dest.toMutableList()
            val result = try {
                origin.add(dstart, input)
               /* if(!(input == '0' && dstart == 0)) {
                    origin.add(dstart, input)
                }*/
                val quantityToCheck = origin.joinToString(separator = "").toInt()
                when {
                    quantityToCheck < 1 -> ""
                    quantityToCheck > 99 -> ""
                    (input == '0' && dstart == 0) -> ""
                    else -> null
                }
            } catch (numberFormatException: NumberFormatException) {
                ""
            }
            return result

        }
        return null
    }

}