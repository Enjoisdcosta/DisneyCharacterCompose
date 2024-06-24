package com.example.disneycharactercompose.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.disneycharactercompose.data.model.DataModel
import com.example.disneycharactercompose.data.model.DisneyCharacterModel
import com.example.disneycharactercompose.ui.viewmodel.DisneyCharacterViewModel

@Composable
fun CharacterListScreen(viewModel: DisneyCharacterViewModel = hiltViewModel()) {
    val characterModel by viewModel.selectCharacter.collectAsState()

    characterModel?.data?.let { data ->
        LazyColumn {
            items(data) { character ->
                character?.let {
                    CharacterItem(it)
                }
            }
        }
    } ?: run {
        Text("Loading...")
    }
}

@Composable
fun CharacterItem(character: DataModel) {
    Column {
        Text(text = "Name: ${character.name}")
        // Display other fields as needed
    }
}
