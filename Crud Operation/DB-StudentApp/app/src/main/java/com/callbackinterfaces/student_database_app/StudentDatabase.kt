package com.callbackinterfaces.student_database_app

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Student::class], version = 1)
abstract class StudentDatabase : RoomDatabase() {
    abstract val studentDao: StudentDao

    private class PopulateDBAsyncTask(database: StudentDatabase?) : AsyncTask<Void?, Void?, Void?>() {
        private val studentDao: StudentDao
        protected override fun doInBackground(vararg params: Void?): Void? {
            studentDao.insertStudent(Student("Pallavi", "1", "LTTS-Android Studio"))
            studentDao.insertStudent(Student("Vishal", "2", "LTTS-Android Studio"))
            studentDao.insertStudent(Student("Sirisha", "3", "LTTS-Android Studio"))
            studentDao.insertStudent(Student("Harshit", "4", "LTTS-Android Studio"))
            studentDao.insertStudent(Student("Shrishti", "5", "LTTS-Android Studio"))
            return null
        }

        init {
            studentDao = database!!.studentDao
        }

    }

    companion object {
        private var database: StudentDatabase? = null
        @Synchronized
        fun retrieveInstance(context: Context?): StudentDatabase? {
            if (database == null) {
                database = Room.databaseBuilder(context!!, StudentDatabase::class.java, "student_database")
                        .addCallback(callback)
                        .fallbackToDestructiveMigrationFrom()
                        .build()
            }
            return database
        }

        private val callback: Callback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PopulateDBAsyncTask(database).execute()
            }
        }
    }
}
