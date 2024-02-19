package com.example.calmwave

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.calmwave.screens.Community
import com.example.calmwave.screens.Forgotpassword
import com.example.calmwave.screens.Listofcommunities
import com.example.calmwave.screens.Profile
import com.example.calmwave.screens.Signup
import com.example.calmwave.screens.Volunteer
import com.example.calmwave.screens.homescreen

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
        composable("Profile") {
            Profile(navController)
        }
        composable("Volunteer") {
            Volunteer(navController)
        }




    }
}