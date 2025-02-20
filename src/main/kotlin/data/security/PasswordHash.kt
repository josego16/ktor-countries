package data.security

import domain.security.PasswordHashInterface
import java.security.MessageDigest

object PasswordHash : PasswordHashInterface {
    override fun hash(passwd: String): String {
        val passArr = passwd.toByteArray()
        val md = MessageDigest.getInstance("SHA-256")
        val hashByte: ByteArray = md.digest(passArr)
        val hashHex = hashByte.joinToString("") { "%02x".format(it) }
        return hashHex
    }

    override fun verify(passwd: String, hashedPassword: String): Boolean {
        return hash(passwd) == hashedPassword
    }
}