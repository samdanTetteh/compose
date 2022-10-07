package com.ijikod.composetutorial

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.widget.GridLayout
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.Typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ijikod.composetutorial.data.AlignYourBody
import com.ijikod.composetutorial.data.AlignYourBodySampleData
import com.ijikod.composetutorial.data.Favourite
import com.ijikod.composetutorial.data.FavouriteCollectionData
import com.ijikod.composetutorial.ui.theme.ComposeTutorialTheme

class MySoothe {

    @Composable
    fun MyApp() {
        Surface(color = MaterialTheme.colors.background) {
            ContentScreen()
        }
    }


    @Composable
    private fun ContentScreen() {

    }


    @Composable
    private fun SearchBar(modifier: Modifier) {
        TextField(value = "",
            onValueChange = {},
            modifier = modifier
                .fillMaxWidth()
                .heightIn(56.dp),
            colors =  TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.surface
            ),
        placeholder = {
            Text(text = "search")
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search,
                contentDescription = null)
        })
    }



    @Composable
    private fun AlignYourBodyElement(modifier: Modifier = Modifier,
                                     drawable: Int,
                                     text: Int){
        Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(88.dp))


            Text(text = stringResource(id = text), style = MaterialTheme.typography.subtitle2,
                modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp))
        }
    }

    @Composable
    private fun FavouriteCollectionCard(modifier: Modifier = Modifier,
    imageDrawable: Int, text: Int) {
        Surface(modifier = Modifier, shape = MaterialTheme.shapes.small) {
            Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(192.dp)) {
                Image(painter = painterResource(imageDrawable),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(56.dp))
                
                Text(text = stringResource(text),
                    style= MaterialTheme.typography.subtitle2,
                modifier = Modifier.padding(horizontal = 16.dp))
            }
        }
    }
    
    
    
    @Composable
    private fun AlignYourBodyRow(modifier: Modifier = Modifier,
                                 alignYourBodyData: List<AlignYourBody>){
        LazyRow(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(16.dp)
        ) {
            items(alignYourBodyData){ item ->
                AlignYourBodyElement(drawable = item.imageDrawable,
                    text = item.text)
            }
        }
    }


    @Composable
    private fun FavouriteCollectionGrid(modifier: Modifier = Modifier, data: List<Favourite>){
        LazyHorizontalGrid(rows = GridCells.Fixed(2),
            modifier = modifier.height(120.dp),
        contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            items(data) { items ->
                FavouriteCollectionCard(Modifier.height(56.dp),
                    imageDrawable = items.drawable,
                    text = items.text)
            }
        }
    }

    @Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
    @Composable
    fun FavouriteCollectinPreview(){
        ComposeTutorialTheme {
            FavouriteCollectionGrid(data = FavouriteCollectionData.favouriteDataSample)
        }
    }
    
    @Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
    @Composable
    fun AlignYourBodyRowPreview(){
        ComposeTutorialTheme {
            AlignYourBodyRow(alignYourBodyData = AlignYourBodySampleData.alignBodySample)
        }
    }
    
    @Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
    @Composable
    fun FavouriteCollectionCardPreview() {
        ComposeTutorialTheme {
            FavouriteCollectionCard(Modifier.padding(8.dp),
                R.drawable.fc2_nature_meditations,
                R.string.fc2_nature_meditations)
        }
    }


    @Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
    @Composable
    fun AlignYourBodyElementPreview(){
        ComposeTutorialTheme {
            AlignYourBodyElement(
                modifier = Modifier.padding(8.dp),
                R.drawable.ab1_inversions,
                R.string.ab1_inversions)
        }
    }


    @Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
    @Composable
    fun SearchBarPreview(){
        ComposeTutorialTheme { SearchBar(Modifier.padding(8.dp)) }
    }



    @Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES, name = "My Soothe content")
    @Composable()
    fun DefaultPreview(){
        ComposeTutorialTheme { MyApp() }
    }

}