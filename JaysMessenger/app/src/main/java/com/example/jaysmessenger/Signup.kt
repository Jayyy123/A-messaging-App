package com.example.jaysmessenger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.sql.DatabaseMetaData

class Signup : AppCompatActivity() {

    private lateinit var editEmail: EditText
    private lateinit var editPassword: EditText
    private lateinit var editName: EditText
    private lateinit var signUp: Button
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDb: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {

        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        mAuth = FirebaseAuth.getInstance()

        editName = findViewById(R.id.edit_name)
        editEmail = findViewById(R.id.edit_email)
        editPassword = findViewById(R.id.edit_password)
        signUp = findViewById(R.id.sign_up)

        signUp.setOnClickListener{
            val name = editName.text.toString()
            val email = editEmail.text.toString()
            val password = editPassword.text.toString()
            signUp(name,email,password)
        }
    }

    private fun signUp(name:String,email:String,password:String) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    //for jumping to home
                    addUSer(name, email, mAuth.currentUser?.uid!!)
                    val intent = Intent(this@Signup, MainActivity::class.java)
                    finish()
                    startActivity(intent)

                } else {
                    Toast.makeText(this@Signup, "An error occurred", Toast.LENGTH_SHORT).show()
                }
            }
    }
    private fun addUSer(name:String,email: String,uid:String){
        mDb = FirebaseDatabase.getInstance().getReference()
        mDb.child("user").child(uid).setValue(User(name,email,uid))
    }
}