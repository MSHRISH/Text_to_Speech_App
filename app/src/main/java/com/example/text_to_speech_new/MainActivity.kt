package com.example.text_to_speech_new

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    lateinit  var tts:TextToSpeech
    lateinit var spk_btn:Button
    lateinit var text_to_convert:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var spk_btn=findViewById<Button>(R.id.spk_btn)
        //var text_to_convert=findViewById<EditText>(R.id.text_to_convert)
        spk_btn=findViewById(R.id.spk_btn)
        text_to_convert=findViewById(R.id.text_to_convert)


        spk_btn.isEnabled=false

        tts=TextToSpeech(this,this)
        spk_btn.setOnClickListener {


            var text_string=text_to_convert.text.toString()
            tts.speak(text_string,TextToSpeech.QUEUE_FLUSH,null,"")
            println("YES")
        }


    }

    override fun onInit(p0: Int) {
        //TODO("Not yet implemented")
        if(p0==TextToSpeech.SUCCESS){
            val result=tts.setLanguage(Locale.US)

            if(result==TextToSpeech.LANG_MISSING_DATA||result==TextToSpeech.LANG_NOT_SUPPORTED){
                //Toast
            }
            else{
                spk_btn.isEnabled=true

            }
        }
    }


}