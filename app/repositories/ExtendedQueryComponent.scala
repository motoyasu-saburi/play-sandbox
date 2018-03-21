package utils

import slick.lifted.{CanBeQueryCondition, Query, Rep}

trait ExtendedQueryComponent {

  implicit class RichQuery[T, E, C[_]](q: Query[T, E, C]) {

    /**
      * Select all elements of this query which satisfy a predicate,
      * when specified guard condition satisfy.
      *
      * you call the following:
      * {{{
      *   Users
      *     .filterIf(param1.isDefined)(_.name is param1.bind)
      *     .filterIf(param2.isDefined)(_.flag is param2.bind)
      * }}}
      */
    def filterIf[A <: Rep[_]](guard: => Boolean)(f: T => A)(implicit wt: CanBeQueryCondition[A]): Query[T, E, C] = {
      if (guard) q.filter(f) else q
    }

    def filterIf[A <: Rep[_]](guard: Option[_])(f: T => A)(implicit wt: CanBeQueryCondition[A]): Query[T, E, C] = {
      if (guard.isDefined) q.filter(f) else q
    }

    def filterIfOrElse[A <: Rep[_]](guard: Option[_])(f1: T => A)(f2: T => A)(implicit wt: CanBeQueryCondition[A]): Query[T, E, C] = {
      if (guard.isDefined) q.filter(f1) else q.filter(f2)
    }

  }

  val ~ = Tuple2
}
