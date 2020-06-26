
package com.example.gachon_club.Club

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gachon_club.Club.Model.Board
import com.example.gachon_club.Network.ServiceControl
import com.example.gachon_club.R
import kotlinx.android.synthetic.main.activity_edit_notice.*
import kotlinx.android.synthetic.main.activity_notice.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditNotice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_notice)

        btn_Register.setOnClickListener {
            val TITLE = edit_title.text.toString()
            val CONTENT = edit_contnent.text.toString()

            if((!TITLE.isNullOrBlank()) && (!CONTENT.isNullOrBlank())){
                val board = Board(
                    null,
                    intent.getStringExtra("club"),
                    edit_title.text.toString(),
                    edit_contnent.text.toString(),
                    intent.getStringExtra("user_name"),
                    null,
                    edit_notice_calendar.text.toString()
                )
                addData(board)
            }else {
                Toast.makeText(this, "빠짐없이 입력해주세요", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun addData(board: Board) {
        val retrofitService = ServiceControl.getInstance()
        retrofitService?.addBoard(board)?.enqueue(object: Callback<Board> {
            override fun onResponse(call: Call<Board>, response: Response<Board>) {
                if (response.isSuccessful) {
                    Toast.makeText(applicationContext, "공지사항 등록 성공", Toast.LENGTH_LONG).show()
                    val intent = Intent()
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }
            }
            override fun onFailure(call: Call<Board>, t: Throwable) {
                Toast.makeText(applicationContext, "실패", Toast.LENGTH_LONG).show()
            }
        })
    }
}