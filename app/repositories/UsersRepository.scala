package repositories

import javax.inject.Inject

import models.Tables._
import models.Tables.profile.api._

import scala.concurrent.ExecutionContext
import utils.ExtendedQueryComponent



class UsersRepository @Inject()()(
  implicit val ec: ExecutionContext
) extends ExtendedQueryComponent {

  def findUserById(id: Long): DBIO[Option[UsersRow]] = {
    Users
      .filter(v => v.id === id.bind)
      .result
      .headOption
  }
}
