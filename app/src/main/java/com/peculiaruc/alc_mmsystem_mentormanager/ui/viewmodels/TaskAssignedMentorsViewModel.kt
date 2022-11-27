package com.peculiaruc.alc_mmsystem_mentormanager.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Mentor

class TaskAssignedMentorsViewModel : ViewModel() {
    val getMentors = MutableLiveData<MutableList<Mentor>>()

    private val mentorList = mutableListOf<Mentor>()

    init {
        fillTempMentorData()
    }

    private fun fillTempMentorData() {

        val mentor1 = Mentor(
            id = 1,
            name = "Peculiar C. Umeh",
            textOne = "Program Assistant, Andela, She/her",
            textTwo = "PROGRAM ASST.",
            textThree = "MENTOR-GAD",
            imageUrl = "https://images.unsplash.com/photo-1531123897727-8f129e1688ce?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1974&q=80",
            status = true
        )
        mentorList.add(mentor1)

        val mentor2 = Mentor(
            id = 2,
            name = "Peculiar C. Umeh",
            textOne = "Program Assistant, Andela, She/her",
            textTwo = "PROGRAM ASST.",
            textThree = "MENTOR-GAD",
            imageUrl = "https://images.unsplash.com/photo-1534528741775-53994a69daeb?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=464&q=80",
            status = true
        )
        mentorList.add(mentor2)

        val mentor3 = Mentor(
            id = 3,
            name = "Peculiar C. Umeh",
            textOne = "Program Assistant, Andela, She/her",
            textTwo = "PROGRAM ASST.",
            textThree = "MENTOR-GAD",
            imageUrl = "https://images.unsplash.com/photo-1632765854612-9b02b6ec2b15?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=386&q=80",
            status = true
        )
        mentorList.add(mentor3)

        val mentor4 = Mentor(
            id = 4,
            name = "Peculiar C. Umeh",
            textOne = "Program Assistant, Andela, She/her",
            textTwo = "PROGRAM ASST.",
            textThree = "MENTOR-GAD",
            imageUrl = "https://images.unsplash.com/photo-1531123897727-8f129e1688ce?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1974&q=80",
            status = true
        )
        mentorList.add(mentor4)

        val mentor5 = Mentor(
            id = 5,
            name = "Peculiar C. Umeh",
            textOne = "Program Assistant, Andela, She/her",
            textTwo = "PROGRAM ASST.",
            textThree = "MENTOR-GAD",
            imageUrl = "https://images.unsplash.com/photo-1534528741775-53994a69daeb?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=464&q=80",
            status = true
        )
        mentorList.add(mentor5)

        val mentor6 = Mentor(
            id = 6,
            name = "Peculiar C. Umeh",
            textOne = "Program Assistant, Andela, She/her",
            textTwo = "PROGRAM ASST.",
            textThree = "MENTOR-GAD",
            imageUrl = "https://images.unsplash.com/photo-1632765854612-9b02b6ec2b15?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=386&q=80",
            status = true
        )
        mentorList.add(mentor6)

        val mentor7 = Mentor(
            id = 7,
            name = "Peculiar C. Umeh",
            textOne = "Program Assistant, Andela, She/her",
            textTwo = "PROGRAM ASST.",
            textThree = "MENTOR-GAD",
            imageUrl = "https://images.unsplash.com/photo-1531123897727-8f129e1688ce?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1974&q=80",
            status = true
        )
        mentorList.add(mentor7)

        val mentor8 = Mentor(
            id = 8,
            name = "Peculiar C. Umeh",
            textOne = "Program Assistant, Andela, She/her",
            textTwo = "PROGRAM ASST.",
            textThree = "MENTOR-GAD",
            imageUrl = "https://images.unsplash.com/photo-1534528741775-53994a69daeb?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=464&q=80",
            status = true
        )
        mentorList.add(mentor8)

        val mentor9 = Mentor(
            id = 9,
            name = "Peculiar C. Umeh",
            textOne = "Program Assistant, Andela, She/her",
            textTwo = "PROGRAM ASST.",
            textThree = "MENTOR-GAD",
            imageUrl = "https://images.unsplash.com/photo-1632765854612-9b02b6ec2b15?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=386&q=80",
            status = true
        )
        mentorList.add(mentor9)

        val mentor10 = Mentor(
            id = 10,
            name = "Peculiar C. Umeh",
            textOne = "Program Assistant, Andela, She/her",
            textTwo = "PROGRAM ASST.",
            textThree = "MENTOR-GAD",
            imageUrl = "https://images.unsplash.com/photo-1531123897727-8f129e1688ce?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1974&q=80",
            status = true
        )
        mentorList.add(mentor10)

        getMentors.postValue(mentorList)
    }
}