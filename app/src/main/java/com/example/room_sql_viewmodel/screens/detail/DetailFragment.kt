package com.example.room_sql_viewmodel.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.room_sql_viewmodel.APP
import com.example.room_sql_viewmodel.R
import com.example.room_sql_viewmodel.databinding.FragmentDetailBinding
import com.example.room_sql_viewmodel.model.NoteModel


class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding
    lateinit var currentNote: NoteModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        currentNote = arguments?.getSerializable("note") as NoteModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        binding.tvTitleDetail.text = currentNote.title
        binding.tvDescDetail.text = currentNote.description

        binding.btnDeleteDetail.setOnClickListener {
            viewModel.delete(currentNote){}
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
        }




        binding.btnBackDetail.setOnClickListener {
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
        }
    }
}