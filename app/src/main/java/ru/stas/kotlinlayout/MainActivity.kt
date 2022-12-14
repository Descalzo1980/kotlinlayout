package ru.stas.kotlinlayout

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureLayout()
    }

    private fun convertToPx(value: Int): Int {
        val r = resources
        val px = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, value.toFloat(),
            r.displayMetrics).toInt()
        return px
    }

    private fun configureLayout() {
        val myButton = Button(this)
        val myLayout = ConstraintLayout(this)
        val myEditText = EditText(this)
        myEditText.id = R.id.myEditText
        myEditText.width = convertToPx(200)
        myButton.text = getString(R.string.press_me)
        myButton.background = getDrawable(R.color.red)
        myLayout.setBackgroundColor(Color.BLUE)
        myButton.id = R.id.myButton
        myLayout.addView(myButton)
        myLayout.addView(myEditText)
        setContentView(myLayout)
        val set = ConstraintSet()
        set.constrainHeight(myButton.id,
            ConstraintSet.WRAP_CONTENT)
        set.constrainWidth(myButton.id,
            ConstraintSet.WRAP_CONTENT)
        set.connect(myButton.id, ConstraintSet.START,
            ConstraintSet.PARENT_ID, ConstraintSet.START, 0)
        set.connect(myButton.id, ConstraintSet.END,
            ConstraintSet.PARENT_ID, ConstraintSet.END, 0)
        set.connect(myButton.id, ConstraintSet.TOP,
            ConstraintSet.PARENT_ID, ConstraintSet.TOP, 0)
        set.connect(myButton.id, ConstraintSet.BOTTOM,
            ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0)
        set.constrainHeight(myEditText.id,
            ConstraintSet.WRAP_CONTENT)
        set.constrainWidth(myEditText.id,
            ConstraintSet.WRAP_CONTENT)
        set.connect(myEditText.id, ConstraintSet.LEFT,
            ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 0)
        set.connect(myEditText.id, ConstraintSet.RIGHT,
            ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0)
        set.connect(myEditText.id, ConstraintSet.BOTTOM,
            myButton.id, ConstraintSet.TOP, 70)
        set.applyTo(myLayout)
    }
}