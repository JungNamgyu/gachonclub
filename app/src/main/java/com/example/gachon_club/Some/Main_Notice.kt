package com.example.gachon_club.Some

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import androidx.appcompat.app.AppCompatActivity
import com.example.gachon_club.R
import kotlinx.android.synthetic.main.activity_main.Title
import kotlinx.android.synthetic.main.activity_main__notice.*
import org.jetbrains.anko.backgroundColor

class Main_Notice : AppCompatActivity() {

    val tableLayout by lazy { TableLayout(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main__notice)
        Title.text = intent.getStringExtra("Title")
        createTable(6, 1)
    }

    fun createTable(rows: Int, cols: Int){
        for(i in 0 until rows) {
            val row = TableRow(this)
            row.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            for (j in 0 until cols) {
                val button = Button(this)
                button.apply {
                    layoutParams = TableRow.LayoutParams(
                        TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT
                    )
                    text = "${Title.text} \n ${(i * cols) + j}"
                }
                row.addView(button)
                row.setHorizontalGravity(Gravity.CENTER_HORIZONTAL)
            }
            tableLayout.addView(row)
        }
        linearLayout.addView(tableLayout)
        linearLayout.backgroundColor= Color.WHITE
    }
}
