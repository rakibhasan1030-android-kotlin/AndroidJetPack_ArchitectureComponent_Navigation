package rakib.hasan.navigationcomponent.views.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import rakib.hasan.navigationcomponent.MainNavGraphDirections
import rakib.hasan.navigationcomponent.databinding.FragmentSettingsBinding
import rakib.hasan.navigationcomponent.views.util.Constants

class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        navController = findNavController()

        binding.frSettingsAmountSaveBtn.setOnClickListener {
            val amount = binding.frSettingsAmountEt.text.trim().toString().toLong()
            Constants.defaultAmount.value = amount
            binding.frSettingsAmountEt.text.clear()
            Toast.makeText(activity,"$amount USD is set as default amount.", Toast.LENGTH_SHORT).show()
        }

        binding.frSettingsAboutBtn.setOnClickListener {
            val action = MainNavGraphDirections.actionGlobalAboutAppFragment()
            navController.navigate(action)
        }

        return binding.root
    }
}