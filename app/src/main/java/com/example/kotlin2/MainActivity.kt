package com.example.kotlin2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.kotlin2.ui.FeaturedContent
import com.example.kotlin2.ui.WindowItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var selected by remember {
                mutableStateOf(1)
            }

            val featured = mutableListOf<FeaturedContent>()

            featured.add(FeaturedContent("Sleep Meditation", "Start", R.drawable.meditate))
            featured.add(FeaturedContent("Tips for sleeping", "Start", R.drawable.sleep))
            featured.add(FeaturedContent("Sleep Quotes", "Start", R.drawable.play))
            featured.add(FeaturedContent("Calming sounds", "Start", R.drawable.music))
            featured.add(FeaturedContent("Sleep affirmations", "Start", R.drawable.night))
            featured.add(FeaturedContent("Ocean sounds", "Start", R.drawable.volume))

            val images = listOf(
                R.drawable.bg1,
                R.drawable.bg2,
                R.drawable.bg3,
                R.drawable.bg4,
                R.drawable.bg5,
                R.drawable.bg6
            )

            val quotes = listOf(
                "Did you know that no matter how flat and boring your life is, it's so insignificant that the Earth remains round?",
                "Did you know that you cant actually cry someone a river even when told to?",
                "Did you know that your hair is made up of the same stuff as your teeth?"
            )

            var currentIndex by remember {
                mutableStateOf(0)
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(8, 14, 56))
                    .padding(10.dp)
                    .verticalScroll(state = rememberScrollState())

            ) {
                Spacer(modifier = Modifier.height(10.dp))
                ConstraintLayout(
                    modifier = Modifier
                        .height(75.dp)
                        .fillMaxWidth()
                ) {
                    val (userGreeting, userWish, search) = createRefs()
                    Text(
                        text = "Good Morning, User",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.White,
                        modifier = Modifier.constrainAs(userGreeting) {
                            top.linkTo(parent.top)
                        })
                    Text(
                        text = "We hope you have a good day!",
                        fontSize = 15.sp,
                        color = Color.Gray,
                        modifier = Modifier.constrainAs(userWish) {
                            top.linkTo(userGreeting.bottom)
                        })

                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                        elevation = ButtonDefaults.elevation(0.dp),
                        modifier = Modifier.constrainAs(search) {
                            end.linkTo(parent.end)
                            top.linkTo(parent.top)
                        }) {
                        Image(
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp),
                            colorFilter = ColorFilter.tint(Color.White)
                        )
                    }
                }

                LazyRow {
                    item {
                        Row {
                            Button(
                                onClick = {
                                    selected = 1
                                },
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = if (selected == 1) {
                                        Color(37, 88, 216)
                                    } else {
                                        Color.Gray
                                    }
                                ),
                                elevation = ButtonDefaults.elevation(0.dp),
                                modifier = Modifier.height(50.dp)
                            ) {
                                Text(
                                    text = "Sweet Sleep",
                                    color = Color.White,
                                    maxLines = 1,
                                    fontSize = 15.sp
                                )
                            }

                            Spacer(modifier = Modifier.width(10.dp))

                            Button(
                                onClick = {
                                    selected = 2
                                },
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = if (selected == 2) {
                                        Color(37, 88, 216)
                                    } else {
                                        Color.Gray
                                    }
                                ),
                                elevation = ButtonDefaults.elevation(0.dp),
                                modifier = Modifier.height(50.dp)
                            ) {
                                Text(
                                    text = "Insomnia",
                                    color = Color.White,
                                    maxLines = 1,
                                    fontSize = 15.sp
                                )
                            }

                            Spacer(modifier = Modifier.width(10.dp))

                            Button(
                                onClick = {
                                    selected = 3
                                },
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = if (selected == 3) {
                                        Color(37, 88, 216)
                                    } else {
                                        Color.Gray
                                    }
                                ),
                                elevation = ButtonDefaults.elevation(0.dp),
                                modifier = Modifier.height(50.dp)
                            ) {
                                Text(
                                    text = "Depression",
                                    color = Color.White,
                                    maxLines = 1,
                                    fontSize = 15.sp
                                )
                            }
                        }
                    }
                }


                Spacer(modifier = Modifier.height(15.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(85.dp),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Row(
                        Modifier
                            .background(Color(255, 81, 162))
                            .padding(start = 10.dp, end = 10.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(5F)
                                .background(Color(255, 81, 162))
                                .fillMaxHeight(),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Daily thought",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = Color.White,
                            )

                            Text(
                                text = "Meditation 3 - 10 Minutes",
                                fontSize = 15.sp,
                                color = Color.White,
                            )
                        }

                        Row(
                            modifier = Modifier
                                .weight(1F)
                                .height(85.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.End
                        ) {
                            Button(
                                onClick = {},
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Color.Transparent
                                ),
                                elevation = ButtonDefaults.elevation(0.dp),
                                modifier = Modifier.fillMaxHeight()
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.play),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(30.dp)
                                        .drawBehind {
                                            drawCircle(
                                                radius = 70F, color = Color(
                                                    37,
                                                    88,
                                                    216
                                                )
                                            )
                                        },
                                    colorFilter = ColorFilter.tint(Color.White),
                                )
                            }
                        }
                    }

                }

                Spacer(Modifier.height(20.dp))

                Text(
                    text = "Featured",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(10.dp))

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(380.dp),
                ) {
                    items(1) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Feature(featuredContent = featured[0], images[0])
                            Feature(featuredContent = featured[1], images[1])
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Feature(featuredContent = featured[2], images[2])
                            Feature(featuredContent = featured[3], images[3])
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Feature(featuredContent = featured[4], images[4])
                            Feature(featuredContent = featured[5], images[5])
                        }
                    }
                }

                Spacer(Modifier.height(30.dp))

                Text(
                    text = "Quotes",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )

                Spacer(Modifier.height(10.dp))

                Card(shape = RoundedCornerShape(10.dp)) {
                    var text by remember {
                        mutableStateOf(quotes[0])
                    }

                    Column(
                        modifier = Modifier
                            .height(150.dp)
                            .width(390.dp)
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(
                                        Color(9, 20, 97),
                                        Color(37, 88, 216)
                                    )
                                )
                            )
                    ) {
                        Text(
                            text = text,
                            color = Color.White,
                            fontSize = 20.sp,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .weight(0.5F)
                                .fillMaxHeight()
                                .padding(top = 15.dp, start = 10.dp, end = 10.dp),
                            style = TextStyle(textAlign = TextAlign.Center)
                        )

                        Row(
                            Modifier
                                .weight(0.23F)
                                .width(400.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Button(
                                onClick = {
                                    if (currentIndex - 1 > 0) {
                                        currentIndex -= 1
                                        text = quotes[currentIndex]
                                    } else {
                                        currentIndex = 0
                                        text = quotes[currentIndex]
                                    }
                                },
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.previous),
                                    contentDescription = null,
                                    colorFilter = ColorFilter.tint(
                                        Color.White
                                    )
                                )
                            }

                            Button(
                                onClick = {
                                    if (currentIndex + 1 < quotes.size) {
                                        currentIndex += 1
                                        text = quotes[currentIndex]
                                    }
                                },
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.next),
                                    contentDescription = null,
                                    colorFilter = ColorFilter.tint(
                                        Color.White
                                    )
                                )
                            }
                        }
                        Spacer(Modifier.width(10.dp))
                    }
                }
                Spacer(Modifier.height(80.dp))
            }

            Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.Bottom) {
                Windows(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(8, 14, 56))
                        .padding(
                            start = 25.dp,
                            end = 25.dp,
                            top = 7.dp,
                            bottom = 7.dp
                        )
                )
            }
        }
    }
}

@Composable
fun Feature(featuredContent: FeaturedContent, imageID: Int) {
    Card(
        modifier = Modifier
            .height(180.dp)
            .width(175.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Image(
            painter = painterResource(id = imageID), contentDescription = null, modifier = Modifier
                .height(210.dp)
                .fillMaxWidth(), contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 25.dp, start = 15.dp, end = 15.dp, bottom = 15.dp)
        ) {
            Text(
                text = featuredContent.contentDesc,
                fontSize = 23.sp,
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.fillMaxHeight(0.7F)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = featuredContent.contentImage),
                    contentDescription = featuredContent.contentDesc,
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .size(25.dp),
                    colorFilter = ColorFilter.tint(Color.Black)
                )

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0, 5, 100)),
                    elevation = ButtonDefaults.elevation(
                        defaultElevation = 25.dp,
                        pressedElevation = 50.dp
                    )
                ) {
                    Text(text = featuredContent.contentAction, color = Color.White)
                }
            }
        }
    }
}

@Composable
fun Windows(modifier: Modifier) {
    var selected by remember {
        mutableStateOf(0)
    }

    val items = listOf(
        WindowItem("Home", R.drawable.home),
        WindowItem("Meditate", R.drawable.meditate),
        WindowItem("Sleep", R.drawable.night),
        WindowItem("Music", R.drawable.music),
        WindowItem("Profile", R.drawable.profile)
    )

    Row(modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        items.forEachIndexed { index, windowItem ->
            WindowItem(text = windowItem.itemName, icon = windowItem.itemIcon, currentSelected = selected, index = index) {
                selected = index
            }
        }
    }
}

@Composable
fun WindowItem(
    text:String,
    icon:Int,
    currentSelected:Int,
    index:Int,
    onSelect:() -> Unit
){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .drawBehind {
                    drawRoundRect(
                        if (currentSelected == index) {
                            Color(37, 88, 216)
                        } else {
                            Color.Transparent
                        }
                    )
                }
                .clickable {
                    onSelect()
                },
            colorFilter = ColorFilter.tint(
                if (currentSelected == index) {
                    Color.White
                } else {
                    Color.Gray
                }
            )
        )

        Spacer(Modifier.height(3.dp))
        Text(
            text = text, color = if (currentSelected == index) {
                Color.White
            } else {
                Color.Gray
            }
        )
    }
}