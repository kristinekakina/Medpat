package com.example.medpatapp

class Doctor {
    var name:String = ""
    var email:String = ""
    var password:String= ""
    var id:String= ""
    var number:String= ""
    var specialty:String= ""
    var work:String= ""
    constructor(name:String, email:String, password:String,id:String,number:String,
                specialty:String,work:String){
        this.name= name
        this.email= email
        this.password= password
        this.id= id
        this.number= number
        this.specialty= specialty
        this.work= work

    }
    constructor(){}
}