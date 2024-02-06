package com.gunay.compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.data.EmptyGroup.name
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gunay.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //daha önceden layout bağlanan kısım ama artık composable bağlıyoruz
        //aşşağıdaki training lambda gösteriminin aynısı
        setContent {
            Column() {
                Text(text = "Hello Text", color = Color.Magenta, fontSize = 25.sp, fontWeight = FontWeight.Bold)
                mainScreen()
            }
        }


        //fonksiyonun son parametresi lambda gösterimiyse bu şekilde parametre içinde değil ayriyetten parantez açığ yazabiliyoruz
        //buna training lambda
        testFunction(5,){
            testFunctionLambda()
        }

    }


    //lambda ---> fonksiyonun parametre olarak başka bir fonksiyon alması
    // örnek olarak buradaki -->  myFunction: () -> Unit
    // myFunction: () -> Unit = herhangibir parametre almayan () ve geriye herhangi birşey döndürmeyen Unit fonksiyon anlamına gelir
    fun testFunction(int: Int, myFunction: () -> Unit) {
        myFunction.invoke()
    }

    fun testFunctionLambda() {
        println("test")
    }




    @Composable
    fun mainScreen (){

        //column row box
        //buradaki text fonksiyonları aslında bir training gösterimidir
        //column dikey row yatay hizalama için kullanılır
        // box ise z ekseninde(üst üste durması resim üstüne yazı vb) nasıl duracağını ayarlamamızı sağlar
        //modifier ---> parametre olarak alınmayan  özellikler modifier üzerinden değiştirilebilir

            Column {
                Text(modifier = Modifier
                    .background(Color.Red)
                    .padding(5.dp) ,text = "Hello Android", color = Color.Magenta, fontSize = 25.sp, fontWeight = FontWeight.Bold)

                Text(modifier = Modifier
                    .background(Color.Black)
                    .padding(top = 30.dp, start = 1.dp, end = 1.dp, bottom = 10.dp)
                    .clickable { //onClick metodu gibi burada tıklanınca ne olacağı yazılabilir
                        println("tiklama")
                    }
                    //.width(250.dp)
                    //.height(200.dp)
                    .fillMaxWidth()
                    ,text = "Hello World",color = Color.Magenta,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold)

                //tek bir text-button gibi elementlerinde composable foksiyonları üretilerek bu şekilde birçok farklı yerde kullanılabilir
                //composable içide composable kullanılabilir
                proText()
            }
            Row() {
                Text(modifier = Modifier
                    .background(Color.Black)
                    .padding(10.dp)
                    //.size(250.dp,150.dp)
                    .fillMaxSize(0.5f) ,
                    text = "Hello Android", color = Color.White, fontSize = 25.sp, fontWeight = FontWeight.Bold)
                Text(text = "Hello World", color = Color.Magenta, fontSize = 25.sp, fontWeight = FontWeight.Bold)
            }


    }

    @Composable
    fun proText(){
        Text(modifier = Modifier
            .background(Color.Black)
            .padding(top = 30.dp, start = 1.dp, end = 1.dp, bottom = 10.dp)
            .clickable { //onClick metodu gibi burada tıklanınca ne olacağı yazılabilir
                println("tiklama")
            }
            //.width(250.dp)
            //.height(200.dp)
            .fillMaxWidth()
            ,text = "Hello World",color = Color.Magenta,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold)
    }




    // geliştiricilerin gördüğü kısım
    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        Column() {
            Text(text = "Hello Text", color = Color.Magenta, fontSize = 25.sp, fontWeight = FontWeight.Bold)
            mainScreen()
        }

    }
}