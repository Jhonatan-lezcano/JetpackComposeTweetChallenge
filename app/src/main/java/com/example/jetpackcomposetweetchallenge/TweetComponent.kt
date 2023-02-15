package com.example.jetpackcomposetweetchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TweetComponent(tweet: Tweet) {
    var (avatar, nickName, atSign, creationDate, tweetText, image) = tweet

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = avatar),
                contentDescription = "Avatar",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Header(nickname = nickName, atSign = atSign, creationDate = creationDate)
                Body(tweetText = tweetText, image = image)
                ActionsIconButtons()
            }
        }
        Divider(Modifier.fillMaxWidth().height(0.2.dp).background(Color.Gray))
    }

}

@Composable
fun ActionsIconButtons() {
    var comments by rememberSaveable { mutableStateOf(1) }
    var retweets by rememberSaveable { mutableStateOf(1) }
    var likes by rememberSaveable { mutableStateOf(1) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        ActionButton(
            icon = R.drawable.ic_chat,
            onFocusIcon = R.drawable.ic_chat_filled,
            onFocusColor = Color.Gray,
            value = comments,
            onChangeValue = {
                if (!it) comments += 1
                else comments -= 1
            }
        )
        ActionButton(
            icon = R.drawable.ic_rt,
            onFocusIcon = R.drawable.ic_rt,
            onFocusColor = Color.Green,
            value = retweets,
            onChangeValue = {
                if (!it) retweets += 1
                else retweets -= 1
            }
        )

        ActionButton(
            icon = R.drawable.ic_like,
            onFocusIcon = R.drawable.ic_like_filled,
            onFocusColor = Color.Red,
            value = likes,
            onChangeValue = {
                if (!it) likes += 1
                else likes -= 1
            }
        )

        /*IconButton(onClick = { }) {
            Row(verticalAlignment = Alignment.CenterVertically) {

                Icon(
                    painter = painterResource(id = R.drawable.ic_rt),
                    contentDescription = "Comments",
                    tint = Color.Gray
                )
                Text(
                    text = retweets.toString(),
                    color = Color.Gray,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
        }
        IconButton(onClick = { }) {
            Row(verticalAlignment = Alignment.CenterVertically) {

                Icon(
                    painter = painterResource(id = R.drawable.ic_like),
                    contentDescription = "Comments",
                    tint = Color.Gray
                )
                Text(
                    text = likes.toString(),
                    color = Color.Gray,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
        }*/
        IconButton(onClick = { }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_share),
                contentDescription = "Comments",
                tint = Color.Gray
            )
        }
    }
}

@Composable
fun ActionButton(
    icon: Int,
    onFocusIcon: Int,
    onFocusColor: Color,
    value: Int,
    onChangeValue: (Boolean) -> Unit
) {
    var focus by rememberSaveable { mutableStateOf(false) }

    IconButton(onClick = {
        onChangeValue(focus)
        focus = !focus
    }) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = if (!focus)
                    painterResource(id = icon)
                else painterResource(id = onFocusIcon),
                contentDescription = "Comments",
                tint = if (!focus) Color.Gray else onFocusColor
            )
            Text(
                text = value.toString(),
                color = Color.Gray,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 5.dp)
            )
        }
    }
}

@Composable
fun Body(tweetText: String, image: Int) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = tweetText, color = Color.White)
        Spacer(modifier = Modifier.size(16.dp))
        Image(
            painter = painterResource(id = image),
            contentDescription = "Image tweet",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp)
                .clip(RoundedCornerShape(20.dp))
        )
    }
}

@Composable
fun Header(nickname: String, atSign: String, creationDate: String) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
            .fillMaxWidth()
            .padding(top = 2.dp, bottom = 8.dp)
    ) {
        Row() {
            Text(
                text = nickname,
                color = Color.White,
                modifier = Modifier.padding(end = 8.dp),
                fontWeight = FontWeight.Bold
            )
            Text(text = atSign, color = Color.Gray, modifier = Modifier.padding(end = 8.dp))
            Text(text = creationDate, color = Color.Gray)
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_dots),
            contentDescription = "Dots",
            tint = Color.Gray
        )
    }
}
