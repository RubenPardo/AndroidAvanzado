package com.example.androidavanzado

data class Model(val name:String, val photoUrl:String){

    companion object{
        fun dummy():Model{
            return Model("Nombre falso","https://static.vecteezy.com/system/resources/previews/007/409/979/non_2x/people-icon-design-avatar-icon-person-icons-people-icons-are-set-in-trendy-flat-style-user-icon-set-vector.jpg")
        }
    }

}