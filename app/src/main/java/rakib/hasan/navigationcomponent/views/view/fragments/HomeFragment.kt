package rakib.hasan.navigationcomponent.views.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import rakib.hasan.navigationcomponent.databinding.FragmentHomeBinding

class HomeFragment : Fragment(){

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        navController = findNavController()

        binding.frHomeSendMoneyBtn.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToChooseReceiverFragment()
            navController.navigate(action)
        }

        binding.frHomeViewBalanceBtn.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToViewBalanceFragment()
            navController.navigate(action)        }

        binding.frHomeViewTransactionBtn.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToViewTransactionFragment()
            navController.navigate(action)
        }

        return binding.root
    }
}