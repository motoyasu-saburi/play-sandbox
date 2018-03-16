package models
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.jdbc.MySQLProfile
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Users.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Users
   *  @param id Database column id SqlType(INT UNSIGNED), AutoInc, PrimaryKey */
  case class UsersRow(id: Long)
  /** GetResult implicit for fetching UsersRow objects using plain SQL queries */
  implicit def GetResultUsersRow(implicit e0: GR[Long]): GR[UsersRow] = GR{
    prs => import prs._
    UsersRow(<<[Long])
  }
  /** Table description of table users. Objects of this class serve as prototypes for rows in queries. */
  class Users(_tableTag: Tag) extends profile.api.Table[UsersRow](_tableTag, Some("thulcandra"), "users") {
    def * = id <> (UsersRow, UsersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = Rep.Some(id).shaped.<>(r => r.map(_=> UsersRow(r.get)), (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT UNSIGNED), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
  }
  /** Collection-like TableQuery object for table Users */
  lazy val Users = new TableQuery(tag => new Users(tag))
}
