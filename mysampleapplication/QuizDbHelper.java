package com.example.mysampleapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.mysampleapplication.QuizContract.*;

import java.util.ArrayList;

public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MathMagician.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER, " +
                QuestionsTable.COLUMN_CATEGORY + " TEXT" +
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable() {
        Question q1 = new Question("1x1", "1", "2",
                "3", "4", 1, Question.CATEGORY_MULTIPLICATION);
        addQuestion(q1);
        Question q2 = new Question("1x2", "2", "4",
                "3", "4", 1,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q2);
        Question q3 = new Question("1x3", "4", "3",
                "1", "5",  2,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q3);
        Question q4 = new Question("1x4", "2", "1",
                "4", "5", 3,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q4);
        Question q5 = new Question("1x5", "5", "3",
                "2", "6",  1,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q5);
        Question q6 = new Question("2x5", "5", "10",
                "15", "20",  2,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q6);
        Question q7 = new Question("3x5", "5", "10",
                "15", "20",  3,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q7);
        Question q8 = new Question("4x5", "5", "10",
                "15", "20",  4,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q8);
        Question q9 = new Question("1x6", "5", "7",
                "8", "6",  4,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q9);
        Question q10 = new Question("2x6", "6", "11",
                "12", "13",  3,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q10);
        Question q11 = new Question("3x6", "6", "12",
                "24", "18",  4,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q11);
        Question q12 = new Question("4x6", "20", "24",
                "28", "26",  2,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q12);
        Question q13 = new Question("5x6", "36", "32",
                "30", "34",  3,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q13);
        Question q14 = new Question("1x7", "5", "7",
                "8", "6",  2,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q14);
        Question q15 = new Question("2x7", "12", "7",
                "14", "16",  3,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q15);
        Question q16 = new Question("3x7", "18", "21",
                "24", "2",  2,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q16);
        Question q17 = new Question("4x7", "28", "27",
                "29", "26",  1,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q17);
        Question q18 = new Question("5x7", "30", "32",
                "36", "35",  4,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q18);
        Question q19 = new Question("1x8", "8", "7",
                "5", "6",  1,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q19);
        Question q20 = new Question("2x8", "14", "15",
                "16", "17",  3,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q20);
        Question q21 = new Question("3x8", "24", "26",
                "23", "22",  1,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q21);
        Question q22 = new Question("4x8", "30", "34",
                "36", "32",  4,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q22);
        Question q23 = new Question("5x8", "38", "42",
                "40", "41",  3,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q23);
        Question q24 = new Question("1x9", "8", "7",
                "9", "6",  3,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q24);
        Question q25 = new Question("2x9", "18", "17",
                "19", "16",  1,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q25);
        Question q26 = new Question("3x9", "28", "27",
                "29", "26",  2,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q26);
        Question q27 = new Question("9x3", "28", "27",
                "29", "26",  2,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q27);
        Question q28 = new Question("4x9", "38", "37",
                "39", "36",  4,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q28);
        Question q29 = new Question("5x9", "40", "44",
                "45", "46",  3,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q29);
        Question q30 = new Question("1x10", "5", "10",
                "15", "20",  2,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q30);
        Question q31 = new Question("2x10", "15", "10",
                "20", "25",  3,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q31);
        Question q32 = new Question("3x10", "30", "10",
                "20", "40",  1,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q32);
        Question q33 = new Question("4x10", "30", "40",
                "20", "50",  2,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q33);
        Question q34 = new Question("5x10", "30", "40",
                "60", "50",  4,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q34);
        Question q35 = new Question("6x10", "60", "40",
                "30", "50",  1,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q35);
        Question q36 = new Question("7x10", "60", "40",
                "70", "50",  3,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q36);
        Question q37 = new Question("9x10", "60", "70",
                "80", "90",  4,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q37);
        Question q38 = new Question("8x10", "60", "70",
                "80", "50",  3,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q38);
        Question q39 = new Question("10x10", "90", "70",
                "80", "100",  4,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q39);
        Question q40 = new Question("2x3", "9", "7",
                "8", "6",  4,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q40);
        Question q41 = new Question("2x4", "9", "7",
                "8", "6",  3,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q41);
        Question q42 = new Question("2x2", "4", "5",
                "3", "6",  1,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q42);
        Question q43 = new Question("3x3", "9", "5",
                "8", "6",  1,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q43);
        Question q44 = new Question("3x4", "9", "10",
                "12", "14",  3,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q44);
        Question q45 = new Question("6x6", "39", "38",
                "36", "34",  3,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q45);
        Question q46 = new Question("6x7", "40", "42",
                "41", "43",  2,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q46);
        Question q47 = new Question("6x8", "45", "48",
                "46", "50",  2,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q47);
        Question q48 = new Question("6x9", "54", "58",
                "56", "55",  1,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q48);
        Question q49 = new Question("7x7", "48", "49",
                "47", "50",  2,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q49);
        Question q50 = new Question("7x8", "58", "59",
                "57", "56",  4,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q50);
        Question q51 = new Question("7x9", "63", "64",
                "66", "65",  1,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q51);
        Question q52 = new Question("8x8", "63", "64",
                "66", "65",  2,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q52);
        Question q53 = new Question("8x9", "73", "74",
                "72", "71",  3,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q53);
        Question q54 = new Question("9x9", "83", "84",
                "82", "81",  4,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q54);
        Question q55 = new Question("11x1", "11", "12",
                "13", "10",  1,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q55);
        Question q56 = new Question("11x2", "22", "23",
                "20", "21",  1,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q56);
        Question q57 = new Question("11x3", "32", "33",
                "30", "31",  2,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q57);
        Question q58 = new Question("11x4", "42", "43",
                "44", "41",  3,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q58);
        Question q59 = new Question("5x11", "52", "53",
                "54", "55",  4,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q59);
        Question q60 = new Question("5x12", "60", "62",
                "65", "64",  1,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q60);
        Question q61 = new Question("4x12", "46", "47",
                "48", "49",  3,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q61);
        Question q62 = new Question("12x3", "36", "37",
                "38", "39",  1,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q62);
        Question q63 = new Question("12x2", "26", "27",
                "24", "23",  3,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q63);
        Question q64 = new Question("12x1", "11", "12",
                "14", "10",  2,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q64);
        Question q65 = new Question("13x1", "11", "12",
                "14", "13",  4,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q65);
        Question q66 = new Question("13x2", "25", "24",
                "26", "27",  3,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q66);
        Question q67 = new Question("13x3", "36", "38",
                "39", "37",  3,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q67);
        Question q68 = new Question("4x13", "50", "52",
                "51", "54",  2,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q68);
        Question q69 = new Question("5x13", "60", "70",
                "65", "75",  3,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q69);
        Question q70 = new Question("5x14", "60", "70",
                "65", "75",  2,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q70);
        Question q71 = new Question("4x14", "56", "54",
                "57", "55",  1,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q71);
        Question q72 = new Question("14x3", "40", "43",
                "42", "41",  3,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q72);
        Question q73 = new Question("14x2", "26", "30",
                "28", "27",  3,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q73);
        Question q74 = new Question("14x1", "12", "13",
                "11", "14",  4,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q74);
        Question q75 = new Question("15x1", "12", "13",
                "15", "14",  3,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q75);
        Question q76 = new Question("15x2", "30", "25",
                "35", "20",  1,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q76);
        Question q77 = new Question("15x3", "40", "45",
                "55", "50",  2,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q77);
        Question q78 = new Question("4x15", "50", "55",
                "65", "60",  4,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q78);
        Question q79 = new Question("5x15", "80", "75",
                "85", "70",  2,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q79);
        Question q80 = new Question("6x15", "80", "85",
                "95", "90",  4,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q80);
        Question q81 = new Question("16x1", "16", "15",
                "17", "18",  1,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q81);
        Question q82 = new Question("16x2", "30", "31",
                "32", "33",  3,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q82);
        Question q83 = new Question("16x3", "46", "48",
                "47", "49",  2,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q83);
        Question q84 = new Question("4x16", "64", "66",
                "65", "63",  1,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q84);
        Question q85 = new Question("5x16", "70", "80",
                "85", "90",  2,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q85);
        Question q86 = new Question("1x17", "17", "18",
                "16", "19",  1,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q86);
        Question q87 = new Question("2x17", "35", "36",
                "33", "34",  4,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q87);
        Question q88 = new Question("3x17", "50", "52",
                "53", "51",  4,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q88);
        Question q89 = new Question("17x4", "64", "66",
                "68", "62",  3,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q89);
        Question q90 = new Question("17x5", "80", "90",
                "85", "95",  3,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q90);
        Question q91 = new Question("18x5", "80", "90",
                "85", "95",  2,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q91);
        Question q92 = new Question("18x4", "70", "72",
                "74", "73",  2,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q92);
        Question q93 = new Question("18x3", "53", "55",
                "54", "56",  3,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q93);
        Question q94 = new Question("2x18", "36", "35",
                "34", "37",  1,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q94);
        Question q95 = new Question("1x18", "16", "15",
                "18", "17",  3,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q95);
        Question q96 = new Question("6x12", "71", "70",
                "72", "74",  3,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q96);
        Question q97 = new Question("6x13", "77", "78",
                "76", "74",  2,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q97);
        Question q98 = new Question("6x14", "84", "83",
                "80", "82",  1,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q98);
        Question q99 = new Question("6x11", "67", "66",
                "68", "65",  2,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q99);
        Question q100 = new Question("1x0", "1", "0",
                "2", "3",  2,  Question.CATEGORY_MULTIPLICATION);
        addQuestion(q100);
        Question q101 = new Question("1+1", "1", "2",
                "3", "4", 2, Question.CATEGORY_ADDITION);
        addQuestion(q101);
        Question q102 = new Question("2+2", "5", "2",
                "3", "4", 4, Question.CATEGORY_ADDITION);
        addQuestion(q102);
        Question q103 = new Question("2+3", "5", "2",
                "3", "4", 1, Question.CATEGORY_ADDITION);
        addQuestion(q103);
        Question q104 = new Question("2+4", "5", "7",
                "6", "4", 3, Question.CATEGORY_ADDITION);
        addQuestion(q104);
        Question q105 = new Question("5+2", "5", "7",
                "6", "8", 2, Question.CATEGORY_ADDITION);
        addQuestion(q105);
        Question q106 = new Question("3+4", "5", "7",
                "6", "8", 2, Question.CATEGORY_ADDITION);
        addQuestion(q106);
        Question q107 = new Question("3+5", "5", "7",
                "6", "8", 4, Question.CATEGORY_ADDITION);
        addQuestion(q107);
        Question q108 = new Question("3+6", "8", "7",
                "6", "9", 4, Question.CATEGORY_ADDITION);
        addQuestion(q108);
        Question q109 = new Question("3+6", "8", "7",
                "6", "9", 4, Question.CATEGORY_ADDITION);
        addQuestion(q109);
        Question q110 = new Question("3+7", "8", "10",
                "11", "9", 2, Question.CATEGORY_ADDITION);
        addQuestion(q110);
        Question q111 = new Question("8+3", "8", "10",
                "11", "9", 3, Question.CATEGORY_ADDITION);
        addQuestion(q111);
        Question q112 = new Question("9+3", "12", "10",
                "11", "13", 1, Question.CATEGORY_ADDITION);
        addQuestion(q112);
        Question q113 = new Question("4+4", "8", "10",
                "7", "9", 1, Question.CATEGORY_ADDITION);
        addQuestion(q113);
        Question q114 = new Question("4+5", "8", "10",
                "7", "9", 4, Question.CATEGORY_ADDITION);
        addQuestion(q114);
        Question q115 = new Question("4+6", "8", "10",
                "11", "9", 2, Question.CATEGORY_ADDITION);
        addQuestion(q115);
        Question q116 = new Question("4+7", "12", "10",
                "11", "13", 3, Question.CATEGORY_ADDITION);
        addQuestion(q116);
        Question q117 = new Question("4+8", "12", "10",
                "11", "13", 1, Question.CATEGORY_ADDITION);
        addQuestion(q117);
        Question q118 = new Question("9+4", "12", "10",
                "11", "13", 4, Question.CATEGORY_ADDITION);
        addQuestion(q118);
        Question q119 = new Question("5+5", "12", "10",
                "11", "9", 2, Question.CATEGORY_ADDITION);
        addQuestion(q119);
        Question q120 = new Question("5+6", "12", "10",
                "11", "9", 3, Question.CATEGORY_ADDITION);
        addQuestion(q120);
        Question q121 = new Question("5+7", "12", "10",
                "11", "9", 1, Question.CATEGORY_ADDITION);
        addQuestion(q121);
        Question q122 = new Question("5+8", "12", "14",
                "11", "13", 4, Question.CATEGORY_ADDITION);
        addQuestion(q122);
        Question q123 = new Question("5+9", "12", "14",
                "15", "13", 2, Question.CATEGORY_ADDITION);
        addQuestion(q123);
        Question q124 = new Question("6+6", "12", "14",
                "15", "13", 1, Question.CATEGORY_ADDITION);
        addQuestion(q124);
        Question q125 = new Question("6+7", "12", "14",
                "15", "13", 4, Question.CATEGORY_ADDITION);
        addQuestion(q125);
        Question q126 = new Question("6+8", "13", "16",
                "14", "15", 3, Question.CATEGORY_ADDITION);
        addQuestion(q126);
        Question q127 = new Question("6+9", "13", "16",
                "14", "15", 4, Question.CATEGORY_ADDITION);
        addQuestion(q127);
        Question q128 = new Question("7+7", "13", "16",
                "14", "15", 3, Question.CATEGORY_ADDITION);
        addQuestion(q128);
        Question q129 = new Question("7+8", "13", "16",
                "14", "15", 4, Question.CATEGORY_ADDITION);
        addQuestion(q129);
        Question q130 = new Question("7+9", "13", "16",
                "14", "15", 2, Question.CATEGORY_ADDITION);
        addQuestion(q130);
        Question q131 = new Question("9+9", "17", "16",
                "18", "19", 3, Question.CATEGORY_ADDITION);
        addQuestion(q131);
        Question q132 = new Question("8+8", "17", "16",
                "18", "19", 2, Question.CATEGORY_ADDITION);
        addQuestion(q132);
        Question q133 = new Question("8+9", "17", "16",
                "18", "19", 1, Question.CATEGORY_ADDITION);
        addQuestion(q133);
        Question q134 = new Question("1+9", "11", "12",
                "10", "9", 3, Question.CATEGORY_ADDITION);
        addQuestion(q134);
        Question q135 = new Question("1+8", "11", "12",
                "10", "9", 4, Question.CATEGORY_ADDITION);
        addQuestion(q135);
        Question q136 = new Question("1+7", "8", "7",
                "10", "9", 1, Question.CATEGORY_ADDITION);
        addQuestion(q136);
        Question q137 = new Question("1+6", "8", "7",
                "10", "9", 2, Question.CATEGORY_ADDITION);
        addQuestion(q137);
        Question q138 = new Question("1+5", "8", "7",
                "6", "5", 3, Question.CATEGORY_ADDITION);
        addQuestion(q138);
        Question q139 = new Question("4+1", "8", "7",
                "6", "5", 4, Question.CATEGORY_ADDITION);
        addQuestion(q139);
        Question q140 = new Question("3+1", "4", "7",
                "6", "5", 1, Question.CATEGORY_ADDITION);
        addQuestion(q140);
        Question q141 = new Question("11+10", "21", "20",
                "22", "23", 1, Question.CATEGORY_ADDITION);
        addQuestion(q141);
        Question q142 = new Question("11+11", "21", "20",
                "22", "23", 3, Question.CATEGORY_ADDITION);
        addQuestion(q142);
        Question q143 = new Question("11+12", "21", "20",
                "22", "23", 4, Question.CATEGORY_ADDITION);
        addQuestion(q143);
        Question q144 = new Question("11+13", "21", "24",
                "22", "23", 2, Question.CATEGORY_ADDITION);
        addQuestion(q144);
        Question q145 = new Question("14+11", "25", "24",
                "22", "23", 1, Question.CATEGORY_ADDITION);
        addQuestion(q145);
        Question q146 = new Question("15+11", "25", "24",
                "26", "27", 3, Question.CATEGORY_ADDITION);
        addQuestion(q146);
        Question q147 = new Question("16+11", "25", "28",
                "26", "27", 4, Question.CATEGORY_ADDITION);
        addQuestion(q147);
        Question q148 = new Question("17+11", "29", "28",
                "26", "27", 2, Question.CATEGORY_ADDITION);
        addQuestion(q148);
        Question q149 = new Question("18+11", "31", "28",
                "29", "30", 3, Question.CATEGORY_ADDITION);
        addQuestion(q149);
        Question q150 = new Question("19+11", "32", "28",
                "29", "30", 4, Question.CATEGORY_ADDITION);
        addQuestion(q150);
        Question q151 = new Question("12+12", "22", "24",
                "23", "25", 2, Question.CATEGORY_ADDITION);
        addQuestion(q151);
        Question q152 = new Question("12+13", "22", "24",
                "23", "25", 4, Question.CATEGORY_ADDITION);
        addQuestion(q152);
        Question q153 = new Question("12+14", "26", "24",
                "23", "25", 1, Question.CATEGORY_ADDITION);
        addQuestion(q153);
        Question q154 = new Question("12+15", "26", "28",
                "27", "25", 3, Question.CATEGORY_ADDITION);
        addQuestion(q154);
        Question q155 = new Question("16+12", "26", "28",
                "27", "29", 2, Question.CATEGORY_ADDITION);
        addQuestion(q155);
        Question q156 = new Question("17+12", "30", "28",
                "27", "29", 4, Question.CATEGORY_ADDITION);
        addQuestion(q156);
        Question q157 = new Question("18+12", "30", "28",
                "31", "29", 1, Question.CATEGORY_ADDITION);
        addQuestion(q157);
        Question q158 = new Question("19+12", "30", "32",
                "31", "29", 3, Question.CATEGORY_ADDITION);
        addQuestion(q158);
        Question q159 = new Question("20+12", "30", "32",
                "31", "33", 2, Question.CATEGORY_ADDITION);
        addQuestion(q159);
        Question q160 = new Question("13+13", "27", "26",
                "28", "25", 2, Question.CATEGORY_ADDITION);
        addQuestion(q160);
        Question q161 = new Question("13+14", "27", "26",
                "28", "29", 1, Question.CATEGORY_ADDITION);
        addQuestion(q161);
        Question q162 = new Question("13+15", "27", "30",
                "28", "29", 3, Question.CATEGORY_ADDITION);
        addQuestion(q162);
        Question q163 = new Question("13+16", "31", "30",
                "28", "29", 4, Question.CATEGORY_ADDITION);
        addQuestion(q163);
        Question q164 = new Question("17+13", "31", "30",
                "28", "29", 2, Question.CATEGORY_ADDITION);
        addQuestion(q164);
        Question q165 = new Question("18+13", "31", "30",
                "32", "29", 1, Question.CATEGORY_ADDITION);
        addQuestion(q165);
        Question q166 = new Question("19+13", "31", "30",
                "32", "33", 3, Question.CATEGORY_ADDITION);
        addQuestion(q166);
        Question q167 = new Question("20+13", "31", "34",
                "32", "33", 4, Question.CATEGORY_ADDITION);
        addQuestion(q167);
        Question q168 = new Question("14+14", "27", "28",
                "26", "29", 2, Question.CATEGORY_ADDITION);
        addQuestion(q168);
        Question q169 = new Question("14+15", "27", "28",
                "30", "29", 4, Question.CATEGORY_ADDITION);
        addQuestion(q169);
        Question q170 = new Question("14+16", "31", "28",
                "30", "29", 3, Question.CATEGORY_ADDITION);
        addQuestion(q170);
        Question q171 = new Question("17+14", "31", "32",
                "30", "29", 1, Question.CATEGORY_ADDITION);
        addQuestion(q171);
        Question q172 = new Question("18+14", "31", "32",
                "30", "33", 2, Question.CATEGORY_ADDITION);
        addQuestion(q172);
        Question q173 = new Question("19+14", "31", "32",
                "34", "33", 4, Question.CATEGORY_ADDITION);
        addQuestion(q173);
        Question q174 = new Question("20+14", "35", "36",
                "34", "33", 3, Question.CATEGORY_ADDITION);
        addQuestion(q174);
        Question q175 = new Question("15+15", "30", "31",
                "32", "33", 1, Question.CATEGORY_ADDITION);
        addQuestion(q175);
        Question q176 = new Question("16+15", "34", "31",
                "32", "33", 2, Question.CATEGORY_ADDITION);
        addQuestion(q176);
        Question q177 = new Question("17+15", "34", "31",
                "32", "33", 3, Question.CATEGORY_ADDITION);
        addQuestion(q177);
        Question q178 = new Question("18+15", "34", "35",
                "32", "33", 4, Question.CATEGORY_ADDITION);
        addQuestion(q178);
        Question q179 = new Question("19+15", "34", "35",
                "36", "33", 1, Question.CATEGORY_ADDITION);
        addQuestion(q179);
        Question q180 = new Question("20+15", "34", "35",
                "36", "37", 2, Question.CATEGORY_ADDITION);
        addQuestion(q180);
        Question q181 = new Question("16+16", "34", "32",
                "31", "33", 2, Question.CATEGORY_ADDITION);
        addQuestion(q181);
        Question q182 = new Question("16+17", "34", "32",
                "31", "33", 4, Question.CATEGORY_ADDITION);
        addQuestion(q182);
        Question q183 = new Question("16+18", "34", "32",
                "35", "33", 1, Question.CATEGORY_ADDITION);
        addQuestion(q183);
        Question q184 = new Question("16+19", "34", "36",
                "35", "33", 3, Question.CATEGORY_ADDITION);
        addQuestion(q184);
        Question q185 = new Question("16+19", "34", "36",
                "35", "33", 3, Question.CATEGORY_ADDITION);
        addQuestion(q185);
        Question q186 = new Question("16+20", "34", "36",
                "35", "37", 2, Question.CATEGORY_ADDITION);
        addQuestion(q186);
        Question q187 = new Question("17+17", "34", "36",
                "35", "33", 1, Question.CATEGORY_ADDITION);
        addQuestion(q187);
        Question q188 = new Question("18+17", "34", "36",
                "35", "37", 3, Question.CATEGORY_ADDITION);
        addQuestion(q188);
        Question q189 = new Question("19+17", "34", "36",
                "35", "37", 2, Question.CATEGORY_ADDITION);
        addQuestion(q189);
        Question q190 = new Question("20+17", "38", "36",
                "35", "37", 4, Question.CATEGORY_ADDITION);
        addQuestion(q190);
        Question q191 = new Question("18+18", "38", "36",
                "35", "37", 2, Question.CATEGORY_ADDITION);
        addQuestion(q191);
        Question q192 = new Question("19+18", "38", "36",
                "35", "37", 4, Question.CATEGORY_ADDITION);
        addQuestion(q192);
        Question q193 = new Question("20+18", "38", "36",
                "39", "37", 1, Question.CATEGORY_ADDITION);
        addQuestion(q193);
        Question q194 = new Question("19+19", "38", "36",
                "39", "37", 1, Question.CATEGORY_ADDITION);
        addQuestion(q194);
        Question q195 = new Question("20+19", "38", "36",
                "39", "37", 3, Question.CATEGORY_ADDITION);
        addQuestion(q195);
        Question q196 = new Question("20+5", "28", "26",
                "25", "24", 3, Question.CATEGORY_ADDITION);
        addQuestion(q196);
        Question q197 = new Question("20+6", "28", "26",
                "25", "24", 2, Question.CATEGORY_ADDITION);
        addQuestion(q197);
        Question q198 = new Question("20+7", "28", "26",
                "25", "27", 4, Question.CATEGORY_ADDITION);
        addQuestion(q198);
        Question q199 = new Question("20+8", "28", "26",
                "29", "27", 1, Question.CATEGORY_ADDITION);
        addQuestion(q199);
        Question q200 = new Question("1+0", "2", "3",
                "1", "0", 3, Question.CATEGORY_ADDITION);
        addQuestion(q200);
        Question q201 = new Question("10-1", "8", "9",
                "10", "11", 2, Question.CATEGORY_SUBTRACTION);
        addQuestion(q201);
        Question q202 = new Question("10-2", "8", "9",
                "10", "7", 1, Question.CATEGORY_SUBTRACTION);
        addQuestion(q202);
        Question q203 = new Question("10-3", "8", "9",
                "6", "7", 4, Question.CATEGORY_SUBTRACTION);
        addQuestion(q203);
        Question q204 = new Question("10-4", "8", "5",
                "6", "7", 3, Question.CATEGORY_SUBTRACTION);
        addQuestion(q204);
        Question q205 = new Question("10-5", "4", "5",
                "6", "7", 2, Question.CATEGORY_SUBTRACTION);
        addQuestion(q205);
        Question q206 = new Question("10-6", "4", "5",
                "6", "3", 1, Question.CATEGORY_SUBTRACTION);
        addQuestion(q206);
        Question q207 = new Question("10-7", "4", "5",
                "6", "3", 4, Question.CATEGORY_SUBTRACTION);
        addQuestion(q207);
        Question q208 = new Question("10-8", "4", "5",
                "2", "3", 3, Question.CATEGORY_SUBTRACTION);
        addQuestion(q208);
        Question q209 = new Question("10-9", "4", "1",
                "2", "3", 2, Question.CATEGORY_SUBTRACTION);
        addQuestion(q209);
        Question q210 = new Question("10-10", "0", "1",
                "2", "3", 1, Question.CATEGORY_SUBTRACTION);
        addQuestion(q210);
        Question q211 = new Question("20-10", "10", "11",
                "12", "9", 1, Question.CATEGORY_SUBTRACTION);
        addQuestion(q211);
        Question q212 = new Question("20-11", "10", "11",
                "12", "9", 4, Question.CATEGORY_SUBTRACTION);
        addQuestion(q212);
        Question q213 = new Question("20-12", "10", "8",
                "7", "9", 2, Question.CATEGORY_SUBTRACTION);
        addQuestion(q213);
        Question q214 = new Question("20-13", "6", "8",
                "7", "9", 3, Question.CATEGORY_SUBTRACTION);
        addQuestion(q214);
        Question q215 = new Question("20-14", "6", "8",
                "7", "5", 1, Question.CATEGORY_SUBTRACTION);
        addQuestion(q215);
        Question q216 = new Question("20-15", "6", "4",
                "7", "5", 4, Question.CATEGORY_SUBTRACTION);
        addQuestion(q216);
        Question q217 = new Question("20-16", "2", "4",
                "3", "5", 2, Question.CATEGORY_SUBTRACTION);
        addQuestion(q217);
        Question q218 = new Question("20-17", "2", "4",
                "3", "5", 3, Question.CATEGORY_SUBTRACTION);
        addQuestion(q218);
        Question q219 = new Question("20-18", "2", "4",
                "3", "1", 1, Question.CATEGORY_SUBTRACTION);
        addQuestion(q219);
        Question q220 = new Question("20-19", "2", "4",
                "3", "1", 4, Question.CATEGORY_SUBTRACTION);
        addQuestion(q220);
        Question q221 = new Question("20-20", "2", "0",
                "3", "1", 2, Question.CATEGORY_SUBTRACTION);
        addQuestion(q221);
        Question q222 = new Question("20-9", "12", "10",
                "13", "11", 4, Question.CATEGORY_SUBTRACTION);
        addQuestion(q222);
        Question q223 = new Question("20-8", "12", "10",
                "13", "11", 1, Question.CATEGORY_SUBTRACTION);
        addQuestion(q223);
        Question q224 = new Question("20-7", "12", "10",
                "13", "11", 3, Question.CATEGORY_SUBTRACTION);
        addQuestion(q224);
        Question q225 = new Question("20-6", "12", "10",
                "14", "11", 3, Question.CATEGORY_SUBTRACTION);
        addQuestion(q225);
        Question q226 = new Question("20-5", "17", "15",
                "14", "16", 2, Question.CATEGORY_SUBTRACTION);
        addQuestion(q226);
        Question q227 = new Question("20-4", "17", "15",
                "14", "16", 4, Question.CATEGORY_SUBTRACTION);
        addQuestion(q227);
        Question q228 = new Question("20-3", "17", "15",
                "14", "16", 1, Question.CATEGORY_SUBTRACTION);
        addQuestion(q228);
        Question q229 = new Question("20-2", "17", "15",
                "18", "16", 3, Question.CATEGORY_SUBTRACTION);
        addQuestion(q229);
        Question q230 = new Question("20-1", "17", "19",
                "18", "20", 2, Question.CATEGORY_SUBTRACTION);
        addQuestion(q230);
        Question q231 = new Question("20-0", "21", "19",
                "18", "20", 4, Question.CATEGORY_SUBTRACTION);
        addQuestion(q231);
        Question q232 = new Question("15-1", "15", "16",
                "14", "13", 3, Question.CATEGORY_SUBTRACTION);
        addQuestion(q232);
        Question q233 = new Question("15-2", "11", "12",
                "14", "13", 4, Question.CATEGORY_SUBTRACTION);
        addQuestion(q233);
        Question q234 = new Question("15-3", "11", "12",
                "14", "13", 2, Question.CATEGORY_SUBTRACTION);
        addQuestion(q234);
        Question q235 = new Question("15-4", "11", "12",
                "10", "13", 1, Question.CATEGORY_SUBTRACTION);
        addQuestion(q235);
        Question q236 = new Question("15-5", "11", "12",
                "10", "13", 3, Question.CATEGORY_SUBTRACTION);
        addQuestion(q236);
        Question q237 = new Question("15-6", "11", "8",
                "10", "9", 4, Question.CATEGORY_SUBTRACTION);
        addQuestion(q237);
        Question q238 = new Question("15-7", "7", "8",
                "6", "9", 2, Question.CATEGORY_SUBTRACTION);
        addQuestion(q238);
        Question q239 = new Question("15-8", "7", "8",
                "6", "9", 1, Question.CATEGORY_SUBTRACTION);
        addQuestion(q239);
        Question q240 = new Question("15-9", "7", "8",
                "6", "5", 3, Question.CATEGORY_SUBTRACTION);
        addQuestion(q240);
        Question q241 = new Question("15-10", "3", "4",
                "6", "5", 4, Question.CATEGORY_SUBTRACTION);
        addQuestion(q241);
        Question q242 = new Question("14-10", "3", "4",
                "6", "5", 2, Question.CATEGORY_SUBTRACTION);
        addQuestion(q242);
        Question q243 = new Question("14-11", "3", "4",
                "6", "5", 1, Question.CATEGORY_SUBTRACTION);
        addQuestion(q243);
        Question q244 = new Question("14-9", "3", "4",
                "6", "5", 4, Question.CATEGORY_SUBTRACTION);
        addQuestion(q244);
        Question q245 = new Question("14-8", "7", "4",
                "6", "5", 3, Question.CATEGORY_SUBTRACTION);
        addQuestion(q245);
        Question q246 = new Question("16-8", "7", "8",
                "9", "10", 2, Question.CATEGORY_SUBTRACTION);
        addQuestion(q246);
        Question q247 = new Question("16-9", "7", "8",
                "9", "10", 1, Question.CATEGORY_SUBTRACTION);
        addQuestion(q247);
        Question q248 = new Question("16-7", "7", "8",
                "9", "10", 3, Question.CATEGORY_SUBTRACTION);
        addQuestion(q248);
        Question q249 = new Question("16-6", "7", "8",
                "9", "10", 4, Question.CATEGORY_SUBTRACTION);
        addQuestion(q249);
        Question q250 = new Question("16-10", "7", "8",
                "5", "6", 4, Question.CATEGORY_SUBTRACTION);
        addQuestion(q250);
        Question q251 = new Question("16-11", "7", "4",
                "5", "6", 3, Question.CATEGORY_SUBTRACTION);
        addQuestion(q251);
        Question q252 = new Question("16-12", "7", "4",
                "5", "6", 2, Question.CATEGORY_SUBTRACTION);
        addQuestion(q252);
        Question q253 = new Question("16-13", "3", "4",
                "5", "6", 1, Question.CATEGORY_SUBTRACTION);
        addQuestion(q253);
        Question q254 = new Question("9-1", "8", "9",
                "10", "7", 1, Question.CATEGORY_SUBTRACTION);
        addQuestion(q254);
        Question q255 = new Question("9-2", "8", "9",
                "10", "7", 4, Question.CATEGORY_SUBTRACTION);
        addQuestion(q255);
        Question q256 = new Question("9-3", "8", "9",
                "6", "7", 3, Question.CATEGORY_SUBTRACTION);
        addQuestion(q256);
        Question q257 = new Question("9-4", "8", "5",
                "6", "7", 2, Question.CATEGORY_SUBTRACTION);
        addQuestion(q257);
        Question q258 = new Question("8-1", "8", "5",
                "6", "7", 4, Question.CATEGORY_SUBTRACTION);
        addQuestion(q258);
        Question q259 = new Question("8-2", "8", "5",
                "6", "7", 3, Question.CATEGORY_SUBTRACTION);
        addQuestion(q259);
        Question q260 = new Question("8-3", "8", "5",
                "6", "7", 2, Question.CATEGORY_SUBTRACTION);
        addQuestion(q260);
        Question q261 = new Question("12-6", "8", "5",
                "6", "7", 3, Question.CATEGORY_SUBTRACTION);
        addQuestion(q261);
        Question q262 = new Question("12-2", "14", "11",
                "12", "10", 4, Question.CATEGORY_SUBTRACTION);
        addQuestion(q262);
        Question q263 = new Question("12-3", "9", "11",
                "12", "10", 1, Question.CATEGORY_SUBTRACTION);
        addQuestion(q263);
        Question q264 = new Question("12-4", "9", "11",
                "8", "10", 3, Question.CATEGORY_SUBTRACTION);
        addQuestion(q264);
        Question q265 = new Question("12-10", "2", "1",
                "3", "0", 1, Question.CATEGORY_SUBTRACTION);
        addQuestion(q265);
        Question q266 = new Question("12-11", "2", "1",
                "3", "0", 2, Question.CATEGORY_SUBTRACTION);
        addQuestion(q266);
        Question q267 = new Question("12-9", "2", "1",
                "3", "0", 3, Question.CATEGORY_SUBTRACTION);
        addQuestion(q267);
        Question q268 = new Question("13-9", "2", "1",
                "3", "4", 4, Question.CATEGORY_SUBTRACTION);
        addQuestion(q268);
        Question q269 = new Question("13-8", "2", "5",
                "3", "4", 2, Question.CATEGORY_SUBTRACTION);
        addQuestion(q269);
        Question q270 = new Question("13-7", "6", "5",
                "7", "4", 1, Question.CATEGORY_SUBTRACTION);
        addQuestion(q270);
        Question q271 = new Question("13-6", "6", "5",
                "7", "8", 3, Question.CATEGORY_SUBTRACTION);
        addQuestion(q271);
        Question q272 = new Question("13-5", "6", "9",
                "7", "8", 4, Question.CATEGORY_SUBTRACTION);
        addQuestion(q272);
        Question q273 = new Question("13-4", "10", "9",
                "7", "8", 2, Question.CATEGORY_SUBTRACTION);
        addQuestion(q273);
        Question q274 = new Question("13-3", "10", "9",
                "11", "8", 1, Question.CATEGORY_SUBTRACTION);
        addQuestion(q274);
        Question q275= new Question("18-3", "15", "16",
                "17", "16", 1, Question.CATEGORY_SUBTRACTION);
        addQuestion(q275);
        Question q276= new Question("18-5", "15", "13",
                "14", "12", 2, Question.CATEGORY_SUBTRACTION);
        addQuestion(q276);
        Question q277= new Question("18-7", "11", "13",
                "10", "12", 1, Question.CATEGORY_SUBTRACTION);
        addQuestion(q277);
        Question q278= new Question("18-6", "11", "13",
                "10", "12", 4, Question.CATEGORY_SUBTRACTION);
        addQuestion(q278);
        Question q279= new Question("18-8", "11", "13",
                "10", "12", 3, Question.CATEGORY_SUBTRACTION);
        addQuestion(q279);
        Question q280= new Question("18-10", "8", "9",
                "10", "7", 1, Question.CATEGORY_SUBTRACTION);
        addQuestion(q280);
        Question q281= new Question("18-12", "6", "8",
                "7", "5", 1, Question.CATEGORY_SUBTRACTION);
        addQuestion(q281);
        Question q282= new Question("18-13", "6", "8",
                "7", "5", 4, Question.CATEGORY_SUBTRACTION);
        addQuestion(q282);
        Question q283= new Question("11-6", "6", "8",
                "7", "5", 4, Question.CATEGORY_SUBTRACTION);
        addQuestion(q283);
        Question q284= new Question("11-5", "6", "8",
                "7", "5", 1, Question.CATEGORY_SUBTRACTION);
        addQuestion(q284);
        Question q285= new Question("11-4", "6", "8",
                "7", "5", 3, Question.CATEGORY_SUBTRACTION);
        addQuestion(q285);
        Question q286= new Question("11-3", "6", "8",
                "7", "5", 2, Question.CATEGORY_SUBTRACTION);
        addQuestion(q286);
        Question q287= new Question("11-2", "10", "8",
                "7", "9", 4, Question.CATEGORY_SUBTRACTION);
        addQuestion(q287);
        Question q288= new Question("14-2", "10", "16",
                "13", "12", 4, Question.CATEGORY_SUBTRACTION);
        addQuestion(q288);
        Question q289= new Question("14-3", "10", "11",
                "13", "12", 2, Question.CATEGORY_SUBTRACTION);
        addQuestion(q289);
        Question q290= new Question("14-5", "10", "11",
                "9", "12", 3, Question.CATEGORY_SUBTRACTION);
        addQuestion(q290);
        Question q291= new Question("14-7", "6", "8",
                "9", "7", 4, Question.CATEGORY_SUBTRACTION);
        addQuestion(q291);
        Question q292= new Question("7-2", "6", "4",
                "5", "7", 3, Question.CATEGORY_SUBTRACTION);
        addQuestion(q292);
        Question q293= new Question("7-3", "6", "4",
                "5", "7", 2, Question.CATEGORY_SUBTRACTION);
        addQuestion(q293);
        Question q294= new Question("6-3", "6", "9",
                "3", "2", 3, Question.CATEGORY_SUBTRACTION);
        addQuestion(q294);
        Question q295= new Question("6-1", "6", "7",
                "4", "5", 4, Question.CATEGORY_SUBTRACTION);
        addQuestion(q295);
        Question q296= new Question("6-2", "6", "7",
                "4", "5", 3, Question.CATEGORY_SUBTRACTION);
        addQuestion(q296);
        Question q297= new Question("9-2", "6", "7",
                "8", "11", 2, Question.CATEGORY_SUBTRACTION);
        addQuestion(q297);
        Question q298= new Question("9-6", "4", "3",
                "5", "2", 2, Question.CATEGORY_SUBTRACTION);
        addQuestion(q298);
        Question q299= new Question("9-5", "4", "3",
                "5", "2", 1, Question.CATEGORY_SUBTRACTION);
        addQuestion(q299);
        Question q300= new Question("0-0", "1", "0",
                "3", "2", 2, Question.CATEGORY_SUBTRACTION);
        addQuestion(q300);


    }
    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(QuestionsTable.COLUMN_CATEGORY, question.getCategory());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setCategory(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_CATEGORY)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }

    public ArrayList<Question> getQuestions(String category) {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();

        String[] selectionArgs = new String[]{category};
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME +" WHERE " + QuestionsTable.COLUMN_CATEGORY + " = ?", selectionArgs);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setCategory(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_CATEGORY)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
}
