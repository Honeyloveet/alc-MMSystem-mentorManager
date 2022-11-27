package com.peculiaruc.alc_mmsystem_mentormanager.data.models

data class Mentor(
    var id: Int,
    var name: String,
    var textOne: String,
    var textTwo: String,
    var textThree: String,
    var imageUrl: String,
    var status: Boolean
)
