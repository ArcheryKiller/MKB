package pavel.ivanov.mkb.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import pavel.ivanov.mkb.databinding.ListOfCurrenciesBinding

class CurrencyFragment: Fragment() {
    private var _binding: ListOfCurrenciesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ListOfCurrenciesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}