package com.example.dolapcloneapp.ui.Screens.detailScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.dolapcloneapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecureShoppingScreen(){
    var openBottomSheet by remember { mutableStateOf(false) }
    Row (modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
        Image(painter = painterResource(id = R.drawable.secure_shopping_nobg), contentDescription = null, modifier = Modifier
            .size(100.dp)
            .padding(start = 10.dp))
        Column (modifier = Modifier.padding(start = 5.dp)){
            Text(text = "Safe shopping in Wardrobe", fontWeight = FontWeight.Bold,color = Color.Black,  fontSize = 15.sp, modifier  = Modifier.padding(start = 3.dp,top = 20.dp))
            Text( overflow = TextOverflow.Ellipsis,text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.", modifier= Modifier.padding(top = 5.dp))
            Text(text = "Detail Information", fontWeight = FontWeight.Bold,color = Color.Green, modifier = Modifier
                .padding(top = 3.dp)
                .clickable {
                    openBottomSheet = true
                }
            )
        }
        if (openBottomSheet){
            ModalBottomSheet()

        }
    }
}



@Composable
fun ModalBottomSheet(){
    Column (verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(bottom = 5.dp)){
        Text("Safe shopping in Wardrobe ", fontWeight = FontWeight.Bold, color= Color.Black,fontSize = 15.sp)
        Divider(thickness = 3.dp, color = colorResource(id = R.color.lightos_green))
        Text("For a safe shopping experience, a service fee will be added to your purchases in Wardrobe, based on the order amount.", modifier = Modifier.padding(5.dp))
        Divider(thickness = 5.dp, color = colorResource(id = R.color.lightos_green))
        SheetContent()
    }

}
@Composable
fun SheetContent() {
    Column {
        FeatureRow(
            imageId = R.drawable.guvenli_odeme,
            title = "Payment is secure",
            description = "The payments you make for Wardrobe purchases are securely held in the account, and once you receive and confirm the product, the payment is transferred to the seller."
        )

        Spacer(modifier = Modifier.height(20.dp))

        FeatureRow(
            imageId = R.drawable.shipping_icon,
            title = "Contracted Cargo",
            description = "With the offered shipping options of Wardrobe, your order reaches you much more affordably and quickly."
        )

        Spacer(modifier = Modifier.height(20.dp))

        FeatureRow(
            imageId = R.drawable.return_order,
            title = "Easy Return Policy",
            description = "If the product you purchased is different from the product specified in the advertisement and you want to return it, you can easily submit this request to the seller. In case of dispute, the expert team of Wardrobe will make the refund immediately."
        )

        Spacer(modifier = Modifier.height(20.dp))

        FeatureRow(
            imageId = R.drawable.online_supporter,
            title = "Connection with Wardrobe Support",
            description = "For problems regarding your order, you can contact Wardrobe Support 24/7 and benefit from the knowledge of our expert team."
        )

        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun FeatureRow(imageId: Int, title: String, description: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                title,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 5.dp)
            )
            Text(fontSize = 13.sp, text = description)
        }
    }
}
