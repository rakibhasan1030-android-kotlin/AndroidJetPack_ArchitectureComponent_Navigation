package rakib.hasan.navigationcomponent.views.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import rakib.hasan.navigationcomponent.databinding.FragmentConfirmDialogBinding

class ConfirmDialogFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentConfirmDialogBinding

    private val args: ConfirmDialogFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentConfirmDialogBinding.inflate(inflater, container, false)

        val receiverName = args.receiverName
        val amount = args.amount

        binding.fragmentConfirmDialogSubHeader.text = "Do you send $amount TK to $receiverName?"
        binding.fragmentConfirmDialogYesBtn.setOnClickListener {
            Toast.makeText(activity, "$amount TK send successfully to $receiverName", Toast.LENGTH_LONG).show()
            dismiss()
        }
        binding.fragmentConfirmDialogNoBtn.setOnClickListener { dismiss() }

        return binding.root
    }
}