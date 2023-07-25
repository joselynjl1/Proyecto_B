package com.example.proyecto_b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyecto_b.model.Conferencia
import com.google.firebase.firestore.FirebaseFirestore
import org.json.JSONArray
import org.json.JSONObject
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}