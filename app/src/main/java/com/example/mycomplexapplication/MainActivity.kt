package com.example.mycomplexapplication

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    lateinit var Sms: Button
    lateinit var Email: Button
    lateinit var Camera: Button
    lateinit var Share: Button
    lateinit var Mpesa: Button
    lateinit var Call: Button
    lateinit var Website: Button
    lateinit var Map:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Map = findViewById(R.id.Mapbutton)
        Sms = findViewById(R.id.SmsButton)
        Email = findViewById(R.id.EmailButton)
        Camera = findViewById(R.id.CameraButton)
        Share = findViewById(R.id.ShareButton)
        Mpesa = findViewById(R.id.MpesaButton)
        Call = findViewById(R.id.CallButton)
        Website = findViewById(R.id.WebsiteButton)


        Sms.setOnClickListener {

            val uri: Uri = Uri.parse("smsto:0719124371")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "Hello There")
            startActivity(intent)
        }

        Email.setOnClickListener {

            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "abc@gmail.com", null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Dear Sir,following the job adv...")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")
            startActivity(Intent.createChooser(emailIntent, "Send email..."))

        }

        Camera.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, 1)
        }


        Share.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app on https//www!")
            startActivity(shareIntent)


        }


        Mpesa.setOnClickListener {
            val simToolKitLaunchIntent =
                applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let { startActivity(it) }


        }


        Call.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "0719124371"))
            if (ContextCompat.checkSelfPermission(
                    this@MainActivity,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@MainActivity,
                    arrayOf<String>(android.Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }
        }

        Website.setOnClickListener {
            var tembea = Intent(this@MainActivity,WEbsiteActivity::class.java)
            startActivity(tembea)

        }
        Map.setOnClickListener {
            val ramani = Intent(this,MapsActivity::class.java)
            startActivity(ramani)

        }


    }
}