package com.mallowtech.quizzapp

object Constants {
    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWER : String = "correct_answer"
    fun getQuestions(): ArrayList<Questions> {
        val questionList = ArrayList<Questions>()

        val que1 = Questions(
            1,
            "What country does this flag belong to",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Austri",
            "Australia",
            "America",
            1
        )
        questionList.add(que1)

        val que2 = Questions(
            2,
            "What country does this flag belog to",
            R.drawable.ic_flag_of_australia,
            "Argentina",
            "Austria",
            "Australia",
            "America",
            3
        )
        questionList.add(que2)

        val que3 = Questions(
            3,
            "What country does this flag",
            R.drawable.ic_flag_of_belgium,
            "Belgium",
            "Canada",
            "africa",
            "Newzeland",
            1
        )
        questionList.add(que3)

        val que4 = Questions(
            4,
            "What country does this flag",
            R.drawable.ic_flag_of_denmark,
            "India",
            "Noida",
            "Australia",
            "Denmark",
            4
        )
        questionList.add(que4)

        val que5 = Questions(
            5,
            "What country does this flag",
            R.drawable.ic_flag_of_brazil,
            "Denmark",
            "Iraq",
            "Brazil",
            "America",
            3
        )
        questionList.add(que5)

        val que6 = Questions(
            6,
            "What country does this flag",
            R.drawable.ic_flag_of_fiji,
            "Pakistan",
            "Fiji",
            "Dubai",
            "America",
            2
        )
        questionList.add(que6)

        val que7 = Questions(
            7,
            "What country does this flag",
            R.drawable.ic_flag_of_germany,
            "Germany",
            "Iran",
            "China",
            "Japan",
            1
        )
        questionList.add(que7)
        val que8 = Questions(
            8,
            "What country does this flag",
            R.drawable.ic_flag_of_india,
            "India",
            "Bangaladesh",
            "SriLanka",
            "America",
            1
        )
        questionList.add(que8)
        val que9 = Questions(
            9,
            "What country does this flag",
            R.drawable.ic_flag_of_kuwait,
            "Saudi",
            "Abudhabi",
            "Israel",
            "Kuwait",
            4
        )
        questionList.add(que9)

        val que10 = Questions(
            10,
            "What country does this flag",
            R.drawable.ic_flag_of_new_zealand,
            "Denmark",
            "Polland",
            "NewZealand",
            "America",
            3
        )
        questionList.add(que10)

        return questionList
    }
}