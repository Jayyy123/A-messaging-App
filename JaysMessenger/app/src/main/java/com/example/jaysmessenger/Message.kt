package com.example.jaysmessenger

class Message {
    var message:String? = null
    var senderId:String? = null

    constructor(){}

    constructor(message: String, sender: String){
        this.message = message
        this.senderId = sender
    }

}