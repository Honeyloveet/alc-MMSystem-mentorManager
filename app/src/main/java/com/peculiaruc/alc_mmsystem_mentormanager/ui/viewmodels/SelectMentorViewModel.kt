package com.peculiaruc.alc_mmsystem_mentormanager.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Mentor

/**
 * ViewModel for SelectTaskMentorFragment
 */
class SelectMentorViewModel : ViewModel() {

    private val tempName = "Peculiar C. Umeh"
    private val tempText1 = "Program Assistant, Andela, She/her"
    private val tempText2 = "PROGRAM ASST."
    private val tempText3 = "MENTOR-GAD"
    private val tempImage1 = "https://images.unsplash.com/photo-1531123897727-8f129e1688ce?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1974&q=80"
    private val tempImage2 = "https://images.unsplash.com/photo-1534528741775-53994a69daeb?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=464&q=80"
    private val tempImage3 = "https://images.unsplash.com/photo-1632765854612-9b02b6ec2b15?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=386&q=80"

    val getMentors = MutableLiveData<MutableList<Mentor>>()

    private val mentorList = mutableListOf<Mentor>()

    init {
        fillTempMentorData()
    }

    private fun fillTempMentorData() {

        val mentor1 = Mentor(id = 1, name = tempName, textOne = tempText1, textTwo = tempText2, textThree = tempText3, imageUrl = tempImage1, status = true)
        mentorList.add(mentor1)

        val mentor2 = Mentor(id = 2, name = tempName, textOne = tempText1, textTwo = tempText2, textThree = tempText3, imageUrl = tempImage2, status = true)
        mentorList.add(mentor2)

        val mentor3 = Mentor(id = 3, name = tempName, textOne = tempText1, textTwo = tempText2, textThree = tempText3, imageUrl = tempImage3, status = true)
        mentorList.add(mentor3)

        val mentor4 = Mentor(id = 4, name = tempName, textOne = tempText1, textTwo = tempText2, textThree = tempText3, imageUrl = tempImage1, status = true)
        mentorList.add(mentor4)

        val mentor5 = Mentor(id = 5, name = tempName, textOne = tempText1, textTwo = tempText2, textThree = tempText3, imageUrl = tempImage2, status = true)
        mentorList.add(mentor5)

        val mentor6 = Mentor(id = 6, name = tempName, textOne = tempText1, textTwo = tempText2, textThree = tempText3, imageUrl = tempImage3, status = true)
        mentorList.add(mentor6)

        val mentor7 = Mentor(id = 7, name = tempName, textOne = tempText1, textTwo = tempText2, textThree = tempText3, imageUrl = tempImage1, status = true)
        mentorList.add(mentor7)

        val mentor8 = Mentor(id = 8, name = tempName, textOne = tempText1, textTwo = tempText2, textThree = tempText3, imageUrl = tempImage2, status = true)
        mentorList.add(mentor8)

        val mentor9 = Mentor(id = 9, name = tempName, textOne = tempText1, textTwo = tempText2, textThree = tempText3, imageUrl = tempImage3, status = true)
        mentorList.add(mentor9)

        val mentor10 = Mentor(
            id = 10,
            name = tempName,
            textOne = tempText1,
            textTwo = tempText2,
            textThree = tempText3,
            imageUrl = tempImage1,
            status = true
        )
        mentorList.add(mentor10)

        getMentors.postValue(mentorList)
    }
}