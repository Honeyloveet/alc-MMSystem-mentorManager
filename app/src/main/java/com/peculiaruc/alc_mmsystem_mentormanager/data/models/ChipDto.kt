package com.peculiaruc.alc_mmsystem_mentormanager.data.models

/**
 * This data class holds the [id] and [name] for the chips
 * of the previous programs held and technical proficiency
 * which we get from the back end and dynamically add them
 * to the view
 */
data class ChipDto(
    var id: Int,
    var name : String
)
