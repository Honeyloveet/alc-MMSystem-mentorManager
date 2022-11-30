package com.peculiaruc.alc_mmsystem_mentormanager.data.models

/**
 * Holds the Programs information
 * which comes form the backend.
 */
data class ProgramDto(
    var id:Int,
    var name:String,
    var image : String? = null
)
