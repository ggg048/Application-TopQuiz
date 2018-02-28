package com.fessard.guillaume.topquiz.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Guillaume Fessard on 17/02/2018.
 */

public class QuestionBank {
    private List<Question> mQuestionList;
    //les private utiliser pour rentrer une variable
    private int mNextQuestionIndex;

    public QuestionBank(List<Question> questionList) {
        mQuestionList = questionList;

        Collections.shuffle(mQuestionList);

        mNextQuestionIndex = 0;
    }

    public Question getquestion() {
        if (mNextQuestionIndex == mQuestionList.size()) {
            mNextQuestionIndex = 0;
        }

        return mQuestionList.get(mNextQuestionIndex++);
    }


}
