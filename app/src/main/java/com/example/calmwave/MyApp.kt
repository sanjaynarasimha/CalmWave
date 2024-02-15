package com.example.calmwave

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.calmwave.screens.*
import com.example.calmwave.screens.homescreen
import com.example.calmwave.screens.*

@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "homescreen") {
        composable("homescreen") {
            homescreen(navController)
        }
        composable("Community") {
            Community(navController)
        }
        composable("Forgotpassword") {
            Forgotpassword(navController)
        }
        composable("Signup") {
            Signup(navController)
        }
        composable("Listofcommunities") {
            Listofcommunities(navController)
        }
        composable("Comm") {
            Comm(navController)
        }


    }
}