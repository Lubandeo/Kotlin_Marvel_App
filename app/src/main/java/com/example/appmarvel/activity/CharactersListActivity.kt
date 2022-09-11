package com.example.appmarvel.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appmarvel.R
import com.example.appmarvel.databinding.ActivityCharactersListBinding
import com.example.appmarvel.entity.Character
import com.example.appmarvel.mvvm.viewmodel.CharactersListViewModel
import com.example.appmarvel.mvvm.viewmodel.CharactersListViewModel.CharactersListState.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CharactersListActivity : AppCompatActivity(), KoinComponent {

    private val viewModel: CharactersListViewModel by inject()
    private lateinit var binding: ActivityCharactersListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharactersListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.fetchCharactersList()
        viewModel.charactersListState.observe({ lifecycle }, ::changeStateCharacterList)
    }

    private fun changeStateCharacterList(charactersListData: CharactersListViewModel.CharactersListData) {
        when (charactersListData.charactersState) {
            FETCH_CHARACTERS -> showCharactersListOnTextView(charactersListData.data)
            ERROR_CHARACTERS_NOT_FOUND -> showErrorMessage(R.string.error_message_char_not_found)
            ERROR_OTHER -> showErrorMessage(R.string.error_message_not_exception)
        }
    }

    private fun showCharactersListOnTextView(charactersList: List<Character>) {
        binding.textViewCharactersActivityCharactersList.text = charactersList.toString()
    }

    private fun showErrorMessage(errorId: Int) {
        binding.textViewCharactersActivityCharactersList.text = getString(errorId)
    }

    companion object {
        fun getInstance(context: Context) = Intent(context, CharactersListActivity::class.java)
    }
}
