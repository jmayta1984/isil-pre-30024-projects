package pe.isil.superherocompose.ui.herolist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import pe.isil.superherocompose.data.model.Hero
import pe.isil.superherocompose.repository.HeroRepository

@Composable
fun HeroSearch() {

    val heroes = remember {
        mutableStateOf(ArrayList<Hero>())
    }
    Column {
        Search(heroes)
        HeroList(heroes)
    }
}


@Composable
fun Search(
    heroes: MutableState<ArrayList<Hero>>
) {

    val heroName = remember {
        mutableStateOf("")
    }

    val repository = HeroRepository()


    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = heroName.value,
        placeholder = { Text("Enter hero name") },
        onValueChange = { newText ->
            heroName.value = newText
        },
        leadingIcon = {
            Icon(Icons.Filled.Search, null)
        },
        keyboardOptions =  KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                repository.searchHero(heroName.value) { data ->
                    heroes.value = data
                }
            }
        )

    )
}

