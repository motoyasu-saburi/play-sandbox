package controllers

import play.api.libs.json._
import play.api.libs.functional.syntax._

object JsonController {

  implicit val usersWritesWrites: Writes[User] = (
      (__ \ "id").write[Long] and
      (__ \ "name").write[String] and
      (__ \ "companyId").writeNullable[Long]
    )(unlift(User.unapply))
}

case class User(id: Long, name: String, companyId: Option[Long])
