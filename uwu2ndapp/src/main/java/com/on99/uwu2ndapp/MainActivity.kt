package com.on99.uwu2ndapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintSet.Layout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.chip.Chip
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    private var locationManager : LocationManager? = null
//    private var textViewForLoc:TextView = findViewById(R.id.tV4Loc)
    private var LocCount:Long = 0L
    @RequiresApi(Build.VERSION_CODES.S)
    @SuppressLint("UseSwitchCompatOrMaterialCode", "ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var switch1: Switch = findViewById(R.id.switch1)
        var pic1: ImageView = findViewById(R.id.imageView99)
        val text2: TextView = findViewById(R.id.textView2)
        var textViewForLoc:TextView = findViewById(R.id.tV4Loc)
        var temp: CharSequence
        val chipOf4:Chip = findViewById(R.id.chip4)
        val buttonLow2:Button = findViewById(R.id.butLow2)
        chipOf4.setOnClickListener(View.OnClickListener {
            println("CHIP 4 IS CLICKING")
            val intent = Intent(this,Low0Activity::class.java)
            startActivity(intent)
        })
        val chipOf5:Chip = findViewById(R.id.chip5)
        chipOf5.setOnClickListener(View.OnClickListener {
            text2.setText(R.string.app_name)
            val intent2 = Intent(this,Low1Activity::class.java)
            startActivity(intent2)
        })
        val chipOf6:Chip = findViewById(R.id.chip6)
        chipOf6.setOnClickListener(View.OnClickListener {
            chipOf6.setText(R.string.forSwitch)
        })
        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager?
        val locationListener: LocationListener = object : LocationListener {
            override fun onLocationChanged(location: Location) {
                LocCount+=1;
//            println("" + location.longitude + ":" + location.latitude)
                val tempStr: String =  LocCount.toString() + " :: "+location.longitude.toString()+" :: "+location.latitude.toString()
                textViewForLoc.setText(tempStr)
            }
            override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
            override fun onProviderEnabled(provider: String) {}
            override fun onProviderDisabled(provider: String) {}
        }
        switch1.setOnCheckedChangeListener { _, b ->
            if (b) {
                print("open  ")
                temp = switch1.textOn
                text2.setText(temp)
                println(temp.toString())
                pic1.setImageResource(android.R.drawable.btn_star_big_on)
                val toast1: Toast = Toast.makeText(this, R.string.forSwitchOn, Toast.LENGTH_SHORT)
                toast1.setGravity(Gravity.TOP, 0, 0)
                toast1.show()
                getPhoneAllDetail()
            } else {
                print("close ")
                temp = switch1.textOff
                text2.setText(temp)
                println(temp.toString())
                pic1.setImageResource(android.R.drawable.btn_star_big_off)
                val toast2: Toast = Toast.makeText(this, R.string.forSwitchOff, Toast.LENGTH_LONG)
                toast2.setGravity(Gravity.BOTTOM, 5, 0)
                toast2.show()
                try {
                    locationManager?.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0L,0f,locationListener)
                }catch(ex: SecurityException) {
                    Log.d("myTag", "Security Exception, no location available")
                }
            }
        }
        buttonLow2.setOnClickListener {
            val intentLow2 = Intent(this,Low2Acyitivity::class.java)
            startActivity(intentLow2)
        }

    }
    //define the listener
   /* private val locationListener: LocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            LocCount+=1;
//            println("" + location.longitude + ":" + location.latitude)
            val tempStr: String =  LocCount.toString() + " :: "+location.longitude.toString()+" :: "+location.latitude.toString()
            textViewForLoc.setText(tempStr)
        }
        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String) {}
    }*/



    /*    fun Greeting(name:String){
            println("now is Greeting out")
            println(name)
            println("-----------")
        }*/
    @RequiresApi(Build.VERSION_CODES.S)
    fun getPhoneAllDetail() {
        println("Board: "+android.os.Build.BOARD)//??????
        println("BOOTLOADER: "+android.os.Build.BOOTLOADER)//???????????????????????????
        println("DEVICE: "+android.os.Build.DEVICE)//????????????
        println("BRAND: "+android.os.Build.BRAND)//???????????????
        println("ID: "+android.os.Build.ID)//??????????????????
        println("DISPLAY: "+android.os.Build.DISPLAY)//A build ID string meant for displaying to the user
        println("FINGERPRINT: "+android.os.Build.FINGERPRINT)//????????????????????????????????????????????????????????????
        println("HARDWARE: "+android.os.Build.HARDWARE)//????????????
        println("HOST: "+android.os.Build.HOST)//?????????? MIMAX??????c3-miui-ota-bd58.bj
        println("MANUFACTURER: "+android.os.Build.MANUFACTURER)//??????/??????????????????
        println("MODEL: "+android.os.Build.MODEL)//??????
//        println("ODM_SKU: "+android.os.Build.ODM_SKU)
        println("PRODUCT: "+android.os.Build.PRODUCT)//???????????????
//        println("SKU: "+android.os.Build.SKU)
//        println("SOC_MANUFACTURER: "+android.os.Build.SOC_MANUFACTURER)
//        println("SOC_MODEL: "+android.os.Build.SOC_MODEL)
        println("SUPPORTED_32_BIT_ABIS: "+android.os.Build.SUPPORTED_32_BIT_ABIS)//??????32???ABIs?????????????????????
        println("SUPPORTED_64_BIT_ABIS: "+android.os.Build.SUPPORTED_64_BIT_ABIS)//??????64???ABIs?????????????????????
        println("SUPPORTED_ABIS: "+android.os.Build.SUPPORTED_ABIS)//??????ABIs?????????????????????
        println("TAGS: "+android.os.Build.TAGS)//??????Build?????????
        println("TIME: "+android.os.Build.TIME)//??????????????????
        println("TYPE: "+android.os.Build.TYPE)//???Build?????????
        println("UNKNOWN: "+android.os.Build.UNKNOWN)//
        println("USER: "+android.os.Build.USER)//??????Build???USER
        println("----------------------------------------------------------------------")
    }

}