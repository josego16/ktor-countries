package data.persistence.user.security

import at.favre.lib.crypto.bcrypt.BCrypt
import domain.user.security.PasswordHashInterface

object PasswordHash : PasswordHashInterface {
    override fun hash(passwd: String): String {
        return BCrypt.withDefaults().hashToString(12, passwd.toCharArray())
    }

    override fun verify(passwd: String, hashedPassword: String): Boolean {
        return BCrypt.verifyer().verify(passwd.toCharArray(), hashedPassword).verified
    }
}