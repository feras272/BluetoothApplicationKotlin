package com.ferasdev.bluetoothapplication.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ferasdev.bluetoothapplication.R
import com.ferasdev.bluetoothapplication.databinding.FragmentMeasurementBinding
import com.ferasdev.bluetoothapplication.ui.adapters.UserAdapter
import com.ferasdev.bluetoothapplication.viewmodel.MainViewModel
import com.ferasdev.bluetoothapplication.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MeasurementFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
@WithFragmentBindings
class MeasurementFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    fun observeUsers() {
        viewModel.allUsers.observe(viewLifecycleOwner) {
            binding.rvUsersFragmentMeasurement.layoutManager = LinearLayoutManager(requireContext())
            binding.rvUsersFragmentMeasurement.adapter = UserAdapter(it)
        }
    }

    fun getNormalWeightUsers() {
        userViewModel.allUsers.observe(viewLifecycleOwner) {
            binding.rvUsersFragmentMeasurement.layoutManager = LinearLayoutManager(requireContext())
            binding.rvUsersFragmentMeasurement.adapter = UserAdapter(it)
        }
    }

    private lateinit var binding: FragmentMeasurementBinding

    //private lateinit var viewModel: MainViewModel
    private val viewModel: MainViewModel by viewModels()
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMeasurementBinding.inflate(inflater, container, false)

        //viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        return binding.root
        //return inflater.inflate(R.layout.fragment_measurement, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAdultUsersFragmentMeasurement.setOnClickListener {
            observeUsers()
        }

        binding.btnNormalWeightFragmentMeasurement.setOnClickListener {
            getNormalWeightUsers()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MeasurementFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MeasurementFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}