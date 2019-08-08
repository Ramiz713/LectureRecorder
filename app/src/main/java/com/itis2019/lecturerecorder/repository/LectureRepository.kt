package com.itis2019.lecturerecorder.repository

import com.itis2019.lecturerecorder.entities.Lecture
import io.reactivex.Observable
import io.reactivex.Single

interface LectureRepository {

    fun getAllLectures(): Observable<List<Lecture>>

    fun getLectures(folderId: Long): Observable<List<Lecture>>

    fun getLecture(id: Long): Single<Lecture>

    fun updateLecture(lecture: Lecture): Observable<Unit>

    fun insertLecture(lecture: Lecture): Observable<Long>

    fun deleteLecture(lecture: Lecture): Observable<Unit>
}
