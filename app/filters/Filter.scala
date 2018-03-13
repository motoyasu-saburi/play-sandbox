package filters

import javax.inject._

import play.api.http.HttpFilters
import play.api.mvc._
import play.filters.headers.SecurityHeadersFilter

import scala.concurrent.ExecutionContext

@Singleton
class Filter @Inject()(
  implicit ec: ExecutionContext,
  securityHeaders: SecurityHeadersFilter
) extends EssentialFilter with HttpFilters {

  val filters = Seq(securityHeaders)

  override def apply(next: EssentialAction) = EssentialAction { request =>
    next(request).map { result =>
      result.withHeaders("X-ExampleFilter" -> "foo")
    }
  }
}