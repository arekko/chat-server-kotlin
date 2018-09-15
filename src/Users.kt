object Users {

    val userList: HashSet<String> = hashSetOf()


    fun addUsername(username: String): Boolean {
        if (!isUsernameExist(username)) {
            userList.add(username)
            return true
        }
        return false
    }

    fun removeUsername(username: String) {
        if (isUsernameExist(username)) {
            userList.remove(username)
        }
    }

    fun isUsernameExist(username: String): Boolean {
        if (username in userList) {
            return true
        } else {
            return false
        }

    }

    fun getUserList(): List<String> {
        return userList.toList()
    }

    override fun toString(): String {
        var users = userList.toList()
        var forrmatString: String = ""
        for (i in users) {
            forrmatString += "\n $i"
        }

        return forrmatString

    }
}