package service

import java.util.*

class UserService {

    val allUsers = ArrayList<User>()

    init {
        allUsers.add(User("Moti", "moti0375@gmail.com"))
        allUsers.add(User("Ariel", "ariely@tikalk.com"))
        allUsers.add(User("Moshe", "moshew@tikalk.com"))
    }

    fun fetchAllUsers() : List<User>{
        return Collections.unmodifiableList(allUsers)
    }
}