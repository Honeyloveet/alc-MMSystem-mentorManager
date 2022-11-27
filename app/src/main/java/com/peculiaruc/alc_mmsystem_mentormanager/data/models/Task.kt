package com.peculiaruc.alc_mmsystem_mentormanager.data.models

data class Task(
    var id: Int,
    var title: String,
    var description: String,
    var date_created: Long,
    var created_by: Int,
    var status: String,
    var program_id: Int
)
