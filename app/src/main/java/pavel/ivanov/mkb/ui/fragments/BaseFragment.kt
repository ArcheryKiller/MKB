package pavel.ivanov.mkb.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import pavel.ivanov.mkb.data.api.ICurrencyApi
import pavel.ivanov.mkb.databinding.FragmentBaseInfoApiBinding

class BaseFragment: Fragment() {
    private var _binding: FragmentBaseInfoApiBinding? = null
    private val binding get() = _binding!!

    private val apiService = ICurrencyApi()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBaseInfoApiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        GlobalScope.launch(Dispatchers.Main) {
            val currencyResponse = apiService.getCurrencies().await()
            binding.rid.text = currencyResponse.rid
            binding.ratesDate.text = currencyResponse.ratesDate
            binding.productState.text = currencyResponse.productState.toString()
            binding.messageTitle.text = currencyResponse.messageTitle
            binding.downloadDate.text = currencyResponse.downloadDate
            binding.code.text = currencyResponse.code.toString()
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}