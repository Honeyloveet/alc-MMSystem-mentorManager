package com.peculiaruc.alc_mmsystem_mentormanager.data.models

/**
 * Holds the Mentor information
 * which comes form the backend.
 */
data class Mentor(
    var id: Int,
    var name: String,
    var textOne: String,
    var textTwo: String,
    var textThree: String,
    var imageUrl: String,
    var status: Boolean
)
