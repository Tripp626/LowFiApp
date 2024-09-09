package com.example.low_fiprototype

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.low_fiprototype.ui.theme.LowfiPrototypeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LowfiPrototypeTheme {
                Column {
                        MainUI(modifier = Modifier
                            .padding(5.dp)
                            .background(Color.White))

                }

            }
        }
    }
}

data class Artwork(val artist: String, val artworkName: String, val artwork: Int, val date: String)

val ArtworkList = listOf(
    Artwork(artist = "Jeremy Fritz", artwork = R.drawable.stitch_lowfi_1, artworkName = "Star Wars Stitch", date = "(2012)"),
    Artwork(artist = "Taylor Benson", artwork = R.drawable.stitch_lowfi_2, artworkName = "Hoody Stitch", date = "(2015)"),
    Artwork(artist = "Vincent Van Gogh", artwork = R.drawable.stitch_lowfi_3, artworkName = "Starry Stitch", date = "(2024)"),
    Artwork(artist = "Leonardo Da Vinci", artwork = R.drawable.stitch_lowfi_4, artworkName = "Colourful Stitch", date = "(2021)"),
    Artwork(artist = "Eichiro Oda", artwork = R.drawable.stitch_lowfi_5, artworkName = "Galaxy Stitch", date = "(2020)")
)


@Composable
fun MainUI( modifier: Modifier = Modifier) {
    var index by remember {
        mutableIntStateOf(0)
    }
    val artwork = ArtworkList[index]

    val artist: String = artwork.artist
    val artworkImage: Int = artwork.artwork
    val date: String = artwork.date
    val artworkName: String = artwork.artworkName


    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Spacer(modifier = Modifier.height(100.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Surface(color = Color.White,
                //border = BorderStroke(20.dp, Brush.sweepGradient(colors = listOf(Color.Black, Color.White)))
                shadowElevation = 20.dp
            ) {
                Image(
                    painter = painterResource(id = artworkImage),
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = 350.dp, height = 500.dp)
                        .padding(40.dp),

                    contentScale = ContentScale.Crop

                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))



    }

    Artist(artworkName = artworkName, artist = artist, date = date)

    Spacer(modifier = Modifier.height(30.dp))
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Button(onClick = {if(index > 0) index -= 1}) {
            Text(text = stringResource(R.string.previous))
        }

        Spacer(modifier = Modifier.width(50.dp))

        Button(onClick = {if(index < ArtworkList.lastIndex) index += 1}) {
            Row(modifier = Modifier.width(50.dp), horizontalArrangement = Arrangement.Center){
                Text(text = stringResource(R.string.next))
            }

        }
    }
}

@Composable
fun Artist(artworkName: String, artist: String, date: String, modifier: Modifier = Modifier){

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()) {
        Surface(
            tonalElevation = 10.dp,
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.width(350.dp),
            ){
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp))  {
                    Text(text = artworkName, fontSize = 35.sp, fontWeight = FontWeight(200))
                    Row {
                        Text(text = artist, fontSize = 22.sp, fontStyle = FontStyle.Italic, fontWeight = FontWeight(600))
                        Text(text = date, fontSize = 22.sp, fontStyle = FontStyle.Italic, fontWeight = FontWeight(300))
                    } 
                }

        }

    }
}





