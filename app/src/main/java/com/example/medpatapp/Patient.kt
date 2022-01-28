package com.example.medpatapp

class Patient {
    var name:String = ""
    var email:String = ""
    var password:String= ""
    var id:String= ""
    var number:String= ""
    constructor(name:String, email:String, password:String,id:String,number:String){
        this.name= name
        this.email= email
        this.password= password
        this.id= id
        this.number= number


    }
    constructor(){}

}