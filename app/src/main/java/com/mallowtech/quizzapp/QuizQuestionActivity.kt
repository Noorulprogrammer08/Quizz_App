package com.mallowtech.quizzapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition: Int = 1
    private var mQuestionlist: ArrayList<Questions>? = null
    private var mSelectedPosition: Int = 0
    private var mCorrectAnswer: Int = 0
    private var mUserName: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUserName = intent.getStringExtra(Constants.USER_NAME)
        mQuestionlist = Constants.getQuestions()

        tv_optionOne.setOnClickListener(this)
        tv_optionTwo.setOnClickListener(this)
        tv_optionThree.setOnClickListener(this)
        tv_optionFour.setOnClickListener(this)
        btn_question_submit.setOnClickListener(this)
        setQuestion()
    }

    fun setQuestion() {

        val question = mQuestionlist!![mCurrentPosition - 1]

        defaultOptionsView()
        if (mCurrentPosition == mQuestionlist!!.size) {
            btn_question_submit.text = "FINISH"
        } else
            btn_question_submit.text = "SUBMIT"
        pb_progressBar.progress = mCurrentPosition
        tv_progressCount.text = "$mCurrentPosition" + "/" + pb_progressBar.max
        tv_Question.text = question.question
        iv_countryImage.setImageResource(question.image)
        tv_optionOne.text = question.optionOne
        tv_optionTwo.text = question.optionTwo
        tv_optionThree.text = question.optionThree
        tv_optionFour.text = question.optionFour
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0, tv_optionOne)
        options.add(1, tv_optionTwo)
        options.add(2, tv_optionThree)
        options.add(3, tv_optionFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_optionOne -> {
                selectedOptionView(tv_optionOne, 1)
            }
            R.id.tv_optionTwo -> {
                selectedOptionView(tv_optionTwo, 2)
            }
            R.id.tv_optionThree -> {
                selectedOptionView(tv_optionThree, 3)
            }
            R.id.tv_optionFour -> {
                selectedOptionView(tv_optionFour, 4)
            }
            R.id.btn_question_submit -> {
                if (mSelectedPosition == 0) {
                    mCurrentPosition++
                    when {
                        mCurrentPosition <= mQuestionlist!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, QuizResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWER, mCorrectAnswer)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionlist!!.size)
                            startActivity(intent)
                        }
                    }
                } else {
                    val question = mQuestionlist?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedPosition) {
                        answerView(mSelectedPosition, R.drawable.incorrect_option_border)
                    } else {
                        mCorrectAnswer++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border)
                    if (mCurrentPosition == mQuestionlist!!.size) {
                        btn_question_submit.text = "FINISH"
                    } else {
                        btn_question_submit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                tv_optionOne.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                tv_optionTwo.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                tv_optionThree.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                tv_optionFour.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNumber: Int) {

        defaultOptionsView()
        mSelectedPosition = selectedOptionNumber
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border)

    }
}