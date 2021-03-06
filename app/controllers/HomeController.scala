package controllers

import javax.inject._

import play.api.mvc._
import play.api.libs.json._
import JsonController._
import repositories.UsersRepository

@Singleton
class HomeController @Inject()(
  val repository: UsersRepository
)(cc: ControllerComponents) extends AbstractController(cc) {

  def index = Action {
    Ok("")
  }

  def list = Action { implicit rs =>
    Ok(
      Json.obj("users" ->
        User(123L, "asd", Some(1L))
      )
    )
  }

}
