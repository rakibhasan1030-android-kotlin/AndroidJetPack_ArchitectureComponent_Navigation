package rakib.hasan.navigationcomponent.views.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import rakib.hasan.navigationcomponent.R
import rakib.hasan.navigationcomponent.databinding.FragmentSendCashBinding
import rakib.hasan.navigationcomponent.views.util.Constants

class SendCashFragment : Fragment(){

    private lateinit var binding: FragmentSendCashBinding
    private lateinit var navController: NavController
    private val args: SendCashFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSendCashBinding.inflate(inflater, container, false)
        navController = findNavController()

/*        *//**
         *
         * the way of receive data with Bundle
         *//*
        val name = arguments?.getString("name")
        binding.fragmentSendCashHeader.text = "Send cash to " + name*/
        val receiverName = args.receiverName

        binding.fragmentSendCashHeader.text = "Send cash to " + receiverName

        binding.fragmentSendCashEt.setText(Constants.defaultAmount.value.toString())
        Constants.defaultAmount.observe(viewLifecycleOwner, Observer {
            binding.fragmentSendCashEt.setText(Constants.defaultAmount.value.toString())
        })

        binding.fragmentSendCashSendBtn.setOnClickListener {
            var amount = binding.fragmentSendCashEt.text.toString()
            if(amount.isEmpty()){
                Toast.makeText(activity, "Please, enter an amount.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val action = SendCashFragmentDirections.actionSendCashFragmentToConfirmDialogFragment(receiverName, amount)
            navController.navigate(action)
        }

        binding.fragmentSendCashCancelBtn.setOnClickListener {
            //this will destroy all fragment in backStack and "inclusive = true" will destroy home fragment also, so if user press back on home, app will exit
            navController.popBackStack(R.id.homeFragment, false)
        }

        binding.fragmentSendCashDoneBtn.setOnClickListener {
            //this will destroy all fragment in backStack and "inclusive = true" will destroy home fragment also, so if user press back on home, app will exit
            navController.popBackStack(R.id.homeFragment, false)
        }

        return binding.root
    }

}