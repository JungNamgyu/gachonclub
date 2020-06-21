package com.example.gachon_club.Club

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gachon_club.Club.Adapter.BoardRecyclerAdapter
import com.example.gachon_club.Club.Adapter.RecyclerAdapter
import com.example.gachon_club.Club.Model.Board
import com.example.gachon_club.Network.ServiceControl

import com.example.gachon_club.R
import kotlinx.android.synthetic.main.activity_club.view.*
import kotlinx.android.synthetic.main.fragment_notice.*
import kotlinx.android.synthetic.main.list_notice_view.*
import org.jetbrains.anko.startActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NoticeFragment : Fragment(){



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        return inflater.inflate(R.layout.fragment_notice, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }






}