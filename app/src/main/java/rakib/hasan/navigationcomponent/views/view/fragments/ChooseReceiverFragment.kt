package rakib.hasan.navigationcomponent.views.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import rakib.hasan.navigationcomponent.databinding.FragmentChooseReceiverBinding

class ChooseReceiverFragment : Fragment(){

    private lateinit var binding: FragmentChooseReceiverBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChooseReceiverBinding.inflate(inflater, container, false)

        navController = findNavController()


/*        *//**
         * the way of sending data with Bundle
         * *//*
        binding.frChooseReceiverNextBtn.setOnClickListener {
            var receiverName: String = binding.frChooseReceiverNameEt.text.trim().toString()
            val args = Bundle()
            args.putString("name", receiverName)

            if (receiverName.isNotEmpty()){
                navController.navigate(R.id.sendCashFragment, args)
            }else Toast.makeText(activity, "Enter a name!", Toast.LENGTH_LONG).show()

        }*/

        binding.frChooseReceiverNextBtn.setOnClickListener {
            var name = binding.frChooseReceiverNameEt.text.trim().toString()
            if(name.isEmpty()) {
                Toast.makeText(activity, "Please, enter a receiver name", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val action = ChooseReceiverFragmentDirections.actionChooseReceiverFragmentToSendCashFragment(name)
            navController.navigate(action)
        }

        binding.frChooseReceiverCancelBtn.setOnClickListener {
            navController.popBackStack()
        }
        return binding.root
    }

}

