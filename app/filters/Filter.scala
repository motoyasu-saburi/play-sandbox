package filters

import javax.inject.Inject

import play.api.http.HttpFilters
import play.filters.headers.SecurityHeadersFilter

class Filter @Inject() (
  securityHeaders: SecurityHeadersFilter
) extends HttpFilters {
  val filters = Seq(securityHeaders)
}