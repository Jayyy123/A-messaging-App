package com.example.jaysmessenger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class Login : AppCompatActivity() {

    private lateinit var editEmail: EditText
    private lateinit var editPassword: EditText
    private lateinit var log_in: Button
    private lateinit var signUp: Button
    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        mAuth = FirebaseAuth.getInstance()


        editEmail = findViewById(R.id.edit_email)
        editPassword = findViewById(R.id.edit_password)
        log_in = findViewById(R.id.log_in)
        signUp = findViewById(R.id.sign_up)

        log_in.setOnClickListener{
            val email = editEmail.text.toString()
            val password = editPassword.text.toString()

            login(email,password)
        }

        signUp.setOnClickListener{
            val intent = Intent(this,Signup::class.java)
            startActivity(intent)
        }
    }
    private fun login(email:String,password:String){
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this@Login,MainActivity::class.java)
                    finish()
                    startActivity(intent)
                } else {
                    Toast.makeText(this@Login,"An error has occured Logging you in\n Please check your details try again",Toast.LENGTH_SHORT).show()
                }
            }
    }
}