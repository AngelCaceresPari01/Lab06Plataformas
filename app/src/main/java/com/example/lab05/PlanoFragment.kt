package com.example.lab05

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

class PlanoFragment : Fragment() {

    private val viewModel: PlanoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val planoView = PlanoView(requireContext())
        planoView.onAmbienteClick = { ambiente ->
            viewModel.mostrarInfoAmbiente(ambiente, requireContext())
        }
        return planoView
    }
}
