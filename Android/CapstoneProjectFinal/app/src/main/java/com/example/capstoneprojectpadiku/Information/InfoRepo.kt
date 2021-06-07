package com.example.capstoneprojectpadiku.Information

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

class InfoRepo {

    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private val firebaseFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    fun getUser(): FirebaseUser? {
        return firebaseAuth.currentUser
    }

    fun creteUser(): Task<AuthResult> {
        return firebaseAuth.signInAnonymously()
    }

    fun getPostList(): Task<QuerySnapshot> {
        return firebaseFirestore
            .collection("penyakit_padi")
            .get()
    }
}