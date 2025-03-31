package domain.user.security

interface PasswordHashInterface {
    fun hash(passwd: String): String
    fun verify(passwd: String, hashedPassword: String): Boolean
}